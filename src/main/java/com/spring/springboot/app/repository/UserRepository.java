package com.spring.springboot.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.springboot.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	Optional<User> findByIdAndPassword(String id, String password);

}
