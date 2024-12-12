package com.aditya.loyaltysim.model;

import java.io.Serializable;

public class Product implements Serializable {
	
	private static final long serialVersionUID = -2497194503008063208L;
	
	private String id;
	private String name;
	private String description;
	private String image;
	private float price;

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
}
