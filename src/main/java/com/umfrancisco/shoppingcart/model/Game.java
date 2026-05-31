package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.Entity;

@Entity
public class Game extends Product {
	
	public Game() {
		
	}

	public Game(Long id, String name, BigDecimal price, Integer stock, String description, String imageUrl, String category, List<String> platforms) {
		super(id, name, price, stock, description, imageUrl, category, platforms);
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", description="
				+ description + ", imageUrl=" + imageUrl + ", category=" + category +", platforms" + platforms+ "]";
	}
}
