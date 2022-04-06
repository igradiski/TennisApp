package com.hr.igradiski.app.tennis.security.servicesImpl;

import com.hr.igradiski.app.tennis.domain.User;
import com.hr.igradiski.app.tennis.domain.repository.jpa.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsSecurityService implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailsSecurityService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsSecurityImpl.build(user);
	}
}