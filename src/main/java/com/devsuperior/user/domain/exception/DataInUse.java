package com.devsuperior.user.domain.exception;

public class DataInUse extends UserNotFound{
	private static final long serialVersionUID = 1L;
	
	public DataInUse(String message) {
		super(message);
	}
}
