package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
	private LocalDateTime purchaseDateTime;
	private BigDecimal total;
	private Long userCode;
	
	public Cart() {
		
	}
	
	public Cart(Long cartId, List<ItemRequest> products, Long userCode) {
		this.cartId = cartId;
		this.products = products;
		this.userCode = userCode;
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
	public Long getUserCode() {
		return userCode;
	}
	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + ", purchaseDateTime=" + purchaseDateTime + "]";
	}
}
