package com.namratha.springboot.FirstApp.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.namratha.springboot.FirstApp.domain.Privilege;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;
import com.namratha.springboot.FirstApp.services.PrivilegeSeriveImpl;

@RestController
public class PrivilegeController {
	
	@Autowired
	private PrivilegeSeriveImpl  privilegeService;
	
	@PostMapping("/privileges")
	public ResponseEntity<Privilege> addPrivilege(@RequestBody Privilege privilege) throws ResourceNotFoundException {
		return new ResponseEntity<Privilege>(privilegeService.createPrivilege(privilege), HttpStatus.CREATED);
	}
	
	@GetMapping("/privileges")
	public ResponseEntity<List<Privilege>> getAllPrivileges() {
		return new ResponseEntity<List<Privilege>>(privilegeService.getAllPrivileges(), HttpStatus.OK);
	}
	
	@GetMapping("/privileges/{privilegeId}")
	public ResponseEntity<Privilege> getPrivilegeById(@PathVariable Long privilegeId) throws ResourceNotFoundException {
		return new ResponseEntity<Privilege>(privilegeService.getPrivilegeById(privilegeId), HttpStatus.OK);
	}
	
	@PutMapping("/privileges/{privilegeId}")
	public ResponseEntity<Privilege> updatePrivilege(@RequestBody Privilege privilege,@PathVariable Long privilegeId) throws ResourceNotFoundException {
		return new ResponseEntity<Privilege>(privilegeService.updatePrivilege(privilegeId,privilege), HttpStatus.OK);
	}
	
	@DeleteMapping("/privileges/{privilegeId}")
	public ResponseEntity<String> deletePrivilege(@PathVariable Long privilegeId) throws ResourceNotFoundException {
		privilegeService.deletePrivilege(privilegeId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}	

}