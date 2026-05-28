package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
import java.util.Arrays;

import jakarta.persistence.Entity;

@Entity
public class Game extends Product {
	
	public Game() {
		
	}

	public Game(Long id, String name, BigDecimal price, int quantity, String description, String imageUrl, String[] category) {
		super(id, name, price, quantity, description, imageUrl, category);
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", description="
				+ description + ", imageUrl=" + imageUrl + ", category=" + Arrays.toString(category) + "]";
	}
}
