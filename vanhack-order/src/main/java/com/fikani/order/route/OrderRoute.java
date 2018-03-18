package com.fikani.order.route;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fikani.auth.AuthHelper;
import com.fikani.order.controller.OrderController;
import com.fikani.routes.IRoute;
import com.fikani.util.JsonUtil;

@Service
public class OrderRoute implements IRoute {

	@Autowired
	private OrderController controller;

	@Override
	public void registerRoutes() {
		//Auth
		before("/api/v1/Order/customer", AuthHelper.authenticate);
		get("/api/v1/Order/customer", controller.getCurrent, JsonUtil.jsonParser());

		get("/api/v1/Order/:orderId", controller.getById("orderId"), JsonUtil.jsonParser());
		post("/api/v1/Order", controller.createOrder, JsonUtil.jsonParser());
	}

}
