package com.umfrancisco.shoppingcart.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.shoppingcart.model.Game;
import com.umfrancisco.shoppingcart.service.GameService;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameController {
	
	private final GameService service;
	
	public GameController(GameService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Game>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Game> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Game> save(@RequestBody Game game) {
		Game savedGame = service.save(game);
		return ResponseEntity.status(HttpStatus.OK).body(savedGame);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Game> update(@RequestBody Game game, @PathVariable Long id) {
		Game updatedGame = service.update(game, id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedGame);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>("Deleted game with id "+id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/data")
	public ResponseEntity<?> saveAll(@RequestBody List<Game> games) {
		try {
			return new ResponseEntity<>(service.saveAll(games), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<?> findByCategory(@PathVariable String category) {
		try {
			return new ResponseEntity<>(service.findByCategory(category), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
