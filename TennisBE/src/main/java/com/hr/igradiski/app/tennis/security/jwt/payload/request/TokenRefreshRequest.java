package com.hr.igradiski.app.tennis.security.jwt.payload.request;

import javax.validation.constraints.NotBlank;

public class TokenRefreshRequest {

	@NotBlank
	private String refreshToken;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
