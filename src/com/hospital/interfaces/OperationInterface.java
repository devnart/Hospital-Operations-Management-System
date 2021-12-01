package com.hospital.interfaces;

import com.hospital.models.*;

import java.util.List;
import java.util.Optional;


public interface OperationInterface {

	public Optional<Operation> getOperationByRef(int ref);
	
	public void addOperation(List<Operation> operations, Hospital hospital, List<Doctor> doctors, List<Nurse> nurses,List<Patient> patients,List<Room> rooms);
}
