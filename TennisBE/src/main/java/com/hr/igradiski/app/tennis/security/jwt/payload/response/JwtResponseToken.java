package com.hr.igradiski.app.tennis.security.jwt.payload.response;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponseToken {

	private String token;
	private String type = "Bearer";
	private String refreshToken;
	private String username;
	private String email;
	private Collection<? extends GrantedAuthority> role;
	
	public JwtResponseToken(String jwt, String refTok, String userName, String email, Collection<? extends GrantedAuthority> role) {
		this.token= jwt;
		this.refreshToken = refTok;
		this.username = userName;
		this.email = email;
		this.role = role;
	}

}
