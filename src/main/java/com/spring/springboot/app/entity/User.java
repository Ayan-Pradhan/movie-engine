package com.spring.springboot.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@Column(name = "email")
	private String id;
	private String username;
	private String language;
	private String preference;
	private String password;
	private String role;

}
