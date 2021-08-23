package com.namratha.springboot.FirstApp.services;

import java.util.List;

import com.namratha.springboot.FirstApp.domain.User;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;

public interface UserService {

	public User createUser(User user) throws ResourceNotFoundException;
	
	public List<User> getAllUsers();
	
	public User getUserById(Integer userId) throws ResourceNotFoundException;
	
	public User updateUser(Integer userId,User user) throws ResourceNotFoundException;
	
	public void deleteUser(Integer userId) throws ResourceNotFoundException;
	
	public int updateValidEmail(String email, boolean status);
	
}
