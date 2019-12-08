package com.itss.parking.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericService<T, PK extends Serializable> {
	List<T> findAll();

	T save(T entity);

	Optional<T> findById(PK id);

	void delete(T entity);

	void deleteById(PK id);

	long count();
}