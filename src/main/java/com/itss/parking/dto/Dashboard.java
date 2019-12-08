package com.itss.parking.dto;

public class Dashboard {

	private Long id;
	private String description;
	private Integer parkingSpaces;
	private Double hourlyRate;
	private Long freeParkingSpaces;
	
	public Dashboard(Long id, String description, Integer parkingSpaces, Double hourlyRate, Long freeParkingSpaces) {
		this.id = id;
		this.description = description;
		this.parkingSpaces = parkingSpaces;
		this.hourlyRate = hourlyRate;
		this.freeParkingSpaces = freeParkingSpaces;
	}

	public Long getId() {
		return id;
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

	public Long getFreeParkingSpaces() {
		return freeParkingSpaces;
	}

	public void setFreeParkingSpaces(Long freeParkingSpaces) {
		this.freeParkingSpaces = freeParkingSpaces;
	}

}
