package com.umfrancisco.shoppingcart.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.umfrancisco.shoppingcart.model.Game;
import com.umfrancisco.shoppingcart.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {
	
	private final GameRepository repository;
	
	public GameServiceImpl(GameRepository repository) {
		this.repository = repository;
	}

	@Override
	public Game save(Game game) {
		return repository.save(game);
	}
	
	@Override
	public List<Game> findAll() {
		return repository.findAll();
	}

	@Override
	public Game findById(Long gameId) {
		return repository.findById(gameId).get();
	}

	@Override
	public void deleteById(Long gameId) {
		var game = repository.findById(gameId).get();
		if (game != null) {
			repository.delete(game);
		}
	}

	@Override
	public Game update(Game game, Long productId) {
		var updatedGame = repository.findById(productId).get();
		if (updatedGame != null) {
			updatedGame.setName(game.getName());
			updatedGame.setPrice(game.getPrice());
			updatedGame.setQuantity(game.getQuantity());
			updatedGame.setDescription(game.getDescription());
			updatedGame.setImageUrl(game.getImageUrl());
			updatedGame.setCategory(game.getCategory());
		}
		return updatedGame;
	}
}
