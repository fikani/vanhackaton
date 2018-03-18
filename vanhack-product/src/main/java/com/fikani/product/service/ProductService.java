package com.fikani.product.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.stereotype.Service;

import com.fikani.product.model.Product;
import com.fikani.service.IGetAllService;
import com.fikani.service.IGetById;
import com.fikani.service.ISearchService;

@Service
public class ProductService implements IGetAllService<Product>, ISearchService<Product>, IGetById<Product> {

	private Map<Long, Product> data = new HashMap<>();

	public ProductService() {
		LongStream.range(1, 10).forEach(n -> {
			Product p = new Product();
			p.setId(n);
			p.setName("Product " + n);
			p.setStoreId(n);
			p.setPrice(Double.valueOf(n));
			this.data.put(n, p);
		});
	}

	public Collection<Product> findByStore(Long storeId) {
		return getData().stream().filter(s -> s.getStoreId().equals(storeId)).collect(Collectors.toList());
	}

	@Override
	public Collection<Product> getData() {
		return data.values();
	}

	@Override
	public String getSearchString(Product p) {
		return p.getName();
	}

	@Override
	public Product getById(Long id) {
		return this.data.getOrDefault(id, null);
	}

}
