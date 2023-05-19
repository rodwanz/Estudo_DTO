package com.devsuperior.user.domain.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String name;
	
	@Email
	@NotBlank
	@Size(max = 60)
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 16, message = "Campo phone deve ter entre 9 e 16 caracteres")
	private String phone;
	
	@NotBlank
	@Size(max = 60)
	private String cpf;
	
	@PastOrPresent(message = "Campo de data inválido")
	private Instant birthDate;


}