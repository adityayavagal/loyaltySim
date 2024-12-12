package com.aditya.loyaltysim.service.dto;

import java.util.List;

import com.aditya.loyaltysim.model.Coupon;

public class InsightsDTO {

	private double totalSales;
	private List<Coupon> coupons;
	private double totalDiscounts;
	private List<ProductSalesDTO> productSales;

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public List<ProductSalesDTO> getProductSales() {
		return productSales;
	}

	public double getTotalDiscounts() {
		return totalDiscounts;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	public void setProductSales(List<ProductSalesDTO> productSales) {
		this.productSales = productSales;
	}

	public void setTotalDiscounts(double totalDiscounts) {
		this.totalDiscounts = totalDiscounts;
	}

	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
}
