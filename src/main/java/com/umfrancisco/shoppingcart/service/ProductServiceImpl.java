package com.umfrancisco.shoppingcart.service;

import java.util.ArrayList;
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
	
	private ProductDTO mapToDTO(Product product) {
		return modelMapper.map(product, ProductDTO.class);
	}

	@Override
	public ProductDTO addProduct(Product product) {
		Product savedProduct = repository.save(product);
		return mapToDTO(savedProduct);
	}
	
	@Override
	public List<ProductDTO> getProducts() {
		List<Product> products = repository.findAll();
		List<ProductDTO> productDTOS = new ArrayList<>();
		if (products.isEmpty()) {
			throw new APIException("No product created yet");
		}
		productDTOS = products.stream()
			.map((p) -> mapToDTO(p))
			.toList();
		return productDTOS;
	}

	@Override
	public ProductDTO getProductById(Long id) {
		Product product = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		return mapToDTO(product);
	}
	
	@Override
	public List<ProductDTO> getProductByCategory(String category) {
		List<Product> productsByCategory = repository.findByCategory(category.toLowerCase());
		List<ProductDTO> productDTOS = new ArrayList<>();
		if (productsByCategory.isEmpty()) {
			throw new APIException("Category not found");
		}
		productDTOS = productsByCategory.stream()
				.map((p) -> mapToDTO(p))
				.toList();
		return productDTOS;
	}
	
	@Override
	public ProductDTO getHighlightedProduct() {
		List<Product> highlightedProducts = repository.findByHighlight(true);
		for (var highlightProduct : highlightedProducts) {
			if (highlightProduct.getStock() > 0) {
				return modelMapper.map(highlightProduct, ProductDTO.class);				
			}
		}
		throw new ResourceNotFoundException("Not available product found");
	}
	
	@Override
	public List<ProductDTO> getHighlightedProducts() {
		List<Product> highlightedProducts = repository.findByHighlight(true);
		List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
		for (var prod : highlightedProducts) {
			productDTOS.add(mapToDTO(prod));
		}
		return productDTOS;
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
		return mapToDTO(updatedProduct);
	}

	@Override
	public ProductDTO deleteProduct(Long id) {
		Product existingProduct = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		repository.delete(existingProduct);
		return mapToDTO(existingProduct);
	}
	
}

