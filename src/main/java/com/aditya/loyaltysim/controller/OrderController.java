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

import com.aditya.loyaltysim.model.Coupon;
import com.aditya.loyaltysim.model.Order;
import com.aditya.loyaltysim.service.CouponService;
import com.aditya.loyaltysim.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CouponService couponService;
	
	@GetMapping("/order")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@PostMapping("/order")
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		if (orderService.saveOrder(order)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/coupon")
	public ResponseEntity<?> getCoupon() {
		Coupon coupon = couponService.generateCoupon();
		if (coupon != null)
			return new ResponseEntity<>(coupon,  HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
