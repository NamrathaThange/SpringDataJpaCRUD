package com.namratha.springboot.FirstApp.services;

import java.util.List;

import com.namratha.springboot.FirstApp.domain.Role;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;

public interface RoleService {

	Role createRole(Role role) throws ResourceNotFoundException;

	List<Role> getAllRoles();

	Role getRoleById(Long roleId) throws ResourceNotFoundException;

	Role updateRole(Long roleId, Role updatedRoleInfo) throws ResourceNotFoundException;

	void deleteRole(Long roleId) throws ResourceNotFoundException;

}
