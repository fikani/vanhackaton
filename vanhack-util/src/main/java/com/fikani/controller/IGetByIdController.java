package com.fikani.controller;

import com.fikani.service.IGetById;

import spark.Route;

public interface IGetByIdController {
	default public Route getById(String paramName) {
		return (req, res) -> {
			Long id = null;
			try {
				id = Long.valueOf(req.params(paramName));
				Object s = getService().getById(id);
				if (s == null) {
					res.status(404);
				} else {
					return s;
				}
			} catch (Exception e) {
				res.status(400);
			}
			return "";
		};
	}

	IGetById getService();
}
