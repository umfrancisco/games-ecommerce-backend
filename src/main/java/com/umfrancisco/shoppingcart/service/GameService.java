package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Game;

public interface GameService {
	
	// save
	Game save(Game game);
	List<Game> saveAll(List<Game> games);
	
	// find
	List<Game> findAll();
	Game findById(Long id);
	List<Game> findByCategory(String category);

	// update
	Game update(Game game, Long id);
	
	// delete
	void deleteById(Long id);
}
