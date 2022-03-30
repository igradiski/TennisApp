package com.hr.igradiski.app.tennis.security.services;

import com.hr.igradiski.app.tennis.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

	RefreshToken createRefreshToken(Long id);

	Optional<RefreshToken> findByToken(String requestRefreshToken);

	RefreshToken verifyExpiration(RefreshToken tok);

}
