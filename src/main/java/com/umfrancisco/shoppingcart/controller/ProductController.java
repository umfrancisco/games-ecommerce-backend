package com.umfrancisco.shoppingcart.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.payload.ProductDTO;
import com.umfrancisco.shoppingcart.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@GetMapping("/public/product")
	public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getProducts());
	}
	
	@GetMapping("/public/product/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getProductById(id));
	}
	
	@GetMapping("/public/product/category/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getProductByCategory(category));
	}
	
	@GetMapping("/public/product/highlight")
	public ResponseEntity<ProductDTO> getHighlightProduct() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getProductByHighlight());
	}
	
	@PostMapping("/admin/product")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product) {
		ProductDTO savedProduct = service.addProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
	}
	
	@PutMapping("/admin/product/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product, @PathVariable Long id) {
		ProductDTO updatedProduct = service.updateProduct(product, id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);	
	}
	
	@DeleteMapping("/admin/product/{id}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long id) {
		ProductDTO existingProduct = service.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK).body(existingProduct);
	}
	
}
