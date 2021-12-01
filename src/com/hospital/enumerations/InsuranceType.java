package com.hospital.enumerations;

public enum InsuranceType {

	CNSS("CNSS",70),
	RAMED("RAMED",80),
	CNOPS("CNOPS",100);
	
	private final String value;
	private final int percent;
	InsuranceType(String value,int percent) {
		this.value = value;
		this.percent = percent;
	}
	
	
	public String getValue() {
		return value;
	}
	public int getPercent() {
		return percent;
	}
}
