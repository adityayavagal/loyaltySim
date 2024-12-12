package com.aditya.loyaltysim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aditya.loyaltysim.model.Coupon;
import com.aditya.loyaltysim.model.Order;
import com.aditya.loyaltysim.persistence.Coupons;
import com.aditya.loyaltysim.persistence.Orders;

@Service
public class OrderService {

	private Orders orderDao = Orders.getInstance();
	
	private Coupons couponsDao = Coupons.getInstance();
	
	@Value("${coupon.config.discount}")
	private double discount;

	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}
	
	public boolean verifyAndRedeemCoupon(String couponCode) {
		final Coupon coupon = couponsDao.queryByCouponCode(couponCode);
		if (couponCode == null || couponCode.trim().equals("")) {
			return true;
		} else if (coupon != null && !coupon.isReedemed()) {
			coupon.redeemCoupon();
			return true;
		} else {
			return false;
		}
	}

	public boolean saveOrder(Order order) {
		String couponCode = order.getCoupon();
		
		double totalPrice = order.getItems()
									.stream()
									.mapToDouble(item -> item.getQuantity() * item.getPrice())
									.sum();
		
		if (verifyAndRedeemCoupon(couponCode)) {
			order.setTotalPrice(totalPrice);
			return orderDao.save(order);
		}
		return false;
		
	}

}
