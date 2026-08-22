package com.spring.springboot.app.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.spring.springboot.app.dto.LoginResponse;
import com.spring.springboot.app.dto.RegisterResponse;
import com.spring.springboot.app.dto.UserInput;
import com.spring.springboot.app.service.AuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private final AuthService authService;
	
	@MutationMapping("login")
	public LoginResponse loginUser(@Argument String id, @Argument String password) {
		return authService.login(id, password);
	}
	
	@MutationMapping("register")
	public RegisterResponse registerUser(@Argument UserInput userInput) {
		return authService.register(userInput);
	}
	
}
