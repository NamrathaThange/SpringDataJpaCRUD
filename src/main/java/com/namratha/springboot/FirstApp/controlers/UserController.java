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

import com.namratha.springboot.FirstApp.domain.User;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;
import com.namratha.springboot.FirstApp.services.UserServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/users")
@RestController
@Tag(name = "Users", description = "Users API")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) throws ResourceNotFoundException {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") Long userId) throws ResourceNotFoundException {
		return new ResponseEntity<User>(userService.updateUser(userId,user), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) throws ResourceNotFoundException {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
	@PutMapping("{email}/{status}")
	public ResponseEntity<String> updateValidEmail(@PathVariable boolean status,@PathVariable String email) throws ResourceNotFoundException {
		userService.updateValidEmail(email, status);
		return new ResponseEntity<String>("status updated Sucessfully", HttpStatus.OK);
	}
	
}
