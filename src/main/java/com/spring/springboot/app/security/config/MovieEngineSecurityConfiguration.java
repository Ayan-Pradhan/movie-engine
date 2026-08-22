package com.spring.springboot.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@Configuration
public class MovieEngineSecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/graphql","/graphiql").permitAll()
					.anyRequest().authenticated())
			.oauth2ResourceServer(oauth2 -> 
					oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter())))
			.csrf(csrf -> csrf.disable())
			.formLogin(form -> form.disable());
		
		return httpSecurity.build();
	}
	
	@Bean
	JwtAuthenticationConverter jwtConverter() {
		JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
		converter.setAuthorityPrefix("ROLE_");
		converter.setAuthoritiesClaimName("role");
		
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(converter);
		
		return jwtAuthenticationConverter;
	}

}
