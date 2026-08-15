package com.spring.springboot.app.dto;

import java.util.List;

public record MovieInput(
		String mid,
		String movieName,
		String runtime,
		Double ratings,
		List<String> language,
		String description
		) {}
