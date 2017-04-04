package com.lucaspate.spring.samples.cache.service;

import org.springframework.stereotype.Service;

import com.lucaspate.spring.samples.cache.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String getEmailByUser(String user) {
		return userRepository.getEmail(user);
	}
	
}
