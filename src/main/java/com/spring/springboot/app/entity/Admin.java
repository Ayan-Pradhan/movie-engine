package com.spring.springboot.app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
	
	@Id
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "admin")
	private List<User> users;
	
	@OneToMany(mappedBy = "admin")
	private List<Movie> movies;

}
