package com.devsuperior.user.domain.exception;

public class EntityNotFound extends UserNotFound{
	private static final long serialVersionUID = 1L;
	
	public EntityNotFound (String message) {
		super(message);
	}
	
	public EntityNotFound (Long id) {
		this(String.format("There is no user with this id", id));
	}
}
