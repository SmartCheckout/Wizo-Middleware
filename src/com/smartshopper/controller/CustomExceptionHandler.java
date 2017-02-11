package com.smartshopper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.smartshopper.exceptions.UserNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value={UserNotFoundException.class})
	@ResponseStatus(code=HttpStatus.UNAUTHORIZED, reason="User Does Not Exist")
	public void userNotFoundHandler(){
	}
	
}
