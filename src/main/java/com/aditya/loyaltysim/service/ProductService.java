package com.aditya.loyaltysim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aditya.loyaltysim.model.Product;
import com.aditya.loyaltysim.persistence.Products;

@Service
public class ProductService {
	
	Products productsDao = Products.getInstance();
	
	public List<Product> saveBulkProducts(List<Product> products) {
		return productsDao.save(products);
	}
	
	public List<Product> getProducts() {
		return productsDao.findAll();
	}

}
