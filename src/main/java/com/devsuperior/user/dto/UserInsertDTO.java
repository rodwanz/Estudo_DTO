package com.devsuperior.user.dto;

import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInsertDTO extends UserDTO{
	
	@Pattern(regexp ="^(?=.*\\d).{4,8}$", message = "Campo password deve ter entre 4 e 8 caracteres e "
			+ "conter pelo menos um valor numérico")
	private String password;

}
