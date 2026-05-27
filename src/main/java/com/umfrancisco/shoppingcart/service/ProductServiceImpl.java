package com.umfrancisco.shoppingcart.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.exception.ProductNotFoundException;
import com.umfrancisco.shoppingcart.model.Category;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.repository.CategoryRepository;
import com.umfrancisco.shoppingcart.repository.ProductRepository;
import com.umfrancisco.shoppingcart.request.ProductRequest;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Product add(ProductRequest request) {
		Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
				.orElseGet(() -> {
					Category newCategory = new Category(request.getCategory().getName());
					return categoryRepository.save(newCategory);
				});
		request.setCategory(category);
		var product = createProduct(request, category);
		System.out.println(LocalDateTime.now()+": "+product);
		return productRepository.save(product);
	}
	
	private Product createProduct(ProductRequest request, Category category) {
		String name = request.getName();
		String brand = request.getBrand();
		BigDecimal price = request.getPrice();
		int inventory = request.getInventory();
		String description = request.getDescription();
		return new Product(name, brand, price, inventory, description, category);
	}

	@Override
	public Product findById(Long productId) {
		return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
	}

	@Override
	public void deleteById(Long productId) {
		productRepository.findById(productId)
			.ifPresentOrElse(productRepository::delete, () -> {
				throw new ProductNotFoundException("Product not found");
			});
	}

	@Override
	public Product update(ProductRequest request, Long productId) {
		return productRepository.findById(productId)
				.map(existingProduct -> updateExistingProduct(existingProduct, request))
				.map(productRepository::save)
				.orElseThrow(() -> new ProductNotFoundException("Product not found"));
	}
	
	private Product updateExistingProduct(Product existingProduct, ProductRequest request) {
		existingProduct.setName(request.getName());
		existingProduct.setBrand(request.getBrand());
		existingProduct.setPrice(request.getPrice());
		existingProduct.setInventory(request.getInventory());
		existingProduct.setDescription(request.getDescription());
		
		var category = categoryRepository.findByName(request.getCategory().getName());
		existingProduct.setCategory(category);
		System.out.println(LocalDateTime.now()+": "+existingProduct);
		return existingProduct;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByCategory(String category) {
		return productRepository.findByCategoryName(category);
	}

	@Override
	public List<Product> findByBrand(String brand) {
		return productRepository.findByBrand(brand);
	}

	@Override
	public List<Product> findByCategoryAndBrand(String category, String brand) {
		return productRepository.findByCategoryNameAndBrand(category, brand);
	}

	@Override
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> findByBrandAndName(String brand, String name) {
		return productRepository.findByBrandAndName(brand, name);
	}

	@Override
	public Long countByBrandAndName(String brand, String name) {
		return productRepository.countByBrandAndName(brand, name);
	}
}
