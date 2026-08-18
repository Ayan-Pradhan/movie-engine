package com.spring.springboot.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.springboot.app.constant.ResponseCode;
import com.spring.springboot.app.dto.MovieCriteria;
import com.spring.springboot.app.dto.MovieInput;
import com.spring.springboot.app.dto.Response;
import com.spring.springboot.app.entity.Movie;
import com.spring.springboot.app.exception.MovieNotFoundException;
import com.spring.springboot.app.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieService {
	
	private final MovieRepository movieRepo;
	private final ModelMapper mapper;
	
	public Response get(String movieName) {
		List<Movie> movies =  movieRepo.findByMovieName(movieName);
		if(movies.isEmpty())
			throw new MovieNotFoundException("No movie found with name: "+movieName);
		
		return new Response(ResponseCode.FOUND, movies);
	}
	
	public Response get(MovieCriteria criteria) {
		List<Movie> movies = movieRepo.findByCriteria(criteria.language(), criteria.runtime(), criteria.ratings());
		if(movies.isEmpty())
			throw new MovieNotFoundException("No movie found with the given criteria");
		
		return new Response(ResponseCode.FOUND, movies);
	}

	public Response getAll(int page, int size) {
		
		if(size > 50)
			size = 50;
		
		if(size < 1)
			size = 10;
		
		if(page < 0)
			page = 0;
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Movie> moviePage = movieRepo.findAll(pageable);
		
		if(moviePage.isEmpty())
			throw new MovieNotFoundException("No movie found");
		
		return new Response(ResponseCode.FOUND, moviePage.toList());
	}
	
	public Response add(MovieInput movieInput) {
		Movie movie = mapper.map(movieInput, Movie.class);
		return new Response(ResponseCode.SUCCESS, List.of(movieRepo.save(movie)));
	}
	
	public Response edit(MovieInput movieInput) {
		return movieRepo.findByMid(movieInput.mid())
			.map(existing->{
				mapper.map(movieInput, existing);
				return new Response(ResponseCode.SUCCESS, List.of(movieRepo.save(existing)));
			})
			.orElseThrow(()-> new MovieNotFoundException("No movie found with id: "+movieInput.mid()));
		
	}
	
	public Response remove(MovieInput movieInput) {
		Movie movie = movieRepo.findByMid(movieInput.mid()).orElseThrow(()-> new MovieNotFoundException("No movie found with id: "+movieInput.mid()));
		movieRepo.delete(movie);
		return new Response(ResponseCode.SUCCESS, new ArrayList<>());
	}
	
	
}
