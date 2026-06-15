package com.umfrancisco.shoppingcart.model;

public class AuthResponse {
	
	private String token;
	
	public AuthResponse(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return token;
	}
}
