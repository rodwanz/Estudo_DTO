package com.devsuperior.user.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	UNDEFINED_MESSAGE("Undefined message"),
	ENTITY_NOT_FOUND("Entity not found"),
	DATA_IN_USE("Data in use"),
	USER_NOT_FOUND("User not found");
	
	private String title;
	
	private ProblemType(String title) {
		this.title = title;
	}
}
