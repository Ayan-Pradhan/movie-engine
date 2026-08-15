package com.spring.springboot.app.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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
	
	@QueryMapping("getMovieByName")
	public Response getMovie(String movieName) {
		return movieService.get(movieName);
	}
	
	@QueryMapping("getMoviesByCriteria")
	public Response getMovie(MovieCriteria criteria) {
		return movieService.get(criteria);
	}
	
	@QueryMapping("getAllMovies")
	public Response getAllMovies() {
		return movieService.getAll();
	}
	
	@MutationMapping("addMovie")
	public Response addMovie(@Argument MovieInput movie) {
		return movieService.add(movie);
	}
	
	@MutationMapping("updateMovie")
	public Response editMovie(@Argument MovieInput movie) {
		return movieService.edit(movie);
	}
	
	@MutationMapping("deleteMovie")
	public Response removeMovie(@Argument MovieInput movie) {
		return movieService.remove(movie);
	}

}
