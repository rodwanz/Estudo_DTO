package com.devsuperior.user.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devsuperior.user.domain.exception.DataInUse;
import com.devsuperior.user.domain.exception.EntityNotFound;
import com.devsuperior.user.domain.exception.UserNotFound;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<?> dealWithEntityNotFound(EntityNotFound ex, WebRequest request) {

		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<?> dealWithUserNotFound(UserNotFound ex, WebRequest request) {

		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(DataInUse.class)
	public ResponseEntity<?> dealWithDataInUse(DataInUse ex, WebRequest request) {

		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		if (body == null) {
			body = Problem.builder()
					.dateTime(LocalDateTime.now())
					.message(status.getReasonPhrase())
					.build();
		} else if (body instanceof String) {
			body = Problem.builder()
					.dateTime(LocalDateTime.now())
					.message((String) body)
					.build();
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

}
