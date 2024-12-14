package com.aditya.loyaltysim.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aditya.loyaltysim.model.Product;
import com.aditya.loyaltysim.persistence.Products;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	
	Products productsDao = Products.getInstance();
	
	@PostConstruct
	public void loadData() {
		ObjectMapper objMapper = new ObjectMapper();
		
		try {
			List<Product> products;
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("products.json");
			products = objMapper.readValue(inputStream, new TypeReference<List<Product>>() {
			});
			saveBulkProducts(products);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> saveBulkProducts(List<Product> products) {
		return productsDao.save(products);
	}
	
	public List<Product> getProducts() {
		return productsDao.findAll();
	}

}
