package com.spring.springboot.app.exception.handler;

import java.util.Map;

import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.spring.springboot.app.constant.ResponseCode;
import com.spring.springboot.app.exception.InvalidCredentialException;
import com.spring.springboot.app.exception.MovieNotFoundException;
import com.spring.springboot.app.exception.UserAlreadyExistsException;
import com.spring.springboot.app.exception.UserNotFoundException;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;

@ControllerAdvice
public class MovieEngineExceptionHandler {

	@GraphQlExceptionHandler(MovieNotFoundException.class)
	public GraphQLError handleMovieNotFound(GraphqlErrorBuilder<?> errorBuilder, MovieNotFoundException ex) {
		return errorBuilder
				.errorType(ErrorType.NOT_FOUND)
				.message(ex.getMessage())
				.extensions(Map.of(
						"code", ResponseCode.NOT_FOUND.toString()
						))
				.build();
	}
	
	@GraphQlExceptionHandler(InvalidCredentialException.class)
	public GraphQLError handleMovieNotFound(GraphqlErrorBuilder<?> errorBuilder, InvalidCredentialException ex) {
		return errorBuilder
				.errorType(ErrorType.BAD_REQUEST)
				.message(ex.getMessage())
				.extensions(Map.of(
						"code", ResponseCode.NOT_FOUND.toString()
						))
				.build();
	}
	
	@GraphQlExceptionHandler(UserNotFoundException.class)
	public GraphQLError handleUserNotFound(GraphqlErrorBuilder<?> errorBuilder, UserNotFoundException ex) {
		return errorBuilder
				.errorType(ErrorType.NOT_FOUND)
				.message(ex.getMessage())
				.extensions(Map.of(
						"code", ResponseCode.NOT_FOUND.toString()
						))
				.build();
	}
	
	@GraphQlExceptionHandler(UserAlreadyExistsException.class)
	public GraphQLError handleUserAlreadyExists(GraphqlErrorBuilder<?> errorBuilder, UserAlreadyExistsException ex) {
		return errorBuilder
				.errorType(ErrorType.BAD_REQUEST)
				.message(ex.getMessage())
				.extensions(Map.of(
						"code", ResponseCode.ERROR.toString()
						))
				.build();
	}
	
	@GraphQlExceptionHandler(Exception.class)
	public GraphQLError handleError(GraphqlErrorBuilder<?> errorBuilder, Exception ex) {
		return errorBuilder
				.errorType(ErrorType.INTERNAL_ERROR)
				.message(ex.getMessage())
				.extensions(Map.of(
						"code", ResponseCode.ERROR.toString()
						))
				.build();
	}
	

	
	

}
