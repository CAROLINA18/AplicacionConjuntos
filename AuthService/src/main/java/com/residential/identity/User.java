package com.residential.identity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false , unique = true , length = 120)
	private String email;
	
	@Column(name= "full_name", nullable = false ,length = 160)
	private String fullNme;
	
	@Column(name = "password_hash" , nullable=false , length = 200)
	private String passwordHash;
	
	@Column(nullable =false)
	private boolean enabled = true;
	
	@Column(name="create_at" , nullable = false)
	private Instant createAt =Instant.now();
	
	
}
