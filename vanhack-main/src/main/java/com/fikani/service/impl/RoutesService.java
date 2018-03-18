package com.fikani.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fikani.cuisine.route.CuisineRoute;
import com.fikani.customer.route.CustomerRoutes;
import com.fikani.order.route.OrderRoute;
import com.fikani.product.route.ProductRoutes;
import com.fikani.store.route.StoreRoutes;

@Service
public class RoutesService {
	@Autowired
	private CustomerRoutes customer;

	@Autowired
	private StoreRoutes store;
	@Autowired
	private ProductRoutes product;

	@Autowired
	private CuisineRoute cuisine;
	
	@Autowired
	private OrderRoute order;

	public void registerRoutes() {
		customer.registerRoutes();
		store.registerRoutes();
		product.registerRoutes();
		cuisine.registerRoutes();
		order.registerRoutes();
	}

}
