package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.Entity;

@Entity
public class Game extends Product {
	
	public Game() {
		
	}

	public Game(Long id, String name, BigDecimal price, Integer stock, String shortDescription, String longDescription, String imageUrl, String category, List<String> platforms) {
		super(id, name, price, stock, shortDescription, longDescription, imageUrl, category, platforms);
	}
}
