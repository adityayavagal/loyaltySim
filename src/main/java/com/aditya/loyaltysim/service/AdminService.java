package com.aditya.loyaltysim.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aditya.loyaltysim.model.Coupon;
import com.aditya.loyaltysim.model.Order;
import com.aditya.loyaltysim.service.dto.InsightsDTO;
import com.aditya.loyaltysim.service.dto.ProductSalesDTO;

@Service
public class AdminService {
	
	@Autowired
	CouponService couponService;
	
	@Autowired
	OrderService orderService;
	
	@Value("${coupon.config.discount}")
	private double discount;
	
	public InsightsDTO getInsights() {
		List<Order> ordersList = orderService.getAllOrders();
		double totalSales = getTotalSales(ordersList); 
		double totalDiscountValue = getTotalDiscountedValue(ordersList);
		List<Coupon> coupons = couponService.getAllCoupons();
		List<ProductSalesDTO> cart = getProductSales(ordersList);
		InsightsDTO dto = new InsightsDTO();
		dto.setCoupons(coupons);
		dto.setTotalSales(totalSales);
		dto.setProductSales(cart);
		dto.setTotalDiscounts(totalDiscountValue);
		return dto;
	}
	
	public double getTotalSales(List<Order> ordersList) {
		return ordersList.stream()
				.mapToDouble(order -> order.getTotalPrice())
				.sum();
		
	}
	
	public List<ProductSalesDTO> getProductSales(List<Order> orderList) {
		// Map to track the products that have been bought
		// and accumulate the total sales value of the product and it's total sold quantity
		Map<String, ProductSalesDTO> productSalesMap = new HashMap<String, ProductSalesDTO>();
		orderList.stream()
				.flatMap(order -> order.getItems().stream())
				.forEach(product -> {
					//If the product is already available in the Map
					// We compute and update quantity and total sale value
					if (productSalesMap.containsKey(product.getId())) {
						ProductSalesDTO temp = productSalesMap.get(product.getId());
						int subTotalQuantity = temp.getTotalSaleQuantity();
						double subTotalSaleValue = temp.getTotalSaleValue();
						double productSubTotal = product.getPrice() * product.getQuantity();
						temp.setTotalSaleQuantity(subTotalQuantity + product.getQuantity());
						temp.setTotalSaleValue(subTotalSaleValue + productSubTotal );
					} else {
						//If the product isn't available in the Map we add it with initial values. 
						double subTotal = product.getPrice() * product.getQuantity();
						ProductSalesDTO temp = new ProductSalesDTO(
								product.getId(),
								product.getName(),
								product.getPrice(),
								product.getQuantity(), subTotal);
						productSalesMap.put(product.getId(), temp);
					}
				});
		return productSalesMap.values().stream().collect(Collectors.toList());
	}
	
	public double getTotalDiscountedValue(List<Order> orderList) {
		return orderList.stream()
			.filter(order -> order.getCoupon() != null && order.getCoupon().trim().length() != 0)
			.mapToDouble(order -> order.getTotalPrice() * (discount / 100))
			.sum();
	}

}
