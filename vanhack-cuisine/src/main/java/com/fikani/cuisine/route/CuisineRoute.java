package com.fikani.cuisine.route;

import static spark.Spark.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fikani.cuisine.controller.CuisineController;
import com.fikani.routes.IRoute;
import com.fikani.util.JsonUtil;

@Service
public class CuisineRoute implements IRoute {
	@Autowired
	private CuisineController controller;

	@Override
	public void registerRoutes() {
		get("/api/v1/Cousine", controller.getAll(), JsonUtil.jsonParser());
		get("/api/v1/Cousine/search/:name", controller.searchByParam("name"), JsonUtil.jsonParser());
		get("/api/v1/Cousine/:cousineId/stores", controller.cousineStores,  JsonUtil.jsonParser());
	}

}
