package com.devsuperior.user.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devsuperior.user.domain.exception.DataInUse;
import com.devsuperior.user.domain.exception.EntityNotFound;
import com.devsuperior.user.domain.exception.UserNotFound;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ProblemType problemType = ProblemType.UNDEFINED_MESSAGE;
		String detail = "The request body is invalid. Check syntax error";
		
		Problem problem = createProblemBuilder(status, problemType, detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), 
				status, request);
	}

	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<?> dealWithEntityNotFound(
			EntityNotFound ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.ENTITY_NOT_FOUND;
		String detail = ex.getMessage();
		
		Problem problem = createProblemBuilder(status, problemType, detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), 
				status, request);
	}

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<?> dealWithUserNotFound(UserNotFound ex, 
			WebRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType problemType = ProblemType.USER_NOT_FOUND;
		String detail = ex.getMessage();
		
		Problem problem = createProblemBuilder(status, problemType, detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), 
				status, request);

	}

	@ExceptionHandler(DataInUse.class)
	public ResponseEntity<?> dealWithDataInUse(DataInUse ex, 
			WebRequest request) {
		
		HttpStatus status = HttpStatus.CONFLICT;
		ProblemType problemType = ProblemType.DATA_IN_USE;
		String detail = ex.getMessage();
		
		Problem problem = createProblemBuilder(status, problemType, detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), 
				status, request);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, 
			Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		if (body == null) {
			body = Problem.builder()
					.title(status.getReasonPhrase())
					.status(status.value())
					.build();
		} else if (body instanceof String) {
			body = Problem.builder()
					.title((String) body)
					.status(status.value())
					.build();
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, 
			ProblemType problemType, String detail){
		
		return Problem.builder()
				.status(status.value())
				.title(problemType.getTitle())
				.detail(detail);
	}
}
