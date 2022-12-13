package com.devsuperior.user.dto;

import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
	
	@NotBlank(message = "O valor não pode ser nulo ou vazio")
	private String name;
	
	@Email
	private String email;
	
	@Size(min = 8, max = 16, message = "Campo phone deve ter entre 9 e 16 caracteres")
	private String phone;
	
	@PastOrPresent(message = "Campo de data inválido")
	private Instant birthDate;
	
	@Positive(message = "Saldo deve ser positivo")
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
