package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Game;

public interface GameService {
	List<Game> findAll();
	Game save(Game game);
	Game findById(Long gameId);
	void deleteById(Long gameId);
	Game update(Game game, Long gameId);
}
