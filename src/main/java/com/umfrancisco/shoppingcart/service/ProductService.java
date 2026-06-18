package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Product;

public interface ProductService {
	
	// save
	Product save(Product product);
	List<Product> saveAll(List<Product> products);
	
	// find
	List<Product> findAll();
	Product findById(Long id);
	List<Product> findByCategory(String category);

	// update
	Product update(Product product, Long id);
	
	// delete
	void deleteById(Long id);
}
