package com.fikani.store.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.LongStream;

import org.springframework.stereotype.Service;

import com.fikani.service.IGetAllService;
import com.fikani.service.IGetById;
import com.fikani.service.ISearchService;
import com.fikani.store.model.Store;
import com.fikani.util.PredicatesUtil;

@Service
public class StoreService implements IGetAllService<Store>, ISearchService<Store>, IGetById<Store> {
	Predicate<String> isEmpty = PredicatesUtil.isEmpty;
	private Map<Long, Store> data = new HashMap<>();

	public StoreService() {
		LongStream.range(1, 10).forEach(n -> {
			Store p = new Store(n, "Product " + n, "Address " + n, n);
			this.data.put(n, p);
		});
	}

	@Override
	public Store getById(Long id) {
		return this.data.getOrDefault(id, null);
	}

	@Override
	public String getSearchString(Store p) {
		return p.getName();
	}

	@Override
	public Collection<Store> getData() {
		return data.values();
	}

}
