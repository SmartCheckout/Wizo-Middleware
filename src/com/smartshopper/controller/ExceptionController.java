package com.smartshopper.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.smartshopper.exceptions.Exceptions.DataValidationException;
import com.smartshopper.exceptions.Exceptions.MoreStoresFoundException;
import com.smartshopper.exceptions.Exceptions.NoStoreFoundException;
import com.smartshopper.exceptions.Exceptions.ProductNotFoundException;
import com.smartshopper.exceptions.Exceptions.UserNotFoundException;
import com.smartshopper.models.io.ErrorInfo;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value={UserNotFoundException.class})
	@ResponseStatus(code=HttpStatus.UNAUTHORIZED, reason="User does not exist")
	public void userNotFoundHandler(){
	}
	
	
	@ExceptionHandler(value={DataValidationException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Invalid input request")
	@ResponseBody ErrorInfo
	dataValidationHandler(HttpServletRequest req, Exception ex){
		return new ErrorInfo(req.getRequestURL().toString(),ex.getMessage());
		
	}
	
	@ExceptionHandler(value={ProductNotFoundException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Product details not found")
	@ResponseBody ErrorInfo
	productNotFound(HttpServletRequest req, Exception ex){
		return new ErrorInfo(req.getRequestURL().toString(),ex.getMessage());
		
	}
	
	@ExceptionHandler(value={NoStoreFoundException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="No store details matched the input")
	@ResponseBody ErrorInfo
	noStoreFound(HttpServletRequest req, Exception ex){
		return new ErrorInfo(req.getRequestURL().toString(),ex.getMessage());
		
	}
	
	@ExceptionHandler(value={MoreStoresFoundException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="More stores matched while less was expected")
	@ResponseBody ErrorInfo
	moreStoresFound(HttpServletRequest req, Exception ex){
		return new ErrorInfo(req.getRequestURL().toString(),ex.getMessage());
		
	}
}
