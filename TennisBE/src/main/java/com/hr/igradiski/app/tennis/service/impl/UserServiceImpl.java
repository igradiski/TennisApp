package com.hr.igradiski.app.tennis.service.impl;

import com.hr.igradiski.app.tennis.domain.RefreshToken;
import com.hr.igradiski.app.tennis.domain.User;
import com.hr.igradiski.app.tennis.domain.dto.UserDto;
import com.hr.igradiski.app.tennis.domain.repository.jpa.UserRepository;
import com.hr.igradiski.app.tennis.exception.ObjectAlreadyExists;
import com.hr.igradiski.app.tennis.exception.TokenRefreshException;
import com.hr.igradiski.app.tennis.security.jwt.JwtUtils;
import com.hr.igradiski.app.tennis.security.jwt.payload.request.TokenRefreshRequest;
import com.hr.igradiski.app.tennis.security.jwt.payload.response.JwtResponseToken;
import com.hr.igradiski.app.tennis.security.jwt.payload.response.TokenRefreshResponse;
import com.hr.igradiski.app.tennis.security.services.RefreshTokenService;
import com.hr.igradiski.app.tennis.security.servicesImpl.UserDetailsSecurityImpl;
import com.hr.igradiski.app.tennis.service.UserService;
import com.hr.igradiski.app.tennis.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenService refreshTokenService;
    private final JwtUtils jwtUtils;
    private final UserMapper userMapper;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, RefreshTokenService refreshTokenService, JwtUtils jwtUtils, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.refreshTokenService = refreshTokenService;
        this.jwtUtils = jwtUtils;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public ResponseEntity<?> userLogin(UserDto loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsSecurityImpl userDetails = (UserDetailsSecurityImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
        return ResponseEntity.ok(new JwtResponseToken(jwt,refreshToken.getToken(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getAuthorities()));
    }

    @Override
    public ResponseEntity<?> refreshToken(TokenRefreshRequest request) {

        String requestRefreshToken = request.getRefreshToken();
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @Override
    @Transactional
    public UserDto registerUser(UserDto signUpRequest) {

        if(userRepository.existsByUsernameOrEmail(signUpRequest.getUsername(),signUpRequest.getEmail())){
            logger.error("Name or mail already exists!");
            throw new ObjectAlreadyExists("Name:"+signUpRequest.getUsername()
                    +" or mail"+signUpRequest.getEmail()+" already exists!");
        }
        User user = userMapper.toEntity(signUpRequest);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setActive(false);
        return userMapper.toDto(userRepository.save(user));
    }
}
