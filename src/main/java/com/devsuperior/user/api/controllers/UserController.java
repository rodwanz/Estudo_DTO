package com.devsuperior.user.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.user.api.assembler.UserDTOAssembler;
import com.devsuperior.user.api.assembler.UserImputDisassembler;
import com.devsuperior.user.api.dto.UserDTO;
import com.devsuperior.user.api.dto.imput.UserImput;
import com.devsuperior.user.domain.exception.DataInUse;
import com.devsuperior.user.domain.exception.EntityNotFound;
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
	
	@Autowired
	private UserDTOAssembler userDTOAssembler;
	
	@Autowired
	private UserImputDisassembler userImputDisassembler;
	
	@GetMapping
	public List<UserDTO> listing(){
		return userDTOAssembler.toCollectionDTO(userRepository.findAll()); 
	}
	
	@GetMapping("/{id}")
	public UserDTO search(@PathVariable Long id) {
		User user = userService.seekAndFail(id);		
		return userDTOAssembler.toDTO(user);
	}
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO adding(@RequestBody @Valid UserImput userDTOImput) {
		try {
			 User user = userImputDisassembler.toDomainObject(userDTOImput);
		     return userDTOAssembler.toDTO(userService.saving(user));
		}catch (EntityNotFound e) {
			throw new DataInUse(e.getMessage());
		}
	}
}
