package com.itss.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itss.parking.dto.Dashboard;
import com.itss.parking.entity.ParkingLot;

@Repository
public interface ParkingLotRepository extends IGenericRepository<ParkingLot, Long>{
	
	@Query("SELECT new com.itss.parking.dto.Dashboard(pl.id, pl.description, pl.parkingSpaces, pl.hourlyRate, pl.parkingSpaces - sum(case when p.id is not null and p.exitDate is null then 1 else 0 end) as freeParkingSpaces) " +
			"FROM ParkingLot pl left join Parking p on p.parkingLot.id = pl.id group by pl.id")
	List<Dashboard> searchParkingLotsDashboard();

}
