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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namratha.springboot.FirstApp.domain.Role;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;
import com.namratha.springboot.FirstApp.services.RoleServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/roles")
@RestController
@Tag(name = "Roles", description = "Roles API")
public class RoleController {
	
	@Autowired
	private RoleServiceImpl  roleService;
	
	@PostMapping
	public ResponseEntity<Role> addRole(@RequestBody Role role) throws ResourceNotFoundException {
		return new ResponseEntity<Role>(roleService.createRole(role), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Role>> getAllRoles() {
		return new ResponseEntity<List<Role>>(roleService.getAllRoles(), HttpStatus.OK);
	}
	
	@GetMapping("{roleId}")
	public ResponseEntity<Role> getRoleById(@PathVariable Long roleId) throws ResourceNotFoundException {
		return new ResponseEntity<Role>(roleService.getRoleById(roleId), HttpStatus.OK);
	}
	
	@PutMapping("{roleId}")
	public ResponseEntity<Role> updateRole(@RequestBody Role role,@PathVariable Long roleId) throws ResourceNotFoundException {
		return new ResponseEntity<Role>(roleService.updateRole(roleId,role), HttpStatus.OK);
	}
	
	@DeleteMapping("{roleId}")
	public ResponseEntity<String> deleteRole(@PathVariable Long roleId) throws ResourceNotFoundException {
		roleService.deleteRole(roleId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}	

}
