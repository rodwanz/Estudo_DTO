package com.devsuperior.user.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DataInUse extends UserNotFound{
	private static final long serialVersionUID = 1L;
	
	public DataInUse(String message) {
		super(message);
	}
}
