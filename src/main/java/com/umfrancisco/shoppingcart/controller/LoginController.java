package com.umfrancisco.shoppingcart.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.shoppingcart.config.UserSession;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class LoginController {

	@GetMapping("/hello")
	public String hello() {
		return UserSession.name;
	}
	
}
