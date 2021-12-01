package com.hospital.Impl;

import com.hospital.enumerations.InsuranceType;
import com.hospital.interfaces.OperationInterface;
import com.hospital.models.*;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OperationImpl implements OperationInterface{
	Scanner scanner = new Scanner(System.in);

	@Override
	public Optional<Operation> getOperationByRef(int ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOperation(List<Operation> operations, Hospital hospital, List<Doctor> doctors, List<Nurse> nurses,List<Patient> patients,List<Room> rooms) {
		// TODO Auto-generated method stub

		System.out.println("Hospital : " + hospital.getName());
		System.out.println("Room number : ");

		int roomId = scanner.nextInt();

		Room rm = new Room();
		while (!rm.isAvailable(roomId,rooms)) {
			System.out.println("Unavailable room choose another one :");
			roomId = scanner.nextInt();
		}


		System.out.println("Patient Id : ");
		for (Patient patient: patients) {
			System.out.println( patient.getId() + ". " + patient.getFirstname() + " " + patient.getLastname());
		}
		int patientId = scanner.nextInt();

		Patient pt = new Patient();
		while (!pt.isAvailable(patientId,patients)) {
			System.out.println("Unavailable patient choose another one :");
			patientId = scanner.nextInt();
		}

		System.out.println("Doctor :");
		for (Doctor doctor: doctors) {
			System.out.println( doctor.getId() + ". " + doctor.getFirstname() + " " + doctor.getLastname());
		}
		int docId = scanner.nextInt();

		Doctor dr = new Doctor();
		while (!dr.isAvailable(docId,doctors)) {
			System.out.println("Unavailable doctor choose another one :");
			docId = scanner.nextInt();
		}

		for (Nurse nurse: nurses) {
			System.out.println( nurse.getId() + ". " + nurse.getFirstname() + " " + nurse.getLastname());
		}

		System.out.println("Nurse :");
		int nurseId = scanner.nextInt();

		Nurse nr = new Nurse();
		while (!nr.isAvailable(nurseId,nurses)) {
			System.out.println("Unavailable nurse choose another one :");
			nurseId = scanner.nextInt();
		}

		System.out.println("Operation cost :");
		double cost = scanner.nextInt();

		// insurance
		double toPay = cost;
		InsuranceType insType = null;

		for (Patient patient: patients) {
			if (patient.getId() == patientId) {
				 insType = patient.getInsuranceType();

				 switch (insType){
					 case CNOPS: patient.setWallet(cost);break;
					 case RAMED: patient.setWallet(cost*0.8);toPay = cost * 0.2;break;
					 case CNSS: patient.setWallet(cost*0.7);break;
				 }
			}
		}

		Operation operation = new Operation(hospital,roomId,docId,nurseId,patientId,cost,toPay);
		operations.add(operation);


		System.out.println("// Operation created successfully");

		System.out.println("---------------Menu-----------------");

		System.out.println("1.Check Status");
		System.out.println("2.Edit Status");
		System.out.println("3.Total Cost");
		System.out.println("4.Total Paid");
		System.out.println("0.Exit");


		System.out.println("--------------------------------");
		int choice = scanner.nextInt();
		scanner.nextLine();
		do {

			if (choice == 1) {
				System.out.println(operation.getStatus());
			} else if (choice == 2) {
				System.out.println("Set Status");
				System.out.println("pending");
				System.out.println("done");
				System.out.println("failed");

				String status = scanner.nextLine();
				operation.setStatus(status);
			} else if(choice == 3) {
				System.out.println(operation.getCost());
			} else if(choice == 4) {
				System.out.println(operation.getToPay());

			}
			System.out.println("---------------Menu-----------------");

			System.out.println("1.Check Status");
			System.out.println("2.Edit Status");
			System.out.println("3.Total Cost");
			System.out.println("4.Total Paid");
			System.out.println("0.Exit");


			System.out.println("--------------------------------");
		choice = scanner.nextInt();
		scanner.nextLine();
		}while (choice != 0);

	}



}
