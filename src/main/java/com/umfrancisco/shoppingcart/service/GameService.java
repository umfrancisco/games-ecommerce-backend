package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Game;

public interface GameService {
	List<Game> findAll();
	Game save(Game game);
	List<Game> saveAll(List<Game> games);
	Game findById(Long gameId);
	List<Game> findByCategory(String category);
	void deleteById(Long gameId);
	Game update(Game game, Long gameId);
}
