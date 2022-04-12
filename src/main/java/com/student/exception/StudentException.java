package com.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.NOT_FOUND)
	

public class StudentException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String message;

public StudentException(String message) {
	super();
	this.setMessage(message);
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
