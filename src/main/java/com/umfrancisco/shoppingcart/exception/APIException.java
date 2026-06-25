package com.umfrancisco.shoppingcart.exception;

public class APIException extends RuntimeException {

	private static final long serialVersionUID = -6450204354236565363L;

	public APIException() {
		
	}
	
	public APIException(String message) {
		super(message);
	}
	
}
