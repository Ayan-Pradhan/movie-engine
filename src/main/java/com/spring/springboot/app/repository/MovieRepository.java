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

	List<Movie> findByMovieName(String movieName);
	Optional<Movie> findByMid(String mid);
	@Query("SELECT m FROM Movie m WHERE (:language IS NULL OR m.language LIKE CONCAT('%',:language,'%')) AND "
			+ "(:runtime IS NULL OR m.runtime = :runtime) AND"
			+ "(:ratings IS NULL OR m.ratings = :ratings)")
	List<Movie> findByCriteria(@Param("language") String language, @Param("runtime") String runtime,@Param("ratings") Double ratings);
}
