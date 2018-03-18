package com.fikani.order.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.fikani.order.model.Order;
import com.fikani.service.IGetById;
import com.fikani.util.IValidator;
import com.fikani.util.PredicatesUtil;

@Service
public class OrderService implements IGetById<Order> {
	Predicate<String> isEmpty = PredicatesUtil.isEmpty;

	private Map<Long, Order> data = new HashMap<>();

	@Override
	public Order getById(Long id) {
		return this.data.getOrDefault(id, null);
	}

	public void createOrder(Order order) throws OrderNotValidException {
		if (order != null && validator.isValid(order)) {
			order.setId(Long.valueOf(this.data.keySet().size() + 1));
			order.setDate(new Date());
			order.setLastUpdate(order.getDate());
			this.data.put(order.getId(), order);
		} else {
			throw new OrderNotValidException();
		}
	}

	public Order getUserLastOrder(Long id) {
		return this.data.values().stream().filter(o -> o.getCustomerId() == id).sorted((o1, o2) -> {
			return o2.getDate().compareTo(o1.getDate());
		}).findFirst().orElse(null);
	}

	private IValidator<Order> validator = c -> {
		// TODO validate order fields
		return true;
	};
}
