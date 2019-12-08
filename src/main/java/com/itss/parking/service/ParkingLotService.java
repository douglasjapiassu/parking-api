package com.itss.parking.service;

import java.util.List;

import com.itss.parking.dto.Dashboard;
import com.itss.parking.entity.ParkingLot;

public interface ParkingLotService extends GenericService<ParkingLot, Long>{
	
	public List<Dashboard> searchParkingLotsDashboard();

}
