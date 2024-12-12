/**
 * 
 */
package com.aditya.loyaltysim.model;

import java.io.Serializable;
import java.util.List;

/**
 * Order Data Example { "order": { "items": [ { "id": "m2", "name": "Margherita
 * Pizza", "price": "12.99", "description": "A classic pizza with fresh
 * mozzarella, tomatoes, and basil on a thin and crispy crust.", "image":
 * "images/margherita-pizza.jpg", "quantity": 1 } ], "customer": { "name":
 * "aditya", "email": "xyx@fmali.com", "street": "sdsd", "postalCode": "787856",
 * "city": "sdsrwefsd" } } }
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 6921535363435260849L;

	private List<CartItem> items;

	private Customer customer;

	private double totalPrice;

	private String coupon;

	public String getCoupon() {
		return coupon;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
