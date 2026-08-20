package com.spring.springboot.app.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import com.spring.springboot.app.dto.MovieCriteria;
import com.spring.springboot.app.dto.MovieInput;
import com.spring.springboot.app.dto.Response;
import com.spring.springboot.app.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MovieController {
	
	private final MovieService movieService;
	
	@QueryMapping("getMoviesByName")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public Response getMovie(@Argument String movieName) {
		return movieService.get(movieName);
	}
	
	@QueryMapping("getMoviesByCriteria")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public Response getMovie(@Argument MovieCriteria criteria) {
		return movieService.get(criteria);
	}
	
	@QueryMapping("getAllMovies")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public Response getAllMovies(@Argument int page, @Argument int size) {
		return movieService.getAll(page, size);
	}
	
	@MutationMapping("addMovie")
	@PreAuthorize("hasRole('ADMIN')")
	public Response addMovie(@Argument MovieInput movie) {
		return movieService.add(movie);
	}
	
	@MutationMapping("updateMovie")
	@PreAuthorize("hasRole('ADMIN')")
	public Response editMovie(@Argument MovieInput movie) {
		return movieService.edit(movie);
	}
	
	@MutationMapping("deleteMovie")
	@PreAuthorize("hasRole('ADMIN')")
	public Response removeMovie(@Argument MovieInput movie) {
		return movieService.remove(movie);
	}

}
