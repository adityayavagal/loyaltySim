package com.aditya.loyaltysim.service.dto;

import java.util.Objects;

/**
 * Reprsents Product Sales data
 */
public class ProductSalesDTO {

	private String id;
	private String name;
	private double unitPrice;
	private int totalSaleQuantity;
	private double totalSaleValue;

	public ProductSalesDTO(String id, String name, double unitPrice, int totalSaleQuantity,
			double totalSaleValue) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.totalSaleQuantity = totalSaleQuantity;
		this.totalSaleValue = totalSaleValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductSalesDTO other = (ProductSalesDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& totalSaleQuantity == other.totalSaleQuantity && Objects.equals(totalSaleValue, other.totalSaleValue)
				&& Objects.equals(unitPrice, other.unitPrice);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getTotalSaleQuantity() {
		return totalSaleQuantity;
	}

	public double getTotalSaleValue() {
		return totalSaleValue;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, totalSaleQuantity, totalSaleValue, unitPrice);
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotalSaleQuantity(int totalSaleQuantity) {
		this.totalSaleQuantity = totalSaleQuantity;
	}

	public void setTotalSaleValue(double totalSaleValue) {
		this.totalSaleValue = totalSaleValue;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
