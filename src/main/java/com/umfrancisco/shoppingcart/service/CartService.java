package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Cart;
import com.umfrancisco.shoppingcart.payload.ProductRequest;

public interface CartService {

	// save
	ProductRequest save(ProductRequest request);
	Cart saveAll(List<ProductRequest> requests);

	// find
	List<Cart> findAll();
	List<Cart> findByUserCode(Long userCode);
	ProductRequest findById(Long productId);
	
	// update
	ProductRequest update(ProductRequest request, Long productId);

	// delete
	void deleteById(Long productId);
}
