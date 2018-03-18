package com.fikani.product.model;

import lombok.Data;

@Data
public class Product {

	private Long id;
	private Long storeId;
	private String name;
	private String description;
	private Double price;
}
