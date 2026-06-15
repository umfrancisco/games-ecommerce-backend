package com.umfrancisco.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umfrancisco.shoppingcart.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
	User findByUserCode(Long userCode);
}
