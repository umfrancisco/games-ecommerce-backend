package com.umfrancisco.shoppingcart.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.umfrancisco.shoppingcart.config.UserSession;
import com.umfrancisco.shoppingcart.model.Cart;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.model.ItemRequest;
import com.umfrancisco.shoppingcart.repository.CartRepository;
import com.umfrancisco.shoppingcart.repository.RequestRepository;

@Service
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository;
	private final RequestRepository requestRepository;
	private final ProductService productService;
	
	public CartServiceImpl(CartRepository cartRepository, RequestRepository requestRepository, ProductService productService) {
		this.cartRepository = cartRepository;
		this.requestRepository = requestRepository;
		this.productService = productService;
	}
	
	@Override
	public ItemRequest save(ItemRequest request) {
		Product product = productService.findById(request.getId());
		if (product != null && request.getQuantity() <= product.getStock()) {
			product.setStock(product.getStock() - request.getQuantity());
			productService.update(product, product.getId());
			BigDecimal quantity = BigDecimal.valueOf(request.getQuantity());
			request.setPrice(product.getPrice().multiply(quantity));
			return requestRepository.save(request);
		}
		return null;
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
		cart.setUserCode(UserSession.ID);
		cartRepository.save(cart);
		return cart;
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}
	
	@Override
	public List<Cart> findByUserCode(Long userCode) {
		return cartRepository.findByUserCode(userCode);
	}

	@Override
	public ItemRequest findById(Long productId) {
		Optional<ItemRequest> optionalRequest = requestRepository.findById(productId);
		if (optionalRequest.isPresent()) {
			return optionalRequest.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Request not found");
		}
	}
	
	@Override
	public ItemRequest update(ItemRequest request, Long productId) {
		Optional<ItemRequest> optionalRequest = requestRepository.findById(productId);
		if (optionalRequest.isPresent()) {
			var req = optionalRequest.get();
			req.setId(productId);
			req.setName(request.getName());
			req.setPrice(request.getPrice());
			req.setQuantity(request.getQuantity());
			requestRepository.save(req);
			return req;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Request not found");
		}
	}

	@Override
	public void deleteById(Long productId) {
		if (requestRepository.existsById(productId)) {
			requestRepository.deleteById(productId);
		}
	}
	
	public BigDecimal getTotalPrice(List<ItemRequest> requests) {
		BigDecimal total = BigDecimal.ZERO;
		for (var req : requests) {
			total = total.add(req.getPrice());
		}
		return total;
	}
	
}

