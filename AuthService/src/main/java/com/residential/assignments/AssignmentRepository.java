package com.residential.assignments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residential.identity.UserRoleAssignment;

public interface AssignmentRepository extends JpaRepository<UserRoleAssignment , Long> {
	List<UserRoleAssignment> findByUserIdAndActiveTrue(Long userId);

}
