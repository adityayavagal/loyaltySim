package com.aditya.loyaltysim.model;

import java.sql.Timestamp;
import java.time.Instant;

public class Coupon {

	private static int counter = 1;

	private int id;
	
	private String couponCode;
	
	private Timestamp createdAt;
	
	private boolean isReedemed;
	
	private Timestamp reedemedAt;

	public Coupon() {
	}

	public Coupon(String couponCode) {
		this.id = counter++;
		this.couponCode = couponCode;
		createdAt = Timestamp.from(Instant.now());
		isReedemed = false;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public int getId() {
		return id;
	}

	public Timestamp getReedemedAt() {
		return reedemedAt;
	}

	public boolean isReedemed() {
		return isReedemed;
	}
	
	public void redeemCoupon() {
		isReedemed = true;
		reedemedAt = Timestamp.from(Instant.now());
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", couponCode=" + couponCode + ", createdAt=" + createdAt + ", isReedemed="
				+ isReedemed + ", reedemedAt=" + reedemedAt + "]";
	}

}
