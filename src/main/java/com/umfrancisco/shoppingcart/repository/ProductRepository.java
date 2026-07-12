package com.umfrancisco.shoppingcart.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.shoppingcart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategory(String category);
	Optional<Product> findByHighlight(Boolean highlight);
}
