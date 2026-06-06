package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductRequest {
	
	@Id
	private Long id;
	private BigDecimal price;
	private Integer quantity;
	
	public ProductRequest() {
		
	}
	
	public ProductRequest(Long id, BigDecimal price, Integer quantity) {
		this.id = id;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "ProductRequest [id=" + id + ", price=" + price + ", quantity=" + quantity+ "]";
	}
}
