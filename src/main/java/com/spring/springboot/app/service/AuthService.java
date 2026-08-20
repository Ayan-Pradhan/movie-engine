package com.spring.springboot.app.service;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.spring.springboot.app.dto.LoginResponse;
import com.spring.springboot.app.entity.User;
import com.spring.springboot.app.exception.UserNotFoundException;
import com.spring.springboot.app.repository.UserRepository;
import com.spring.springboot.app.security.service.MovieEngineTokenService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {
	
	private final MovieEngineTokenService tokenService;
	private final UserRepository userRepo;
	
	public LoginResponse login(String id, String password) {
	
		User user = userRepo.findByIdAndPassword(id, password)
							.orElseThrow(() -> new UserNotFoundException("No user found with current criteria"));
		
		Jwt token = tokenService.generate(user);
		
		return new LoginResponse(token.getTokenValue(),
								"Bearer",
								token.getExpiresAt().toString());
	}

}
