package com.devsuperior.user.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.user.domain.exception.DataInUse;
import com.devsuperior.user.domain.exception.EntityNotFound;
import com.devsuperior.user.domain.exception.UserNotFound;


@ControllerAdvice
public class ApiExceptionHandler{
	
	@ExceptionHandler(DataInUse.class)
	public ResponseEntity<?> tratandoDataExcption(
			DataInUse e) {
		Problem problem = Problem.builder()
				.title("Informações em uso!")
				.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(problem);
	}
	
	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<?> tratandoEntityExcption(
			EntityNotFound e) {
		Problem problem = Problem.builder()
				.title("Entidade não encontrada!")
				.status(404)
				.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(problem);
	}
	
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<?> tratandoUserExcption(
			UserNotFound e) {
		Problem problem = Problem.builder()
				.title("Usuario não encontrado!")
				.build();
		
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(problem);
	}
}
