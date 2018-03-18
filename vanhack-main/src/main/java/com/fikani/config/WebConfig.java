package com.fikani.config;

import static spark.Spark.staticFileLocation;

import com.fikani.service.impl.RoutesService;

public class WebConfig {
	
	private RoutesService routes;
	

	public WebConfig(RoutesService routes) {
		this.routes = routes;
		staticFileLocation("/public");
		routes.registerRoutes();
	}
	
}
