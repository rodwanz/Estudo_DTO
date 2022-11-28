package com.devsuperior.user.dto;

import java.time.Instant;

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
	private String email;
	private String phone;
	private Instant birthDate;
	private Double balance;
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
		birthDate = user.getBirthDate();
		balance = user.getBalance();
	}
}
