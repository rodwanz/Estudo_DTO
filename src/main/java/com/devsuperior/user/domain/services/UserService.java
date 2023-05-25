package com.devsuperior.user.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.user.domain.exception.EntidadeNaoEncontrada;
import com.devsuperior.user.domain.model.User;
import com.devsuperior.user.domain.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = false)
	public User saving(User user){
		return userRepository.save(user); 
	}
	
	@Transactional(readOnly = false)
	public User searchingForId(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontrada("Usuario não encontado!"));		
	}
}
