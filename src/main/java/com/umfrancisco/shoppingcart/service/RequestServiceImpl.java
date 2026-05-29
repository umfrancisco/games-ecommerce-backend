package com.umfrancisco.shoppingcart.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

import com.umfrancisco.shoppingcart.model.Game;
import com.umfrancisco.shoppingcart.model.ProductRequest;
import com.umfrancisco.shoppingcart.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	
	private final RequestRepository repository;
	private final GameService gameService;
	
	public RequestServiceImpl(RequestRepository repository, GameService gameService) {
		this.repository = repository;
		this.gameService = gameService;
	}

	@Override
	public List<ProductRequest> findAll() {
		return repository.findAll();
	}

	@Override
	public ProductRequest save(ProductRequest request) {
		Game game = gameService.findById(request.getProductId());
		if (game != null && request.getQuantity() <= game.getStock()) {
			game.setStock(game.getStock() - request.getQuantity());
			gameService.update(game, game.getId());
			BigDecimal quantity = BigDecimal.valueOf(request.getQuantity());
			request.setPrice(game.getPrice().multiply(quantity));
			return repository.save(request);
		}
		return null;
	}

	@Override
	public ProductRequest findById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductRequest update(ProductRequest request, Long productId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
