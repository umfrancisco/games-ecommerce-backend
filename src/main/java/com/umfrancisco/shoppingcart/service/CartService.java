package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Cart;
import com.umfrancisco.shoppingcart.model.ItemRequest;

public interface CartService {

	// save
	ItemRequest save(ItemRequest request);
	Cart saveAll(List<ItemRequest> requests);

	// find
	List<Cart> findAll();
	List<Cart> findByUserCode(Long userCode);
	ItemRequest findById(Long productId);
	
	// update
	ItemRequest update(ItemRequest request, Long productId);

	// delete
	void deleteById(Long productId);
}
