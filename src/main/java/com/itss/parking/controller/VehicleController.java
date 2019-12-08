package com.itss.parking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itss.parking.dto.CodeLabel;
import com.itss.parking.entity.Vehicle;
import com.itss.parking.service.VehicleService;
import com.itss.parking.utils.Color;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/vehicle")
@ApiResponses(value = {
		@ApiResponse(code = 403, message = "You dont have permission to access"),
		@ApiResponse(code = 500, message = "Will throw exception"), })
public class VehicleController extends GenericController<Vehicle, Long>{

	VehicleService vehicleService;
	
	@Autowired
	public VehicleController(VehicleService service) {
		super(service);
		this.vehicleService = service;
	}
	
	@GetMapping(value = "/{parkingLotId}/parked")
	public List<Vehicle> parked(@PathVariable Long parkingLotId) {
		return this.vehicleService.findParkedVehicles(parkingLotId);
	}
	
	@GetMapping(value = "/{parkingLotId}/not-parked")
	public List<Vehicle> notParked(@PathVariable Long parkingLotId) {
		return this.vehicleService.findNotParkedVehicles(parkingLotId);
	}
	
	@GetMapping(value = "/colors")
	public List<CodeLabel> colors() {
		List<CodeLabel> colors = new ArrayList<>();
		for (Color c : Color.values()) {
			colors.add(new CodeLabel(c.code, c.label));
		}
		return colors;
	}

	
}
