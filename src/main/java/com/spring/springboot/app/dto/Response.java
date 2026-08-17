package com.spring.springboot.app.dto;

import java.util.List;

import com.spring.springboot.app.constant.ResponseCode;
import com.spring.springboot.app.entity.Movie;

public record Response(
		ResponseCode code,
		List<Movie> payload
		) {}
