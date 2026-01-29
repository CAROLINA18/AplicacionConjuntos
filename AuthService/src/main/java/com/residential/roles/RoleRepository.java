package com.residential.roles;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residential.identity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	Optional<Role> findByCode(String code);
}
