package com.fikani.order.model;

import com.fikani.product.model.Product;

import lombok.Data;

@Data
public class CommerceItem {
	
	private Long id;
	private Long orderId;
	private Long productId;
	private Product product;
	private Double price;
	private Long quantity;
	private Double total;
}
