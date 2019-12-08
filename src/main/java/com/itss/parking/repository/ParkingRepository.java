package com.itss.parking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itss.parking.entity.Parking;

@Repository
public interface ParkingRepository extends IGenericRepository<Parking, Long>{

	List<Parking> findByVehicleIdAndExitDateIsNull(Long id);

}
