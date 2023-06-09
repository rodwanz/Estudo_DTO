package com.devsuperior.user.domain.exception;

public class UserNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UserNotFound (String message) {
		super(message);
	}
	
	public UserNotFound (String message, Throwable cause) {
		super(message, cause);
	}
}
