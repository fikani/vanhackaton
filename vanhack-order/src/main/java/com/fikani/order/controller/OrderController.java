package com.fikani.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fikani.auth.AuthHelper;
import com.fikani.controller.IGetByIdController;
import com.fikani.order.model.Order;
import com.fikani.order.service.OrderNotValidException;
import com.fikani.order.service.OrderService;

import spark.Route;

@Component
public class OrderController implements IGetByIdController {

	@Autowired
	private OrderService service;

	@Override
	public OrderService getService() {
		return service;
	}

	public Route createOrder = (req, res) -> {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Order order = mapper.readValue(req.body(), Order.class);
			this.service.createOrder(order);
			res.status(200);
		} catch (JsonParseException | JsonMappingException | OrderNotValidException e) {
			res.status(400);
		}
		return "";
	};

	public Route getCurrent = (req, res) -> {
		String token = req.headers("Authorization").split(" ")[1];
		String id = AuthHelper.getId(token);
		Order order = this.service.getUserLastOrder(Long.valueOf(id));
		if (order != null) {
			return order;
		}
		res.status(404);
		return "";
	};

}
