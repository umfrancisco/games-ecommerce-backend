package com.umfrancisco.shoppingcart.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.exception.APIException;
import com.umfrancisco.shoppingcart.exception.ResourceNotFoundException;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Product save(Product product) {
		Product savedProduct = repository.findByName(product.getName());
		if (savedProduct != null) {
			throw new APIException("Product "+product.getName()+" already exists");
		}
		return repository.save(product);
	}
	
	@Override
	public List<Product> saveAll(List<Product> products) {
		return repository.saveAll(products);
	}
	
	@Override
	public List<Product> findAll() {
		List<Product> products = repository.findAll();
		if (products.isEmpty()) {
			throw new APIException("No product created yet");
		}
		return products;
	}

	@Override
	public Product findById(Long id) {
		Optional<Product> optionalProduct = repository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();			
		} else {
			throw new ResourceNotFoundException("Product", "id", id);
		}
	}
	
	@Override
	public List<Product> findByCategory(String category) {
		List<Product> productsByCategory = repository.findByCategory(category.toLowerCase());
		if (productsByCategory.isEmpty()) {
			throw new APIException("Product with category "+category+" not found");
		}
		return productsByCategory;
	}
	
	@Override
	public Product update(Product product, Long id) {
		Optional<Product> optionalProduct = repository.findById(id);
		if (optionalProduct.isPresent()) {
			Product updatedProduct = optionalProduct.get();
			updatedProduct.setName(product.getName());
			updatedProduct.setPrice(product.getPrice());
			updatedProduct.setStock(product.getStock());
			updatedProduct.setDescription(product.getDescription());
			updatedProduct.setLongDescription(product.getLongDescription());
			updatedProduct.setImageUrl(product.getImageUrl());
			updatedProduct.setCategory(product.getCategory());
			repository.save(updatedProduct);
			return updatedProduct;
		} else {
			throw new ResourceNotFoundException("Product", "id", id);
		}
	}

	@Override
	public void deleteById(Long id) {
		var product = repository.findById(id);
		if (product.isPresent()) {
			repository.delete(product.get());
		} else {
			throw new ResourceNotFoundException("Product", "id", id);
		}
	}
	
}

