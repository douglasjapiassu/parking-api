package com.itss.parking.dto;

public class CodeLabel {

	private Integer code;
	private String label;

	public CodeLabel(Integer code, String label) {
		this.code = code;
		this.label = label;
	}

	public Integer getCode() {
		return code;
	}
	
	public String getLabel() {
		return label;
	}

}
