package com.umfrancisco.shoppingcart.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.shoppingcart.model.ProductRequest;
import com.umfrancisco.shoppingcart.service.RequestService;

@RestController
@RequestMapping("/api/request")
public class RequestController {
	
	private final RequestService service;
	
	public RequestController(RequestService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<ProductRequest> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public ProductRequest save(@RequestBody ProductRequest request) {
		return service.save(request);
	}
	
}
