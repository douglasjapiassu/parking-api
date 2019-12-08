package com.itss.parking.utils;

public enum Color {
	
	WHITE(1, "BRANCO"),
	BLACK(2, "PRETO"),
	SILVER(3, "PRATA"),
	RED(4, "VERMELHO"),
	BLUE(5, "AZUL"),
	YELLOW(6, "AMARELO");
	
	public Integer code;
	public String label;
	
	Color(Integer code, String label) {
		this.code = code;
		this.label = label;
	}

}