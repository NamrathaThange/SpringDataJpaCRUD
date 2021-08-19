package com.namratha.springboot.FirstApp.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
		getUserByEmail(user.getEmail());
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer userId) throws ResourceNotFoundException {
		return findById(userId);
	}

	@Override
	public User updateUser(Integer userId,User updatedUser)throws ResourceNotFoundException {
		User user = findById(userId);
		user.setFirstName(updatedUser.getFirstName());
		user.setLastName(updatedUser.getLastName());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer userId) throws ResourceNotFoundException {
		User user = findById(userId);
		userRepository.delete(user);
	}

	private User getUserByEmail(String email) throws ResourceNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			String errorInfo = email + MessageConstant.ALREADY_EXISTS ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return user;
	}

	private User findById(Integer userId) throws ResourceNotFoundException {
		Optional<User> optionaluserObject = userRepository.findById(userId);
		if (!optionaluserObject.isPresent()) {
			String errorInfo = MessageConstant.NOT_FOUND + userId ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return optionaluserObject.get();

	}
	
	
	@Override
	public int updateValidEmail(String email, int status) {
		return userRepository.updateValidEmail(email,status);
	}

}
