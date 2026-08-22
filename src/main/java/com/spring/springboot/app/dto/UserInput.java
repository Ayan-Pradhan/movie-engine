package com.spring.springboot.app.dto;

public record UserInput(
	String id,
	String username,
	String language,
	String preference,
	String password,
	String role
		) {}
