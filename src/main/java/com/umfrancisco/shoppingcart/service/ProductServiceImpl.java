package com.umfrancisco.shoppingcart.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.exception.APIException;
import com.umfrancisco.shoppingcart.exception.ResourceNotFoundException;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.payload.ProductDTO;
import com.umfrancisco.shoppingcart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository repository;
	private ModelMapper modelMapper;
	
	public ProductServiceImpl(ProductRepository repository, ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductDTO addProduct(Product product) {
		Product savedProduct = repository.save(product);
		return modelMapper.map(savedProduct, ProductDTO.class);
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
	public ProductDTO getProductById(Long id) {
		Product product = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		return modelMapper.map(product, ProductDTO.class);
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
	public ProductDTO updateProduct(Product product, Long id) {
		Product existingProduct = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setStock(product.getStock());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setLongDescription(product.getLongDescription());
		existingProduct.setImageUrl(product.getImageUrl());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setHighlight(product.getHighlight());
		Product updatedProduct = repository.save(existingProduct);
		return modelMapper.map(updatedProduct, ProductDTO.class);
	}

	@Override
	public ProductDTO deleteProduct(Long id) {
		Product existingProduct = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		repository.delete(existingProduct);
		return modelMapper.map(existingProduct, ProductDTO.class);
	}
	
}

