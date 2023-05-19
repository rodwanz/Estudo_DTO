package com.devsuperior.user.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.user.domain.model.User;
import com.devsuperior.user.domain.repositories.UserRepository;
import com.devsuperior.user.domain.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> listing(){
		return userRepository.findAll(); 
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return userService.searchingForId(id);
	}
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User adding(@RequestBody User user) {
		return userService.saving(user);
	}
}
