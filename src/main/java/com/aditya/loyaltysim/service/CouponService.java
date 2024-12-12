package com.aditya.loyaltysim.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aditya.loyaltysim.model.Coupon;
import com.aditya.loyaltysim.persistence.Coupons;

@Service
public class CouponService {
	
	private Coupons couponDao = Coupons.getInstance();
	
	@Value("${coupon.config.discount}")
	private double discount;
	
	@Value("${coupon.config.target}")
	private int target;
	
	@Autowired
	private OrderService orderService;
	
	public List<Coupon> getAllCoupons() {
		return couponDao.getAllCoupons();
	}
	
	public Coupon generateCoupon() {
		int ordersCount = orderService.getAllOrders().size();
		
		if (ordersCount > 0 && ((ordersCount + 1) % target == 0)) {
			String couponCode = randomAlphanumericString(8);
			Coupon coupon = new Coupon(couponCode);
			couponDao.saveCoupon(coupon);
			return coupon;
		}
		return null;
	}
	
	public static String randomAlphanumericString(int length) {
	    String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	 
	    StringBuffer randomString = new StringBuffer(length);
	    Random random = new Random();
	 
	    for (int i = 0; i < length; i++) {
	        int randomIndex = random.nextInt(alphanumericCharacters.length());
	        char randomChar = alphanumericCharacters.charAt(randomIndex);
	        randomString.append(randomChar);
	    }
	 
	    return randomString.toString();
	}

}
