package com.devsuperior.user.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devsuperior.user.api.dto.imput.UserImput;
import com.devsuperior.user.domain.model.User;

@Component
public class UserImputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public User toDomainObject(UserImput userDTOImput) {
		return modelMapper.map(userDTOImput, User.class);
	}

}
