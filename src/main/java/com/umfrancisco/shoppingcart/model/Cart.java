package com.umfrancisco.shoppingcart.model;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cartId;
	@OneToMany
	private List<ProductRequest> products;
	private LocalDateTime purchaseDateTime;
	
	public Cart() {
		
	}
	
	public Cart(Long cartId, List<ProductRequest> products) {
		this.cartId = cartId;
		this.products = products;
		this.purchaseDateTime = LocalDateTime.now();
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<ProductRequest> getProducts() {
		return products;
	}

	public void setProducts(List<ProductRequest> products) {
		this.products = products;
	}

	public LocalDateTime getPurchaseDateTime() {
		return purchaseDateTime;
	}

	public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + ", purchaseDateTime=" + purchaseDateTime + "]";
	}
}
