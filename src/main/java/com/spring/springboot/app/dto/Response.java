package com.spring.springboot.app.dto;

import com.spring.springboot.app.constant.ResponseCode;

public record Response(
		ResponseCode code,
		Object payload
		) {}
