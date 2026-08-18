package com.spring.springboot.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class MovieServiceLoggingAspect {

	@Before("com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieSearchConfig()")
	public void logMovieSearchProcess() {
		log.info("Searching movie with given criteria");
	}
	
	@AfterReturning(pointcut = "com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieSearchConfig()", returning = "resultValue")
	public void logSuccessfulMovieSearchProcess(JoinPoint joinPoint, Object resultValue) {
		log.info("Found movie with given criteria");
	}
	
	@AfterThrowing(pointcut = "com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieSearchConfig()", throwing = "exception")
	public void logUnSuccessfulMovieSearchProcess(JoinPoint joinPoint, Exception exception) {
		log.warn("Searching unsucessful: {}", exception.getMessage());
	}
	
	

	@Before("com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieListingConfig()")
	public void logMovieListingProcess() {
		log.info("Listing all movies");
	}

	@AfterThrowing(pointcut = "com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieListingConfig()", throwing = "exception")
	public void logUnSuccessfulMovieListingProcess(JoinPoint joinPoint, Exception exception) {
		log.warn("Searching unsucessful: {}", exception.getMessage());
	}
	

	@Before("com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieAdditionConfig()")
	public void logMovieAdditionProcess() {
		log.info("Starting operation to add new movie");
	}
	
	@AfterReturning(pointcut = "com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieAdditionConfig()", returning = "resultValue")
	public void logSucessfulMovieAdditionProcess(JoinPoint joinPoint, Object resultValue) {
		log.info("Movie added sucessfully");
	}

	
	
	@Before("com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieUpdationConfig()")
	public void logMovieUpdationProcess() {
		log.info("Attempting operation to update movie with given criteria");
	}
	
	@AfterReturning(pointcut = "com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieUpdationConfig()", returning = "resultValue")
	public void logSuccessfulMovieUpdationProcess(JoinPoint joinPoint, Object resultValue) {
		log.info("Movie updated sucessfully");
	}
	
	@AfterThrowing(pointcut = "com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieUpdationConfig()", throwing = "exception")
	public void logUnSuccessfulMovieUpdationProcess(JoinPoint joinPoint, Exception exception) {
		log.warn("Updation process unsucessful: {}", exception.getMessage());
	}
	
	

	@Before("com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieDeletionConfig()")
	public void logMovieDeletionProcess() {
		log.info("Attempting operation to delete movie with given criteria");
	}
	
	@AfterReturning(pointcut = "com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieDeletionConfig()", returning = "resultValue")
	public void logSucessfulMovieDeletionProcess(JoinPoint joinPoint, Object resultValue) {
		log.info("Movie deleted sucessfully");
	}
	
	@AfterThrowing(pointcut = "com.spring.springboot.app.config.MovieServiceGlobalPointcutConfig.movieDeletionConfig()", throwing = "exception")
	public void logUnSuccessfulMovieDeletionProcess(JoinPoint joinPoint, Exception exception) {
		log.warn("Deletion process unsucessful: {}", exception.getMessage());
	}
}
