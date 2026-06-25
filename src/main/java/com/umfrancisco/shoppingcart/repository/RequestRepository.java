package com.umfrancisco.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.shoppingcart.model.ProductRequest;

@Repository
public interface RequestRepository extends JpaRepository<ProductRequest, Long> {
	
}
