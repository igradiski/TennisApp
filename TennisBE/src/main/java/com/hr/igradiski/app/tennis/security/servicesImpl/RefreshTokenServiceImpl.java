package com.hr.igradiski.app.tennis.security.servicesImpl;


import com.hr.igradiski.app.tennis.domain.RefreshToken;
import com.hr.igradiski.app.tennis.domain.repository.jpa.RefreshTokenRepository;
import com.hr.igradiski.app.tennis.domain.repository.jpa.UserRepository;
import com.hr.igradiski.app.tennis.exception.TokenRefreshException;
import com.hr.igradiski.app.tennis.security.services.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

	//todo stavit u yamlicu
	@Value("${Vine.app.jwt.jwtRefreshExpirationMs}")
	private Long refreshTokenDurationMs=150000L;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Autowired
	private UserRepository userRepository;

	
	public Optional<RefreshToken> findByToken(String token) {
	    return refreshTokenRepository.findByToken(token);
	  }
	
	
	@Override
	@Transactional
	public RefreshToken createRefreshToken(Long id) {

		RefreshToken refreshToken = checkIfTokenExistAndLegit(id);
		if(refreshToken == null){
			RefreshToken newRefreshToken = new RefreshToken();
			newRefreshToken.setUser(userRepository.findById(id).get());
			newRefreshToken.setExpire(Instant.now().plusMillis(refreshTokenDurationMs));
			newRefreshToken.setToken(UUID.randomUUID().toString());
			newRefreshToken = refreshTokenRepository.save(newRefreshToken);
			return newRefreshToken;
		}
		else{
			return refreshToken;
		}
	}

	private RefreshToken checkIfTokenExistAndLegit(Long id) {

		RefreshToken token = refreshTokenRepository.findByUser(userRepository.findById(id).get());
		if(token != null) {
			if (token.getExpire().compareTo(Instant.now()) < 0) {
				refreshTokenRepository.delete(token);
				return null;
			}
			return token;
		}else {
			return null;
		}
	}

	@Transactional
	public RefreshToken verifyExpiration(RefreshToken token) {
		if (token.getExpire().compareTo(Instant.now()) < 0) {
	      refreshTokenRepository.delete(token);
	      throw new TokenRefreshException(token.getToken(), "Istekao Vam je token, Prijavite se ponovno!");
	    }
	    return token;
	  }
}