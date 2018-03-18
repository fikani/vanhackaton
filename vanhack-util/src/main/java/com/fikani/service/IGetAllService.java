package com.fikani.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IGetAllService<T> {

	Collection<T> getData();

	default Collection<T> getAll(Integer max, Integer skip) {
		Optional<Integer> skipValue = Optional.ofNullable(skip);
		Optional<Integer> maxValue = Optional.ofNullable(max);

		Stream<T> result = this.getData().stream();
		result = skipValue.isPresent() ? result.skip(skip) : result;
		result = maxValue.isPresent() ? result.limit(max) : result;
		return result.collect(Collectors.toList());
	}

}
