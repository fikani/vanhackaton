package com.fikani.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fikani.controller.IController;
import com.fikani.controller.IControllerSearch;
import com.fikani.controller.IGetByIdController;
import com.fikani.product.service.ProductService;
import com.fikani.store.model.Store;
import com.fikani.store.service.StoreService;

import spark.Route;

@Component
public class StoreController implements IController, IControllerSearch, IGetByIdController {

	@Autowired
	private StoreService storeService;

	@Autowired
	private ProductService productService;

	public Route getProductsByStoreId = (req, res) -> {
		Long id = null;
		try {
			id = Long.valueOf(req.params("id"));
			Store s = this.storeService.getById(id);

			if (s == null) {
				res.status(404);
			} else {
				return this.productService.findByStore(id);
			}
		} catch (Exception e) {
			res.status(400);
		}
		return "";
	};

	@Override
	public StoreService getService() {
		// TODO Auto-generated method stub
		return storeService;
	}

}
