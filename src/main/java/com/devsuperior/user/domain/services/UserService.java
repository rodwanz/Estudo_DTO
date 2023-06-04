package com.devsuperior.user.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.user.domain.exception.EntityNotFound;
import com.devsuperior.user.domain.model.User;
import com.devsuperior.user.domain.repositories.UserRepository;

@Service
public class UserService {
		
	private static final String MSG_ENTITY_NOT_FOUND = 
			"Entity not found";
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = false)
	public User saving(User user){
		return userRepository.save(user); 
	}
	
	@Transactional(readOnly = false)
	public User seekAndFail(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFound(
						String.format(MSG_ENTITY_NOT_FOUND, id)));		
	}
}
