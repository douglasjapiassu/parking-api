package com.itss.parking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class ParkingLot implements  Serializable {

	private static final long serialVersionUID = 1807175268472779832L;

	@Id
	@ApiModelProperty(value = "Parking lot code")
	@SequenceGenerator(name = "parking_lot_id_seq", sequenceName = "parking_lot_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_lot_id_seq")
	private Long id;
	
	@ApiModelProperty(value = "Parking description")
	@Column(nullable = false)
	private String description;

	@ApiModelProperty(value = "Parking spaces")
	@Column(nullable = false)
	private Integer parkingSpaces;
	
	@ApiModelProperty(value = "Hourly rate")
	@Column(nullable = false)
	private Double hourlyRate;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParkingSpaces() {
		return parkingSpaces;
	}

	public void setParkingSpaces(Integer parkingSpaces) {
		this.parkingSpaces = parkingSpaces;
	}

	public Double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
}
