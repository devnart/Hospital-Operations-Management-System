package com.hospital.models;

import com.hospital.enumerations.InsuranceType;

import java.util.Date;
import java.util.List;

public class Patient extends Person{

	private Date hospitalEntryDate;
	private String affiliationNumber;
	private InsuranceType insuranceType;
	private Double wallet;
	public Patient(){

	}
	public Patient(String firstname, String lastname, String phone, String address,Date hospitalEntryDate,String affiliationNumber,InsuranceType insuranceType) {
		super(firstname, lastname, phone, address);
		this.hospitalEntryDate = hospitalEntryDate;
		this.affiliationNumber = affiliationNumber;
		this.insuranceType = insuranceType;
	}

	public Date getHospitalEntryDate() {
		return hospitalEntryDate;
	}

	public void setHospitalEntryDate(Date hospitalEntryDate) {
		this.hospitalEntryDate = hospitalEntryDate;
	}

	public String getAffiliationNumber() {
		return affiliationNumber;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	public void setAffiliationNumber(String affiliationNumber) {
		this.affiliationNumber = affiliationNumber;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	public Boolean isAvailable(int id, List<Patient> patientList){
		for (Patient patient: patientList)
		{
			if(patient.getId() == id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Patient [hospitalEntryDate=" + hospitalEntryDate + ", affiliationNumber=" + affiliationNumber
				+ ", insuranceType=" + insuranceType + "]";
	}	
}
