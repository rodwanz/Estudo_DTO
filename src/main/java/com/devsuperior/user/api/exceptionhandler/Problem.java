package com.devsuperior.user.api.exceptionhandler;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problem {
	
	private LocalDateTime dateTime;
	private String message;

}
