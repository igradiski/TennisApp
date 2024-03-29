package com.hr.igradiski.app.tennis.security.servicesImpl;


import com.hr.igradiski.app.tennis.domain.ERole;
import com.hr.igradiski.app.tennis.domain.User;
import com.hr.igradiski.app.tennis.domain.repository.jpa.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class UserDetailsSecurityImpl implements UserDetails {

	public UserDetailsSecurityImpl() {
	}

	private UserRepository userRepository;

	private Long id;

	private String username;

	private String email;

	private String password;

	private Collection<? extends GrantedAuthority> authorities;


	public static UserDetailsSecurityImpl build(User user) {

		List<GrantedAuthority> authorities = user.getUserRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole().getName().name()))
				.collect(Collectors.toList());

		Set<ERole> roles = user.getUserRoles().stream()
				.map(role -> role.getRole().getName())
				.collect(Collectors.toSet());
		UserDetailsSecurityImpl userDetailsSecurity = new UserDetailsSecurityImpl();
		userDetailsSecurity.setId(user.getId());
		userDetailsSecurity.setEmail(user.getEmail());
		userDetailsSecurity.setUsername(user.getUsername());
		userDetailsSecurity.setPassword(user.getPassword());
		userDetailsSecurity.setAuthorities(authorities);
		return userDetailsSecurity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsSecurityImpl user = (UserDetailsSecurityImpl) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
