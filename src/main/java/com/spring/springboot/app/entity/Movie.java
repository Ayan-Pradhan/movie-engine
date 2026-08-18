package com.spring.springboot.app.entity;

import com.spring.springboot.app.service.MidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, updatable = false)
	private String mid;

	private String movieName;
	private String runtime;
	private Double ratings;
	private String language;
	private String genre;
	private String description;
	
	@ManyToOne
	private Admin admin;
	
	@PrePersist
	public void generateMid() {
		if(this.mid == null) {
			this.mid = MidGenerator.generate();
		}
	}
		
}
