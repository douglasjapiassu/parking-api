package com.itss.parking.service;

import javax.validation.Valid;

import com.itss.parking.dto.ExitCalc;
import com.itss.parking.entity.Parking;

public interface ParkingService extends GenericService<Parking, Long>{

	void registerEntry(@Valid Parking p);

	void registerExit(@Valid Parking p);
	
	ExitCalc processExitCalc(Long parkingLotId, Long vehicleId);

}
