package com.devsuperior.user.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.user.api.dto.UserDTO;
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
	public List<UserDTO> listing(){
		return toCollectionDTO(userRepository.findAll()); 
	}
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable Long id) {
		User user = userService.searchingForId(id);		
		return toDTO(user);
	}
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO adding(@RequestBody User user) {
		return toDTO(userService.saving(user));
	}
	

	private UserDTO toDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhone(user.getPhone());
		userDTO.setDocment(user.getDocument());
		return userDTO;
	}
	
	private List<UserDTO> toCollectionDTO(List<User> users){
		return users.stream()
				.map(user -> toDTO(user))
				.collect(Collectors.toList());
	}
}
