package com.spring.springboot.app.dto;

public record MovieCriteria(
		String language,
		String runtime,
		Double ratings
		) {}
