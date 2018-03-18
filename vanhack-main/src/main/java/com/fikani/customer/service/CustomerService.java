package com.fikani.customer.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.fikani.customer.model.Customer;
import com.fikani.service.IGetById;
import com.fikani.util.IValidator;
import com.fikani.util.PredicatesUtil;

@Service
public class CustomerService {
	Predicate<String> isEmpty = PredicatesUtil.isEmpty;

	private Map<String, Customer> data = new HashMap<>();

	public boolean validateCredentials(String email, String password) {
		Customer c = this.data.getOrDefault(email, null);
		if (c != null && password.equals(c.getPassword())) {
			return true;
		}
		return false;
	}

	public void createCostumer(Customer customer) throws CustomerNotValidException, CustomerExistsException {
		if (customer != null && validator.isValid(customer)) {
			customer.setId(this.data.keySet().size() + 1);
			customer.setCreation(new Date());
			if (this.data.keySet().contains(customer.getEmail())) {
				throw new CustomerExistsException();
			}
			this.data.put(customer.getEmail(), customer);
		} else {
			throw new CustomerNotValidException();
		}
	}

	private IValidator<Customer> validator = c -> {
		if (isEmpty.test(c.getEmail()) || isEmpty.test(c.getName()) || isEmpty.test(c.getPassword())
				|| isEmpty.test(c.getAddress())) {

			return false;
		}
		return true;
	};

	public Customer getByEmail(String email) {
		return this.data.getOrDefault(email, null);
	}
}
