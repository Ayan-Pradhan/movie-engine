package com.spring.springboot.app.dto;

public record LoginResponse(
		String accessToken,
		String tokenType,
		long expiry
		) {}
