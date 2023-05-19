package com.devsuperior.user.api.dto;

import java.time.Instant;

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
	private String cpf;
	private Instant birthDate;	
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
		cpf = user.getCpf();
		birthDate = user.getBirthDate();
	}
}
