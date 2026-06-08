package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Cart;
import com.umfrancisco.shoppingcart.model.ItemRequest;

public interface CartService {
	List<Cart> findAll();
	ItemRequest save(ItemRequest request);
	Cart saveAll(List<ItemRequest> requests);
	ItemRequest findById(Long productId);
	void deleteById(Long productId);
	ItemRequest update(ItemRequest request, Long productId);
}
