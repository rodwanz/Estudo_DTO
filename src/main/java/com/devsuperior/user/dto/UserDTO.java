package com.devsuperior.user.dto;

import com.devsuperior.user.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Long id;
	private String name;
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
	}

}
