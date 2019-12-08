package com.itss.parking.service;

import java.util.List;

import com.itss.parking.entity.Vehicle;

public interface VehicleService extends GenericService<Vehicle, Long>{

	List<Vehicle> findParkedVehicles(Long parkingLotId);

	List<Vehicle> findNotParkedVehicles(Long parkingLotId);

}
