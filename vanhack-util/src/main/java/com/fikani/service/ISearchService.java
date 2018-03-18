package com.fikani.service;

import java.util.Collection;
import java.util.stream.Collectors;

public interface ISearchService<T> {

	Collection<T> getData();

	String getSearchString(T p);

	public default Collection<T> getBySearchString(String name) {

		return getData().stream().filter(s -> getSearchString(s).indexOf(name) != -1).collect(Collectors.toList());
	}
}
