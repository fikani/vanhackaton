package com.fikani.cuisine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fikani.controller.IController;
import com.fikani.controller.IControllerSearch;
import com.fikani.controller.IGetByIdController;
import com.fikani.cuisine.service.CuisineService;

import spark.Route;

@Component
public class CuisineController implements IController, IControllerSearch, IGetByIdController{
	@Autowired
	private CuisineService service;

	@Override
	public CuisineService getService() {
		return service;
	}
	
	public Route cousineStores = (req, res)->{
		Long id = null;
		try {
			id = Long.valueOf(req.params("cousineId"));
			Object stores = getService().getCuisineStores(id);
			return stores;
		} catch (Exception e) {
			res.status(400);
		}
		return "";
	};
	
}
