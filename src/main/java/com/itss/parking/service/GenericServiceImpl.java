package com.itss.parking.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.itss.parking.repository.IGenericRepository;

@Transactional
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

	protected IGenericRepository<T, PK> _repository;

	public GenericServiceImpl(IGenericRepository<T, PK> _repository) {
		this._repository = _repository;
	}

	@Override
	public List<T> findAll() {
		return _repository.findAll();
	}

	@Override
	public T save(T entity) {
		return _repository.save(entity);
	}

	@Override
	public Optional<T> findById(PK id) {
		return _repository.findById(id);
	}

	@Override
	public void delete(T entity) {
		_repository.delete(entity);
	}

	@Override
	public void deleteById(PK id) {
		_repository.deleteById(id);
	}

	@Override
	public long count() {
		return _repository.count();
	}

}