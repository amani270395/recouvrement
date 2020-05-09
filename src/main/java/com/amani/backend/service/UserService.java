package com.amani.backend.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;


import com.amani.backend.entity.User;
import com.amani.backend.repository.UserRepository;

@Service
public class UserService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public List<User> findAll() {
		return userRepository.findAll();
		
	}
	public long count() {
		return userRepository.count();
	}

	public void delete(User user) {
		userRepository.delete(user);
	}

	public void save(User user) {
		if (user == null) { 
			//For now, most operations are just passed through to the repository. The only exception is the save method, which checks for null values before attempting to save.
			LOGGER.log(Level.SEVERE,
					"Contact is null. Are you sure you have connected your form to the application?");
			return;
		}
		userRepository.save(user);
	}
}
