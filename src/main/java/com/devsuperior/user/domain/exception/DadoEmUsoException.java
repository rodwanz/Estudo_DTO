package com.devsuperior.user.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DadoEmUsoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DadoEmUsoException(String message) {
		super(message);
	}
}
