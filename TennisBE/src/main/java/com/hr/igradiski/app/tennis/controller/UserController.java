package com.hr.igradiski.app.tennis.controller;


import com.hr.igradiski.app.tennis.domain.dto.UserDto;
import com.hr.igradiski.app.tennis.security.jwt.payload.request.TokenRefreshRequest;
import com.hr.igradiski.app.tennis.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDto loginRequest) {

        log.info("User login request: {}",loginRequest.toString());
        return userService.userLogin(loginRequest);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshtoken( @RequestBody TokenRefreshRequest request) {

        log.info("Token refresh request{}",request.toString());
        return userService.refreshToken(request);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto signUpRequest) {

        log.info("User register request: {}",signUpRequest.toString());
        return userService.registerUser(signUpRequest);
    }

}
