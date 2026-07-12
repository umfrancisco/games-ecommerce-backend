package com.umfrancisco.shoppingcart.service;

import java.util.List;
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
	public Product addProduct(Product product) {
		repository.findByName(product.getName())
				.orElseThrow(() -> new APIException("This product already exists"));
		return repository.save(product);
	}
	
	@Override
	public List<Product> getProducts() {
		List<Product> products = repository.findAll();
		if (products.isEmpty()) {
			throw new APIException("No product created yet");
		}
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		Product product = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		return product;
	}
	
	@Override
	public List<Product> getProductByCategory(String category) {
		List<Product> productsByCategory = repository.findByCategory(category.toLowerCase());
		if (productsByCategory.isEmpty()) {
			throw new APIException("Category not found");
		}
		return productsByCategory;
	}
	
	@Override
	public Product updateProduct(Product product, Long id) {
		Product existingProduct = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setStock(product.getStock());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setLongDescription(product.getLongDescription());
		existingProduct.setImageUrl(product.getImageUrl());
		existingProduct.setCategory(product.getCategory());
		repository.save(existingProduct);
		return existingProduct;
	}

	@Override
	public Product deleteProduct(Long id) {
		Product existingProduct = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		repository.delete(existingProduct);
		return existingProduct;
	}
	
}

