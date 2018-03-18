package com.fikani.order.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Order {
	private Long id;
	private Date date;
	private Long customerId;
	private String deliveryAddress;
	private String contact;
	private Long storeId;
	private Double total;
	private String status;
	private Date lastUpdate;
	private List<CommerceItem> orderItems;
}
