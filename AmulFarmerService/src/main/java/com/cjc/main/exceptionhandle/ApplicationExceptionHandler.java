package com.cjc.main.exceptionhandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.main.exception.cowNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(cowNotFoundException.class)
	public ResponseEntity<String>handleCowNotFoundException(cowNotFoundException ce) {
		return new ResponseEntity<String>(ce.getMessage(),HttpStatus.NOT_FOUND);
	}
	

}
