package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Game extends Product {
	
	private String category;
	private List<String> platforms;
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	public Game() {
		
	}
	
	public Game(Long id, String name, BigDecimal price, Integer stock, String description, String imageUrl,
			String category, List<String> platforms, String longDescription) {
		super(id, name, price, stock, description, imageUrl);
		this.category = category;
		this.platforms = platforms;
		this.longDescription = longDescription;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	@Override
	public String toString() {
		return "Game [category=" + category + ", platforms=" + platforms + ", longDescription=" + longDescription
				+ ", id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", description="
				+ description + ", imageUrl=" + imageUrl + "]";
	}
}
