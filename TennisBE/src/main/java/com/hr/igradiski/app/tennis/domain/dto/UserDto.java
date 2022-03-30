package com.hr.igradiski.app.tennis.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDto {
	
	private String name;
	
	private String surname;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private int active;
	
	private Date lastLogin;

}
