package com.devsuperior.user.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
//@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 255)
	@Column(name = "name")
	private String name;
	
	@Email
	@NotBlank
	@Size(max = 255)
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 16, message = "Campo phone deve ter entre 9 e 16 caracteres")
	@Column(name = "phone")
	private String phone;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "document")
	private String document;


}