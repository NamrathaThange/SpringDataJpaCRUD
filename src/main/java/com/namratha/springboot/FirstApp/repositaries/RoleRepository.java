package com.namratha.springboot.FirstApp.repositaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namratha.springboot.FirstApp.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {

	Role findByRoleName(String roleName);

}
