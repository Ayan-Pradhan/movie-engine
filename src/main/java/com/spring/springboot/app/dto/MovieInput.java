package com.spring.springboot.app.dto;

public record MovieInput(
		String mid,
		String movieName,
		String runtime,
		Double ratings,
		String language,
		String description
		) {}
