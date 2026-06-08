package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
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
	private List<ItemRequest> products;
	private LocalDateTime purchaseDateTime;
	private BigDecimal total;
	
	public Cart() {
		
	}
	
	public Cart(Long cartId, List<ItemRequest> products) {
		this.cartId = cartId;
		this.products = products;
	}

	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public List<ItemRequest> getProducts() {
		return products;
	}
	public void setProducts(List<ItemRequest> products) {
		this.products = products;
	}
	public LocalDateTime getPurchaseDateTime() {
		return purchaseDateTime;
	}
	public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + ", purchaseDateTime=" + purchaseDateTime + "]";
	}
}
