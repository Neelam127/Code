package com.cs.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;  
@ResponseStatus(HttpStatus.NOT_FOUND)  
public class BookNotFoundException extends RuntimeException  {
	private String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException() {
		
	}
	
	public BookNotFoundException(String msg) {
		super(msg);
		this.message=msg;
	}

}
