package com.fikani.store.route;

import static spark.Spark.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fikani.routes.IRoute;
import com.fikani.store.controller.StoreController;
import com.fikani.util.JsonUtil;

@Service
public class StoreRoutes implements IRoute {
	@Autowired
	private StoreController controller;

	public void registerRoutes() {
		get("/api/v1/Store", controller.getAll(), JsonUtil.jsonParser());
		get("/api/v1/Store/search/:name", controller.searchByParam("name"), JsonUtil.jsonParser());
		get("/api/v1/Store/:id", controller.getById("id"), JsonUtil.jsonParser());
		get("/api/v1/Store/:id/products", controller.getProductsByStoreId, JsonUtil.jsonParser());
		
	}
}
