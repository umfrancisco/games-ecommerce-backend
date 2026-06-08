package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Game;

public interface GameService {
	List<Game> findAll();
	Game save(Game game);
	List<Game> saveAll(List<Game> games);
	Game findById(Long id);
	List<Game> findByCategory(String category);
	void deleteById(Long id);
	Game update(Game game, Long id);
}
