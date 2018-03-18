package com.fikani.customer.controller;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fikani.auth.AuthHelper;
import com.fikani.customer.model.Customer;
import com.fikani.customer.service.CustomerExistsException;
import com.fikani.customer.service.CustomerNotValidException;
import com.fikani.customer.service.CustomerService;
import com.fikani.util.PredicatesUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import spark.Route;

@Component
public class CustomerController {

	Predicate<String> isEmpty = PredicatesUtil.isNotEmpty;

	@Autowired
	private CustomerService customerService;

	public Route auth = (req, res) -> {
		String email = req.queryMap("email").value();
		String password = req.queryMap("password").value();
		res.status(400);
		if (isEmpty.test(email) && isEmpty.test(password)) {
			if (this.customerService.validateCredentials(email, password)) {
				res.status(200);
				Long userId = customerService.getByEmail(email).getId();
				String token = AuthHelper.generateToken(userId);
				return new TokenResponse(token);
			}
		}
		return "";
	};

	public Route createCostumer = (req, res) -> {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Customer customer = mapper.readValue(req.body(), Customer.class);
			this.customerService.createCostumer(customer);
			res.status(200);
		} catch (JsonParseException | JsonMappingException | CustomerNotValidException e) {
			res.status(400);
		} catch (CustomerExistsException e) {
			res.status(422);
		}
		return "";
	};
}
