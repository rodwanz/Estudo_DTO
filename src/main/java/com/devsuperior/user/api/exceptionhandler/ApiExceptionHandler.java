package com.devsuperior.user.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.user.domain.exception.EntityNotFound;
import com.devsuperior.user.domain.exception.UserNotFound;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<?> dealWithEntityNotFound(EntityNotFound e){
		Problem problem = Problem.builder()
				.dateTime(LocalDateTime.now())
				.message(e.getMessage()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(problem);
				
	}
	
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<?> dealWithUserNotFound(UserNotFound e){
		Problem problem = Problem.builder()
				.dateTime(LocalDateTime.now())
				.message(e.getMessage()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(problem);
				
	}

}
