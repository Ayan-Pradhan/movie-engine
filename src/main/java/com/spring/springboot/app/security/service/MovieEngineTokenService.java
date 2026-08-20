package com.spring.springboot.app.security.service;

import java.time.Instant;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.spring.springboot.app.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieEngineTokenService {
	
	private final JwtEncoder jwtEncoder;
	
	private Jwt createToken(User user) {
		var claims = JwtClaimsSet.builder()
				.issuer("self")
				.issuedAt(Instant.now())
				.expiresAt(Instant.now().plusSeconds(60*60))
				.subject(user.getId())
				.claim("scope",user.getRole())
				.build();
		
		return jwtEncoder.encode(JwtEncoderParameters.from(claims));
	}
	
	public Jwt generate(User user) {
		return createToken(user);
	}

}
