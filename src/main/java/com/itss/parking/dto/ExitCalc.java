package com.itss.parking.dto;

public class ExitCalc {
	
	private Long lenghtOfStayInMinutes;
	private Double amount;

	public ExitCalc(Long lenghtOfStayInMinutes, Double amount) {
		this.lenghtOfStayInMinutes = lenghtOfStayInMinutes;
		this.amount = amount;
	}

	public Long getLenghtOfStayInMinutes() {
		return lenghtOfStayInMinutes;
	}
	
	public Double getAmount() {
		return amount;
	}

}
