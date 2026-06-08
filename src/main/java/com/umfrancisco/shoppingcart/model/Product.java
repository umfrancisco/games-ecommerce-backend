package com.umfrancisco.shoppingcart.model;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal price;
	private Integer stock;
	private String description;
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	private String category;
	private String imageUrl;
	private List<String> platforms;
	
	public Product() {
		
	}
	
	public Product(Long id, String name, BigDecimal price, Integer stock, String description, String longDescription,
			String category, String imageUrl, List<String> platforms) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.longDescription = longDescription;
		this.category = category;
		this.imageUrl = imageUrl;
		this.platforms = platforms;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public List<String> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", description="
				+ description + ", longDescription=" + longDescription + ", category=" + category + ", imageUrl="
				+ imageUrl + ", platforms=" + platforms + "]";
	}
	
}
