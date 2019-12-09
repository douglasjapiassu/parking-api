package com.itss.parking.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itss.parking.dto.ExitCalc;
import com.itss.parking.entity.Parking;
import com.itss.parking.entity.ParkingLot;
import com.itss.parking.repository.ParkingLotRepository;
import com.itss.parking.repository.ParkingRepository;

@Service("parkingService")
public class ParkingServiceImpl extends GenericServiceImpl<Parking, Long> implements ParkingService {

	private ParkingRepository parkingRepository;
	
	@Autowired
	private ParkingLotRepository parkingLotRepository;
	
	@Autowired
	public ParkingServiceImpl(ParkingRepository _repository) {
		super(_repository);
		this.parkingRepository = _repository;
	}

	@Override
	public void registerEntry(@Valid Parking p) {
		p.setEntryDate(LocalDateTime.now());
		this.parkingRepository.save(p);
	}
	
	@Override
	public void registerExit(@Valid Parking p) {
		List<Parking> parkedList = this.parkingRepository.findByVehicleIdAndExitDateIsNull(p.getVehicle().getId());
		if (parkedList != null && !parkedList.isEmpty()) {
			Parking parked = parkedList.iterator().next();
			parked.setExitDate(LocalDateTime.now());
			this.parkingRepository.save(parked);
		}
	}

	@Override
	public ExitCalc processExitCalc(Long parkingLotId, Long vehicleId) {
		ParkingLot pl = this.parkingLotRepository.getOne(parkingLotId);
		if (pl != null) {
			List<Parking> parkedList = this.parkingRepository.findByVehicleIdAndExitDateIsNull(vehicleId);
			
			if (parkedList != null && !parkedList.isEmpty()) {
				Parking parked = parkedList.iterator().next();
				
				Long diff = parked.getEntryDate().until(LocalDateTime.now(), ChronoUnit.MILLIS);
				double amount = (TimeUnit.MILLISECONDS.toHours(diff) + 1l) * pl.getHourlyRate();
				
				return new ExitCalc(TimeUnit.MILLISECONDS.toMinutes(diff), amount);
			}
		}
		
		
		return null;
	}

}
