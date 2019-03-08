package com.launchwindows.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LaunchWindowsExceptionController {
	@ExceptionHandler(value = LocationNotfoundException.class)
	public ResponseEntity<Object> exception(LocationNotfoundException exception) {
	      return new ResponseEntity<>("Location specified was not found", HttpStatus.NOT_FOUND);
	   }
}
