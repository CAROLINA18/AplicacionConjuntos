package com.residential.identity;

import java.time.Instant;

import com.residential.assignments.ScopeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_role_assignments")
@Getter
@Setter
public class UserRoleAssignment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="role_id")
	private Role role;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "scope_Type" , nullable =false ,length=20)
	private ScopeType scopeType;
	
	@Column(name = "scope_ref_id")
	private Long scopeRefId; //es null si tiene permiso para todo
	
	@Column(nullable = false)
	private boolean active =true;

	@Column(name="created_at", nullable =false)
	private Instant createdAt=Instant.now();
	
	@Column(name = "created_by")
	private Long createdBy;
	
	
}
