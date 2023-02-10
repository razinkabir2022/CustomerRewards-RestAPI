package com.example.rewardsprogram.exception;

import java.io.IOException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	void handleIllegalArgumentException(HttpServletResponse response, Exception ex) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}

	@ExceptionHandler(EntityNotFoundException.class)
	void handleEntityNotFoundException(HttpServletResponse response, Exception ex) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

}
