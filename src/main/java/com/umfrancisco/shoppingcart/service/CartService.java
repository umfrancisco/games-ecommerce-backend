package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Cart;
import com.umfrancisco.shoppingcart.model.ProductRequest;

public interface CartService {
	List<Cart> findAll();
	ProductRequest save(ProductRequest request);
	Cart saveAll(List<ProductRequest> requests);
	ProductRequest findById(Long productId);
	void deleteById(Long productId);
	ProductRequest update(ProductRequest request, Long productId);
}
