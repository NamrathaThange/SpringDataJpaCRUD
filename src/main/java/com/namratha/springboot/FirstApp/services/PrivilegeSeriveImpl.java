package com.namratha.springboot.FirstApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namratha.springboot.FirstApp.constants.MessageConstant;
import com.namratha.springboot.FirstApp.domain.Privilege;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;
import com.namratha.springboot.FirstApp.repositaries.PrivilegeRepository;

@Service
public class PrivilegeSeriveImpl implements PrivilegeService {
	
	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@Override
	public Privilege createPrivilege(Privilege privilege) throws ResourceNotFoundException {
		findByPrivilegeName(privilege.getPrivilegeName());
		return privilegeRepository.save(privilege);
	}
	
	@Override
	public List<Privilege> getAllPrivileges() {
		return privilegeRepository.findAll();
	}

	@Override
	public Privilege getPrivilegeById(Long privilegeId) throws ResourceNotFoundException {
		return findById(privilegeId);
	}

	@Override
	public Privilege updatePrivilege(Long privilegeId, Privilege updatedPrivilegeInfo) throws ResourceNotFoundException {
		Privilege privilege = findById(privilegeId);
		privilege.setPrivilegeName(updatedPrivilegeInfo.getPrivilegeName());
		return privilegeRepository.save(privilege);
	}

	@Override
	public void deletePrivilege(Long privilegeId) throws ResourceNotFoundException {
		privilegeRepository.delete(findById(privilegeId));
	}

	private Privilege findByPrivilegeName(String privilegeName) throws ResourceNotFoundException {
		Privilege privilege = privilegeRepository.findByPrivilegeName(privilegeName);
		if (privilege != null) {
			String errorInfo = privilegeName + MessageConstant.ALREADY_EXISTS ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return privilege;
	}

	private Privilege findById(Long privilegeId) throws ResourceNotFoundException {
		Optional<Privilege> optionalPrvilegeObject = privilegeRepository.findById(privilegeId);
		if (!optionalPrvilegeObject.isPresent()) {
			String errorInfo = MessageConstant.NOT_FOUND + privilegeId ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return optionalPrvilegeObject.get();

	}

}
