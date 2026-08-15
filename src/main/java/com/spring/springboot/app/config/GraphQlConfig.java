package com.spring.springboot.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@Configuration
public class GraphQlConfig {
	
	@Bean
	RuntimeWiringConfigurer runtimeWiringConfigurer() {
		
		GraphQLScalarType doubleScalar = GraphQLScalarType.newScalar(ExtendedScalars.GraphQLBigDecimal)
				.name("Double")
				.build();
		
		return wiringBuilder -> wiringBuilder
				.scalar(doubleScalar);
	}

}
