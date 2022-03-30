package com.hr.igradiski.app.tennis.service.impl;

import com.hr.igradiski.app.tennis.domain.dto.UserDto;
import com.hr.igradiski.app.tennis.security.jwt.payload.request.TokenRefreshRequest;
import com.hr.igradiski.app.tennis.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Override
    @Transactional
    public ResponseEntity<?> userLogin(UserDto loginRequest) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<?> refreshToken(TokenRefreshRequest request) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<?> registerUser(UserDto signUpRequest) {
        return null;
    }
}
