package com.spring.springboot.app.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.springboot.app.entity.User;
import com.spring.springboot.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieEngineUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = userRepository.findById(id)
								.orElseThrow(() -> new UsernameNotFoundException("User not found: "+id));
	
		return  org.springframework.security.core.userdetails.User
				.withUsername(user.getId())
				.password(user.getPassword())
				.roles(user.getRole())
				.build();
	}

}
