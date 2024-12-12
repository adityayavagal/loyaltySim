package com.aditya.loyaltysim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.loyaltysim.model.Product;
import com.aditya.loyaltysim.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@PostMapping("/products")
	public ResponseEntity<?> addProducts(@RequestBody List<Product> products) {
		List<Product> savedProds = productService.saveBulkProducts(products);
		
		if (savedProds.size() > 0)
			return new ResponseEntity<>(HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}	

}
