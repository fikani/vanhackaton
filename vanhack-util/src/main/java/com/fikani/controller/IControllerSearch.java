package com.fikani.controller;

import java.util.Collection;
import java.util.Collections;

import com.fikani.service.ISearchService;

import spark.Route;

public interface IControllerSearch {

	default public Route searchByParam(String paramName) {
		return (req, res) -> {
			Collection stores = Collections.EMPTY_LIST;
			res.status(200);
			String name = req.params(paramName);

			if (name != null) {
				stores = getService().getBySearchString(name);
			}

			return stores;
		};
	}

	ISearchService getService();

}
