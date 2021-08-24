package com.namratha.springboot.FirstApp.services;

import java.util.List;

import com.namratha.springboot.FirstApp.domain.Privilege;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;

public interface PrivilegeService {

	Privilege createPrivilege(Privilege privilege) throws ResourceNotFoundException;

	List<Privilege> getAllPrivileges();

	Privilege getPrivilegeById(Long privilegeId) throws ResourceNotFoundException;

	Privilege updatePrivilege(Long privilegeId, Privilege updatedPrivilegeInfo) throws ResourceNotFoundException;

	void deletePrivilege(Long privilegeId) throws ResourceNotFoundException;
	
}
