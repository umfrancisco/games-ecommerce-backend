package com.umfrancisco.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.shoppingcart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
}
