package com.namratha.springboot.FirstApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namratha.springboot.FirstApp.constants.MessageConstant;
import com.namratha.springboot.FirstApp.domain.Role;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;
import com.namratha.springboot.FirstApp.repositaries.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role createRole(Role role) throws ResourceNotFoundException {
		findByRoleName(role.getRoleName());
		return roleRepository.save(role);
	}
	
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(Long roleId) throws ResourceNotFoundException {
		return findById(roleId);
	}

	@Override
	public Role updateRole(Long roleId, Role updatedRoleInfo) throws ResourceNotFoundException {
		Role role = findById(roleId);
		role.setRoleName(updatedRoleInfo.getRoleName());
		return roleRepository.save(role);
	}

	@Override
	public void deleteRole(Long roleId) throws ResourceNotFoundException {
		roleRepository.delete(findById(roleId));
	}

	private Role findByRoleName(String roleName) throws ResourceNotFoundException {
		Role role = roleRepository.findByRoleName(roleName);
		if (role != null) {
			String errorInfo = roleName + MessageConstant.ALREADY_EXISTS ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return role;
	}

	private Role findById(Long roleId) throws ResourceNotFoundException {
		Optional<Role> optionalRoleObject = roleRepository.findById(roleId);
		if (!optionalRoleObject.isPresent()) {
			String errorInfo = MessageConstant.NOT_FOUND + roleId ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return optionalRoleObject.get();

	}

}
