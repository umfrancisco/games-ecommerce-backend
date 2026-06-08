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
	public List<Game> saveAll(List<Game> games) {
		for (var game : games) {
			save(game);
		}
		return games;
	}
	
	@Override
	public List<Game> findAll() {
		return repository.findAll();
	}

	@Override
	public Game findById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public List<Game> findByCategory(String category) {
		return repository.findByCategory(category.toLowerCase());
	}
	
	@Override
	public Game update(Game game, Long productId) {
		var updatedGame = repository.findById(productId).get();
		if (updatedGame != null) {
			updatedGame.setName(game.getName());
			updatedGame.setPrice(game.getPrice());
			updatedGame.setStock(game.getStock());
			updatedGame.setDescription(game.getDescription());
			updatedGame.setLongDescription(game.getLongDescription());
			updatedGame.setImageUrl(game.getImageUrl());
			updatedGame.setCategory(game.getCategory());
			repository.save(updatedGame);
		}
		return updatedGame;
	}

	@Override
	public void deleteById(Long id) {
		var game = repository.findById(id).get();
		if (game != null) {
			repository.delete(game);
		}
	}
	
}

