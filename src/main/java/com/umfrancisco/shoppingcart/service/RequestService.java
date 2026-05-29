package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.ProductRequest;

public interface RequestService {
	List<ProductRequest> findAll();
	ProductRequest save(ProductRequest request);
	ProductRequest findById(Long productId);
	void deleteById(Long productId);
	ProductRequest update(ProductRequest request, Long productId);
}
