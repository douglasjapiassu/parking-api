package com.itss.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itss.parking.entity.Vehicle;

@Repository
public interface VehicleRepository extends IGenericRepository<Vehicle, Long>{
	
	@Query("SELECT DISTINCT v FROM Vehicle v join Parking p on p.vehicle.id = v.id and p.parkingLot.id = ?1 WHERE p.exitDate is null")
	List<Vehicle> findParkedVehicles(Long parkingLotId);
	
	@Query("SELECT DISTINCT v FROM Vehicle v left join Parking p on p.vehicle.id = v.id WHERE (p.id is null or p.exitDate is not null)"
			+ " and v.id not in (select p2.vehicle.id from Parking p2 where p2.exitDate is null)")
	List<Vehicle> findNotParkedVehicles(Long parkingLotId);

}
