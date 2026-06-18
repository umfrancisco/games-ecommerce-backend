package com.umfrancisco.shoppingcart.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
		return repository.save(product);
	}
	
	@Override
	public List<Product> saveAll(List<Product> products) {
		for (var product : products) {
			save(product);
		}
		return products;
	}
	
	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Product findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
	}
	
	@Override
	public List<Product> findByCategory(String category) {
		return repository.findByCategory(category.toLowerCase());
	}
	
	@Override
	public Product update(Product product, Long id) {
		var updatedGame = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
		if (updatedGame != null) {
			updatedGame.setName(product.getName());
			updatedGame.setPrice(product.getPrice());
			updatedGame.setStock(product.getStock());
			updatedGame.setDescription(product.getDescription());
			updatedGame.setLongDescription(product.getLongDescription());
			updatedGame.setImageUrl(product.getImageUrl());
			updatedGame.setCategory(product.getCategory());
			repository.save(updatedGame);
		}
		return updatedGame;
	}

	@Override
	public void deleteById(Long id) {
		var product = repository.findById(id).get();
		if (product != null) {
			repository.delete(product);
		}
	}
	
}

