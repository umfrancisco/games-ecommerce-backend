package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Product;

public interface ProductService {
	Product add(Product product);
	Product findById(Long productId);
	void deleteById(Long productId);
	void update(Product product, Long productId);
	List<Product> findAll();
	List<Product> findByCategory(String category);
	List<Product> findByBrand(String brand);
	List<Product> findByCategoryAndBrand(String category, String brand);
	List<Product> findByName(String name);
	List<Product> findByBrandAndName(String brand, String name);
	Long countByBrandAndName(String brand, String name);
}
