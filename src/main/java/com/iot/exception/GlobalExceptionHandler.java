package com.iot.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorHandler> handleGlobalException(Exception ex, WebRequest request) {
		String requestDetails = request.getDescription(false);
		log.error("Unexpected error occurred at {}: {}", requestDetails, ex.getMessage(), ex);

		MyErrorHandler error = new MyErrorHandler("Server Error",
				"An unexpected error occurred. Please try again later.", LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(IOTException.class)
	public ResponseEntity<MyErrorHandler> handleMenuItemException(IOTException ex, WebRequest request) {
		String requestDetails = request.getDescription(false);
		log.error("IOTException error at {}: {}", requestDetails, ex.getMessage());

		MyErrorHandler error = new MyErrorHandler("IOTException Error", ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
