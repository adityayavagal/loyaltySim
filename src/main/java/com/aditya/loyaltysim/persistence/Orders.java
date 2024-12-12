package com.aditya.loyaltysim.persistence;

import java.util.ArrayList;
import java.util.List;

import com.aditya.loyaltysim.model.Order;

public class Orders {
	
	private static Orders orders;
	
	private static final List<Order> ordersList = new ArrayList<>();
	
	private Orders() {
	}
	
	public static Orders getInstance() {
		if (orders == null)
			orders = new Orders();
		return orders;
	}
	
	public boolean save(Order prods) {
		return ordersList.add(prods);
	}
	
	public List<Order> findAll() {
		return ordersList;
	}
	
	

}
