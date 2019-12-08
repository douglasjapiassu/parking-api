package com.itss.parking.service;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itss.parking.entity.Parking;
import com.itss.parking.repository.ParkingRepository;

@Service("parkingService")
public class ParkingServiceImpl extends GenericServiceImpl<Parking, Long> implements ParkingService {

	private ParkingRepository parkingRepository;
	
	@Autowired
	public ParkingServiceImpl(ParkingRepository _repository) {
		super(_repository);
		this.parkingRepository = _repository;
	}

	@Override
	public void registerEntry(@Valid Parking p) {
		this.parkingRepository.save(p);
	}
	
	@Override
	public void registerExit(@Valid Parking p) {
		List<Parking> parkedList = this.parkingRepository.findByVehicleIdAndExitDateIsNull(p.getVehicle().getId());
		if (parkedList != null && !parkedList.isEmpty()) {
			Parking parked = parkedList.iterator().next();
			parked.setExitDate(new Timestamp(System.currentTimeMillis()));
			this.parkingRepository.save(parked);
		}
	}

}
