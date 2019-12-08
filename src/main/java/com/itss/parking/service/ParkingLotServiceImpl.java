package com.itss.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itss.parking.dto.Dashboard;
import com.itss.parking.entity.ParkingLot;
import com.itss.parking.repository.ParkingLotRepository;

@Service("parkingLotService")
public class ParkingLotServiceImpl extends GenericServiceImpl<ParkingLot, Long> implements ParkingLotService {
	
	@Autowired
	public ParkingLotServiceImpl(ParkingLotRepository _repository) {
		super(_repository);
	}

	@Override
	public List<Dashboard> searchParkingLotsDashboard() {
		return ((ParkingLotRepository)_repository).searchParkingLotsDashboard();
	}

}
