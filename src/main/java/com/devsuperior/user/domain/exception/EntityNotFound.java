package com.devsuperior.user.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFound extends UserNotFound{
	private static final long serialVersionUID = 1L;
	
	public EntityNotFound (String message) {
		super(message);
	}
}
