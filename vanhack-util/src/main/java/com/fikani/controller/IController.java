package com.fikani.controller;

import com.fikani.service.IGetAllService;

import spark.Route;

public interface IController {
	default public Route getAll() {
		
		return (req, res) ->{
			res.status(200);
			return getService().getAll(null, null);
		};
	}
	
	IGetAllService getService();
}
