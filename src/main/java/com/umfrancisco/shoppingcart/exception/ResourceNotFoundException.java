package com.umfrancisco.shoppingcart.exception;

import java.time.LocalDateTime;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 746340621182983307L;
	
	public ResourceNotFoundException() {
		
	}
	
	public ResourceNotFoundException(String message) {
		super(String.format("[%s] Error: %s", LocalDateTime.now(), message));
	}
}
