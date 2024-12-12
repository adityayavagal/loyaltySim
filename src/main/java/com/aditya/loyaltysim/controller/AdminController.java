package com.aditya.loyaltysim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.loyaltysim.model.Coupon;
import com.aditya.loyaltysim.service.AdminService;
import com.aditya.loyaltysim.service.CouponService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CouponService couponService;
	
	@PostMapping("/admin/generateCoupon")
	public ResponseEntity<?> generateCoupon() {
		Coupon coupon = couponService.generateCoupon();
		if (coupon != null)
			return new ResponseEntity<>(coupon,  HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/admin/getInsights")
	public ResponseEntity<?> getInsights() {
		return new ResponseEntity<>(adminService.getInsights(), HttpStatus.OK);
	}
}
