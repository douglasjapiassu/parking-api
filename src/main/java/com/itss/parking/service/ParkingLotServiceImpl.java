package com.itss.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itss.parking.dto.Dashboard;
import com.itss.parking.entity.ParkingLot;
import com.itss.parking.repository.ParkingLotRepository;

@Service("parkingLotService")
public class ParkingLotServiceImpl extends GenericServiceImpl<ParkingLot, Long> implements ParkingLotService {
	
	ParkingLotRepository parkingLotRepository;
	
	@Autowired
	public ParkingLotServiceImpl(ParkingLotRepository _repository) {
		super(_repository);
		this.parkingLotRepository = _repository;
	}

	@Override
	public List<Dashboard> searchParkingLotsDashboard() {
		return parkingLotRepository.searchParkingLotsDashboard();
	}

}
