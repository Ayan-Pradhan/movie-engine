package com.spring.springboot.app.service;

import org.springframework.stereotype.Service;

import com.spring.springboot.app.dto.MovieCriteria;
import com.spring.springboot.app.dto.MovieInfo;
import com.spring.springboot.app.dto.Response;
import com.spring.springboot.app.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieService {
	
	private final MovieRepository movieRepo;
	
	public Response getMovie(String movieName) {
		return null;
	}
	
	public Response getMovie(MovieCriteria criteria) {
		return null;
	}

	public Response getAllMovie() {
		return null;
	}
	
	public Response add(MovieInfo info) {
		return null;
	}
	
	public Response edit(MovieInfo info) {
		return null;
	}
	
	public Response remove(MovieInfo info) {
		return null;
	}
	
	
}
