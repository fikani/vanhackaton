package com.fikani.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fikani.controller.IController;
import com.fikani.controller.IControllerSearch;
import com.fikani.controller.IGetByIdController;
import com.fikani.product.service.ProductService;

@Component
public class ProductController implements IController, IControllerSearch, IGetByIdController {

	@Autowired
	private ProductService productService;

	@Override
	public ProductService getService() {
		return productService;
	}

}
