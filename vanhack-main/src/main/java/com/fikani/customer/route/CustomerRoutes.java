package com.fikani.customer.route;
import static spark.Spark.get;
import static spark.Spark.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fikani.customer.controller.CustomerController;
import com.fikani.util.JsonUtil;


@Service
public class CustomerRoutes {
	@Autowired
	private CustomerController controller;
	
	public void registerRoutes() {
		//TODO take the auth endpoint to an auth module/auth microservice 
		get("/api/v1/Customer/auth", controller.auth, JsonUtil.jsonParser());
		post("/api/v1/Customer", controller.createCostumer);
	}

}
