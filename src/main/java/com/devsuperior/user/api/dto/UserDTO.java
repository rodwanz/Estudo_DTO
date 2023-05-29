package com.devsuperior.user.api.dto;

import com.devsuperior.user.domain.model.User;

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
	private String email;	
	private String phone;
	private String docment;

}
