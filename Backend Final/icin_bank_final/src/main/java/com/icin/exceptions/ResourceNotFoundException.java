package com.icin.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//public class BusinessException extends Exception {
//	public BusinessException() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public BusinessException(final String message) {
//		super(message);
//		// TODO Auto-generated constructor stub
//	}
//
//}
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message){
    	super(message);
    }
}
