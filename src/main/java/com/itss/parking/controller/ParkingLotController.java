package com.itss.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itss.parking.dto.Dashboard;
import com.itss.parking.entity.ParkingLot;
import com.itss.parking.service.ParkingLotService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/parking-lot")
@ApiResponses(value = {
		@ApiResponse(code = 403, message = "You dont have permission to access"),
		@ApiResponse(code = 500, message = "Will throw exception"), })
public class ParkingLotController extends GenericController<ParkingLot, Long>{

	@Autowired
	public ParkingLotController(ParkingLotService service) {
		super(service);
	}
	
	@GetMapping(value = "/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Dashboard> getDashboard() {
		return ((ParkingLotService)_service).searchParkingLotsDashboard();
	}
	

	
}
