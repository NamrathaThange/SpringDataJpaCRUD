package com.namratha.springboot.FirstApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namratha.springboot.FirstApp.constants.MessageConstant;
import com.namratha.springboot.FirstApp.domain.User;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;
import com.namratha.springboot.FirstApp.repositaries.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) throws ResourceNotFoundException {
		findByEmail(user.getEmail());
		return userRepository.save(user);
	}
	

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long userId) throws ResourceNotFoundException {
		return findById(userId);
	}

	@Override
	public User updateUser(Long userId,User updatedUser)throws ResourceNotFoundException {
		User user = findById(userId);
		user.setFirstName(updatedUser.getFirstName());
		user.setLastName(updatedUser.getLastName());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) throws ResourceNotFoundException {
		userRepository.delete(findById(userId));
	}

	private User findByEmail(String email) throws ResourceNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			String errorInfo = email + MessageConstant.ALREADY_EXISTS ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return user;
	}

	private User findById(Long userId) throws ResourceNotFoundException {
		Optional<User> optionaluserObject = userRepository.findById(userId);
		if (!optionaluserObject.isPresent()) {
			String errorInfo = MessageConstant.NOT_FOUND + userId ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return optionaluserObject.get();
	}
	
	@Override
	public int updateValidEmail(String email, boolean status) {
		System.out.println("status "+status+" email:"+email);
		return userRepository.updateValidEmail(email,status);
		
	}

}
