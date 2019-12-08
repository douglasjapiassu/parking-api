package com.itss.parking.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itss.parking.service.GenericService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
		@ApiResponse(code = 403, message = "You dont have permission to access"),
		@ApiResponse(code = 500, message = "Will throw exception"), })
public abstract class GenericController<T, PK extends Serializable> {

	protected GenericService<T, PK> _service;
	
	public GenericController(GenericService<T, PK> service) {
		this._service = service;
	}

	public GenericController() {
		
	}
	
	@ApiOperation(value = "Retrieve objs list")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve objs list"), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<T> get() {
		return _service.findAll();
	}

	@ApiOperation(value = "Retrieve obj by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve obj by id"), })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> getById(@PathVariable(value = "id") PK id) {
		Optional<T> obj = _service.findById(id);
		if (obj.isPresent()) {
			return new ResponseEntity<T>(obj.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create new")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "T saved"), })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public T post(@Valid @RequestBody T obj) throws Exception {
		return _service.save(obj);
	}


	@ApiOperation(value = "Update resource")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "T updated"), })
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> put(@PathVariable(value = "id") PK id, @Valid @RequestBody T newT) {
		Optional<T> oldT = _service.findById(id);
		if (oldT.isPresent()) {
			T obj = oldT.get();
			_service.save(obj);
			return new ResponseEntity<T>(obj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@ApiOperation(value = "Delete resource")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "T deleted"), })
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete(@PathVariable(value = "id") PK id) {
		Optional<T> obj = _service.findById(id);
		if (obj.isPresent()) {
			_service.delete(obj.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
