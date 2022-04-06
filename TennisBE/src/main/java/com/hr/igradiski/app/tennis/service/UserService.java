package com.hr.igradiski.app.tennis.service;

import com.hr.igradiski.app.tennis.domain.dto.UserDto;
import com.hr.igradiski.app.tennis.security.jwt.payload.request.TokenRefreshRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> userLogin(UserDto loginRequest);

    ResponseEntity<?> refreshToken(TokenRefreshRequest request);

    UserDto registerUser(UserDto signUpRequest);
}
