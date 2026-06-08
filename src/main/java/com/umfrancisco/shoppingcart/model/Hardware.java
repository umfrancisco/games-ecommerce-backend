package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;

@Entity
public class Hardware extends Product {
	
	public Hardware() {
		
	}

	public Hardware(Long id, String name, BigDecimal price, Integer stock, String description, String imageUrl) {
		super(id, name, price, stock, description, imageUrl);
	}

	@Override
	public String toString() {
		return "Hardware [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", description="
				+ description + ", imageUrl=" + imageUrl + "]";
	}
}
