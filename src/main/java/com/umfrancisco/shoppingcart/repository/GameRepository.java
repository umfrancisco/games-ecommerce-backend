package com.umfrancisco.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.shoppingcart.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	List<Game> findByCategory(String category);
}
