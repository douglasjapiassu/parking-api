package com.itss.parking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itss.parking.entity.Parking;
import com.itss.parking.service.ParkingService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/parking")
@ApiResponses(value = {
		@ApiResponse(code = 403, message = "You dont have permission to access"),
		@ApiResponse(code = 500, message = "Will throw exception"), })
public class ParkingController extends GenericController<Parking, Long>{

	private ParkingService parkingService;

	@Autowired
	public ParkingController(ParkingService service) {
		super(service);
		this.parkingService = service;
	}
	
	@PostMapping(value = "/entry", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void entry(@Valid @RequestBody Parking p) {
		parkingService.registerEntry(p);
	}
	
	@PostMapping(value = "/exit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void exit(@Valid @RequestBody Parking p) {
		parkingService.registerExit(p);
	}

	
}
