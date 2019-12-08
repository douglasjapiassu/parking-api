package com.itss.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itss.parking.entity.Client;
import com.itss.parking.service.ClientService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/client")
@ApiResponses(value = {
		@ApiResponse(code = 403, message = "You dont have permission to access"),
		@ApiResponse(code = 500, message = "Will throw exception"), })
public class ClientController extends GenericController<Client, Long>{

	@Autowired
	public ClientController(ClientService service) {
		super(service);
	}

}
