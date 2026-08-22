package com.spring.springboot.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.spring.springboot.app.constant.ResponseCode;
import com.spring.springboot.app.dto.LoginResponse;
import com.spring.springboot.app.dto.RegisterResponse;
import com.spring.springboot.app.dto.UserInput;
import com.spring.springboot.app.entity.User;
import com.spring.springboot.app.exception.InvalidCredentialException;
import com.spring.springboot.app.exception.UserAlreadyExistsException;
import com.spring.springboot.app.exception.UserNotFoundException;
import com.spring.springboot.app.repository.UserRepository;
import com.spring.springboot.app.security.service.MovieEngineTokenService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {

	private final MovieEngineTokenService tokenService;

	private final UserRepository userRepo;

	private final BCryptPasswordEncoder passwordEncoder;
	private final ModelMapper mapper;

	public LoginResponse login(String id, String password) {

		User user = userRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("No user found with current criteria"));

		if (passwordEncoder.matches(password, user.getPassword())) {
			Jwt token = tokenService.generate(user);
			return new LoginResponse(token.getTokenValue(), "Bearer", token.getExpiresAt().toString());
		}

		throw new InvalidCredentialException("Invalid login credentials provided");
	}

	public RegisterResponse register(UserInput userInput) {

		userRepo.findById(userInput.id()).ifPresent(_ -> {
			throw new UserAlreadyExistsException("User already present with the id: " + userInput.id());
		});

		User user = mapper.map(userInput, User.class);
		user.setPassword(passwordEncoder.encode(userInput.password()));
		userRepo.save(user);
		return new RegisterResponse(ResponseCode.SUCCESS, "User registered");
	}

}
