package com.itss.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itss.parking.entity.Vehicle;
import com.itss.parking.repository.VehicleRepository;

@Service("vehicleService")
public class VehicleServiceImpl extends GenericServiceImpl<Vehicle, Long> implements VehicleService {
	
	private VehicleRepository vehicleRepository;

	@Autowired
	public VehicleServiceImpl(VehicleRepository _repository) {
		super(_repository);
		this.vehicleRepository = _repository;
	}

	@Override
	public List<Vehicle> findParkedVehicles(Long parkingLotId) {
		return this.vehicleRepository.findParkedVehicles(parkingLotId);
	}
	
	@Override
	public List<Vehicle> findNotParkedVehicles(Long parkingLotId) {
		return this.vehicleRepository.findNotParkedVehicles(parkingLotId);
	}

}
