package com.aditya.loyaltysim.persistence;

import java.util.ArrayList;
import java.util.List;

import com.aditya.loyaltysim.model.Product;

public class Products {

	private static Products products;
	
	private static List<Product> productsList = new ArrayList<Product>();

	private Products() {
	}
	
	public static Products getInstance() {
		if (products == null)
			products = new Products();
		return products;
	}
	
	public List<Product> save(List<Product> prods) {
		productsList.addAll(prods);
		return productsList;
	}
	
	public List<Product> findAll() {
		return productsList;
	}
	
	
	
	

}
