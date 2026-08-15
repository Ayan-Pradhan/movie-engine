package com.spring.springboot.app.service;

import java.util.UUID;

public class MidGenerator {
	
	public static String generate() {
		return "MOV-" + UUID.randomUUID().toString().substring(0,10);
	}

}
