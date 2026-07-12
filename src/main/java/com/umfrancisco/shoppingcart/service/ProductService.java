package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.payload.ProductDTO;

public interface ProductService {
	ProductDTO addProduct(Product product);
	List<Product> getProducts();
	ProductDTO getProductById(Long id);
	List<Product> getProductByCategory(String category);
	ProductDTO updateProduct(Product product, Long id);
	ProductDTO deleteProduct(Long id);
}
