package com.spring.springboot.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.springboot.app.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	Optional<Movie> findByMovieName(String movieName);
	Optional<Movie> findByMid(String mid);
	@Query("SELECT m FROM Movie m WHERE (m.language IS NULL OR m.language = :language) AND "
			+ "(m.runtime IS NULL OR m.runtime = :runtime) AND"
			+ "(m.ratings IS NULL OR m.ratings = :ratings)")
	List<Movie> findByCriteria(@Param("language") String language, @Param("runtime") String runtime,@Param("ratings") Double ratings);
}
