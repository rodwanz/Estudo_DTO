package com.devsuperior.user.api.dto.imput;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserImput {

	@NotBlank
	private String name;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String document;

}
