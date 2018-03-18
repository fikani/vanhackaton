package com.fikani.product.route;

import static spark.Spark.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fikani.product.controller.ProductController;
import com.fikani.routes.IRoute;
import com.fikani.util.JsonUtil;

@Service
public class ProductRoutes implements IRoute {
	@Autowired
	private ProductController controller;

	@Override
	public void registerRoutes() {
		get("/api/v1/Product", controller.getAll(), JsonUtil.jsonParser());
		get("/api/v1/Product/search/:name", controller.searchByParam("name"), JsonUtil.jsonParser());
		get("/api/v1/Product/:id", controller.getById("id"), JsonUtil.jsonParser());
	}

}
