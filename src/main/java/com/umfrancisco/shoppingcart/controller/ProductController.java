package com.umfrancisco.shoppingcart.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
	
	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		Product savedProduct = service.save(product);
		return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {
		Product updatedProduct = service.update(product, id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body("Deleted product with id "+id);
	}
	
	@PostMapping("/data")
	public ResponseEntity<List<Product>> saveAll(@RequestBody List<Product> products) {
		return ResponseEntity.status(HttpStatus.OK).body(service.saveAll(products));
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Product>> findByCategory(@PathVariable String category) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByCategory(category));
	}
	
	@GetMapping("/banner")
	public ResponseEntity<Product> getRandomProduct() {
		var products = service.findAll();
		for (var p : products) {
			if (p.getStock() > 0) {
				return ResponseEntity.status(HttpStatus.OK).body(p);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
}
