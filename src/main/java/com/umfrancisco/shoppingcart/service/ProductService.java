package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Product;

public interface ProductService {
	Product addProduct(Product product);
	List<Product> getProducts();
	Product getProductById(Long id);
	List<Product> getProductByCategory(String category);
	Product updateProduct(Product product, Long id);
	Product deleteProduct(Long id);
}
