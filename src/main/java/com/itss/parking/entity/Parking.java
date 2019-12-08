package com.itss.parking.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Parking implements Serializable {

	private static final long serialVersionUID = -7661412687073689886L;

	@Id
	@ApiModelProperty(value = "Parking code")
	@SequenceGenerator(name = "parking_id_seq", sequenceName = "parking_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_id_seq")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@ApiModelProperty(value = "Vehicle")
	@JoinColumn(name = "vehicleId")
	private Vehicle vehicle;
	
	@ApiModelProperty(value = "Parking lot code")
	@ManyToOne
	@JoinColumn(name = "parkingLotId")
	private ParkingLot parkingLot;
	
	@ApiModelProperty(value = "Parking entry date")
	@Column
	private Timestamp entryDate;
	
	@ApiModelProperty(value = "Parking exit date")
	@Column
	private Timestamp exitDate;

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public Timestamp getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Timestamp entryDate) {
		this.entryDate = entryDate;
	}

	public Timestamp getExitDate() {
		return exitDate;
	}

	public void setExitDate(Timestamp exitDate) {
		this.exitDate = exitDate;
	}
	
}
