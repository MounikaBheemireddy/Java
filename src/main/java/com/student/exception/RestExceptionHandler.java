package com.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(StudentException.class)
public final ResponseEntity<Object> handleExceptions(StudentException studentException){
	APIError apiError=new APIError(studentException.getMessage());
	return new ResponseEntity<Object>(apiError,HttpStatus.NOT_FOUND);
	
}

}
