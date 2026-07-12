package com.umfrancisco.shoppingcart.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.umfrancisco.shoppingcart.config.UserSession;
import com.umfrancisco.shoppingcart.model.Cart;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.payload.ProductDTO;
import com.umfrancisco.shoppingcart.payload.ProductRequest;
import com.umfrancisco.shoppingcart.repository.CartRepository;
import com.umfrancisco.shoppingcart.repository.RequestRepository;

@Service
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository;
	private final RequestRepository requestRepository;
	private final ProductService productService;
	private ModelMapper modelMapper;
	
	public CartServiceImpl(CartRepository cartRepository, RequestRepository requestRepository, ProductService productService, ModelMapper modelMapper) {
		this.cartRepository = cartRepository;
		this.requestRepository = requestRepository;
		this.productService = productService;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public ProductRequest save(ProductRequest request) {
		ProductDTO productDTO = productService.getProductById(request.getId());
		Product product = modelMapper.map(productDTO, Product.class);
		if (product != null && request.getQuantity() <= product.getStock()) {
			product.setStock(product.getStock() - request.getQuantity());
			productService.updateProduct(product, product.getId());
			BigDecimal quantity = BigDecimal.valueOf(request.getQuantity());
			request.setPrice(product.getPrice().multiply(quantity));
			return requestRepository.save(request);
		}
		return null;
	}
	
	@Override
	public Cart saveAll(List<ProductRequest> requests) {
		Cart cart = new Cart();
		List<ProductRequest> savedRequests = new ArrayList<ProductRequest>();
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
	public ProductRequest findById(Long productId) {
		Optional<ProductRequest> optionalRequest = requestRepository.findById(productId);
		if (optionalRequest.isPresent()) {
			return optionalRequest.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Request not found");
		}
	}
	
	@Override
	public ProductRequest update(ProductRequest request, Long productId) {
		Optional<ProductRequest> optionalRequest = requestRepository.findById(productId);
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
	
	public BigDecimal getTotalPrice(List<ProductRequest> requests) {
		BigDecimal total = BigDecimal.ZERO;
		for (var req : requests) {
			total = total.add(req.getPrice());
		}
		return total;
	}
	
}

