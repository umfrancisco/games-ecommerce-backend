package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long requestId;
	private Long productId;
	private BigDecimal price;
	private Integer quantity;
	
	public ProductRequest() {
		
	}
	
	public ProductRequest(Long requestId, Long productId, Integer quantity) {
		this.requestId = requestId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
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
		return "ProductRequest [requestId=" + requestId + ", productId=" + productId + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
}
