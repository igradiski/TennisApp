package com.hr.igradiski.app.tennis.controller;


import com.hr.igradiski.app.tennis.domain.dto.UserDto;
import com.hr.igradiski.app.tennis.security.jwt.payload.request.TokenRefreshRequest;
import com.hr.igradiski.app.tennis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDto loginRequest) {

        logger.info("User login request: {}",loginRequest.toString());
        return userService.userLogin(loginRequest);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshtoken( @RequestBody TokenRefreshRequest request) {

        logger.info("Token refresh request{}",request.toString());
        return userService.refreshToken(request);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto signUpRequest) {

        logger.info("User register request: {}",signUpRequest.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(signUpRequest));
    }

}
