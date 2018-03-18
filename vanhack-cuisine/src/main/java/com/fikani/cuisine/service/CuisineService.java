package com.fikani.cuisine.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fikani.cuisine.model.Cuisine;
import com.fikani.service.IGetAllService;
import com.fikani.service.IGetById;
import com.fikani.service.ISearchService;
import com.fikani.store.model.Store;
import com.fikani.store.service.StoreService;

@Service
public class CuisineService implements IGetAllService<Cuisine>, ISearchService<Cuisine>, IGetById<Cuisine> {

	@Autowired
	private StoreService storeService;
	private Map<Long, Cuisine> data = new HashMap<>();

	public CuisineService() {
		LongStream.range(1, 10).forEach(n -> {
			Cuisine p = new Cuisine();
			p.setId(n);
			p.setName("Cuisine " + n);
			this.data.put(n, p);
		});
	}
	
	public List<Store> getCuisineStores(Long id){
		return this.storeService.getAll(null, null).stream().filter(s -> s.getCousineId() == id).collect(Collectors.toList());
	}
	
	@Override
	public Cuisine getById(Long id) {
		return this.data.getOrDefault(id, null);
	}

	@Override
	public String getSearchString(Cuisine p) {
		return p.getName();
	}

	@Override
	public Collection<Cuisine> getData() {
		return data.values();
	}

}
