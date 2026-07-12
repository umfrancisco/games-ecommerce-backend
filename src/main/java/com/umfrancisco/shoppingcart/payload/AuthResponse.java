package com.umfrancisco.shoppingcart.payload;

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
