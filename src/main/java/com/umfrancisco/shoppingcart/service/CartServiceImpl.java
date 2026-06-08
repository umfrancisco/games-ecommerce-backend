package com.umfrancisco.shoppingcart.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.model.Cart;
import com.umfrancisco.shoppingcart.model.Game;
import com.umfrancisco.shoppingcart.model.ItemRequest;
import com.umfrancisco.shoppingcart.repository.CartRepository;
import com.umfrancisco.shoppingcart.repository.RequestRepository;

@Service
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository;
	private final RequestRepository requestRepository;
	private final GameService gameService;
	
	public CartServiceImpl(CartRepository cartRepository, RequestRepository requestRepository, GameService gameService) {
		this.cartRepository = cartRepository;
		this.requestRepository = requestRepository;
		this.gameService = gameService;
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public ItemRequest save(ItemRequest request) {
		Game game = gameService.findById(request.getId());
		if (game != null && request.getQuantity() <= game.getStock()) {
			game.setStock(game.getStock() - request.getQuantity());
			gameService.update(game, game.getId());
			BigDecimal quantity = BigDecimal.valueOf(request.getQuantity());
			request.setPrice(game.getPrice().multiply(quantity));
			return requestRepository.save(request);
		}
		return null;
	}
	
	public BigDecimal getTotalPrice(List<ItemRequest> requests) {
		BigDecimal total = BigDecimal.ZERO;
		for (var req : requests) {
			total = total.add(req.getPrice());
		}
		return total;
	}
	
	@Override
	public Cart saveAll(List<ItemRequest> requests) {
		Cart cart = new Cart();
		List<ItemRequest> savedRequests = new ArrayList<ItemRequest>();
		for (var request : requests) {
			var req = save(request);
			savedRequests.add(req);
		}
		cart.setProducts(savedRequests);
		cart.setPurchaseDateTime(LocalDateTime.now());
		cart.setTotal(getTotalPrice(requests));
		cartRepository.save(cart);
		return cart;
	}

	@Override
	public ItemRequest findById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemRequest update(ItemRequest request, Long productId) {
		// TODO Auto-generated method stub
		return null;
	}
}
