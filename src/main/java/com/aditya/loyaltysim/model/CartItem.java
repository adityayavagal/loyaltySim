package com.aditya.loyaltysim.model;

import java.io.Serializable;

/**
 * This class used to represent product items in the cart
 * The JSON would look like below
 *	{
 *		"id": "m2",
 *		"name": "Margherita Pizza",
 *		"price": "12.99",
 *		"description": "A classic pizza with fresh mozzarella, tomatoes, and basil on a thin and crispy crust.",
 * 		"image": "images/margherita-pizza.jpg",
 *		"quantity": 1
 *	}
 */
public class CartItem implements Serializable {

	private static final long serialVersionUID = -7184591203092595206L;

	private String id;
	private String name;
	private String description;
	private String image;
	private int quantity;
	private double price;

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

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
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

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
