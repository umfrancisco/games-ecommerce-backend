package com.umfrancisco.shoppingcart.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.umfrancisco.shoppingcart.service.GameServiceImpl;

@RestController
@RequestMapping("/api/product")
public class GameController {
	
	private final GameService service;
	
	public GameController(GameServiceImpl service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Game>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Game game) {
		try {
			return new ResponseEntity<>(service.save(game), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<String> update(@RequestBody Game game, @PathVariable Long gameId) {
		try {
			service.update(game, gameId);
			return new ResponseEntity<>("Updated "+game, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> delete(@PathVariable Long gameId) {
		try {
			service.deleteById(gameId);
			return new ResponseEntity<>("Deleted product with id "+gameId, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
