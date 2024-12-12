package com.aditya.loyaltysim.persistence;

import java.util.ArrayList;
import java.util.List;

import com.aditya.loyaltysim.model.Coupon;

public class Coupons {
	
	private static Coupons coupons;
	
	private static final List<Coupon> couponList = new ArrayList<>();
	
	private Coupons() {
	}
	
	public static Coupons getInstance() {
		if (coupons == null)
			coupons = new Coupons();
		return coupons;
	}
	
	public List<Coupon> getAllCoupons() {
		return couponList;
	}
	
	public boolean saveCoupon(Coupon coupon) {
		return couponList.add(coupon);
	}
	
	public Coupon queryByCouponCode(String couponCode) {
		
		return couponList.stream()
					.filter(coupon -> coupon.getCouponCode().equalsIgnoreCase(couponCode))
					.findFirst()
					.orElse(null);

					
	}
	

}
