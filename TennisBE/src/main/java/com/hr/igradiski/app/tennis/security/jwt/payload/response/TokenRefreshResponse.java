package com.hr.igradiski.app.tennis.security.jwt.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenRefreshResponse {
	
	private String accessToken;
	private String refreshToken;
	private String tokenType = "Bearer";
	
	public TokenRefreshResponse(String token, String refToken) {
		this.accessToken  = token;
		this.refreshToken = refToken;
	}

}
