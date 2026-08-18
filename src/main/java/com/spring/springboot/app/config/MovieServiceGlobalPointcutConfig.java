package com.spring.springboot.app.config;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieServiceGlobalPointcutConfig {
	
	@Pointcut("execution(* com.spring.springboot.app.service.MovieService.get(..))")
	public void movieSearchConfig() {};
	
	@Pointcut("execution(* com.spring.springboot.app.service.MovieService.getAll(..))")
	public void movieListingConfig() {};
	
	@Pointcut("execution(* com.spring.springboot.app.service.MovieService.add(..))")
	public void movieAdditionConfig() {};
	
	@Pointcut("execution(* com.spring.springboot.app.service.MovieService.edit(..))")
	public void movieUpdationConfig() {};
	
	@Pointcut("execution(* com.spring.springboot.app.service.MovieService.remove(..))")
	public void movieDeletionConfig() {};

}
