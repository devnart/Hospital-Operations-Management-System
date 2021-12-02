package com.hospital.Impl;

import com.hospital.enumerations.*;
import com.hospital.interfaces.OperationInterface;
import com.hospital.models.*;

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
	public void addOperation(List<Operation> operations, Hospital hospital, Doctor doctor, List<Nurse> nurses,Patient patient,Room room,operationType opType) {
		// TODO Auto-generated method stub

		System.out.println("Hospital : " + hospital.getName());
		System.out.println("Room number : " + room.getNumber() + " Stage : " + room.getStage());
		System.out.println("Patient Id : " + patient.getId() +" - "+ patient.getFirstname()+" "+ patient.getLastname() );
		System.out.println("Doctor :" + doctor.getId()+" - "+ doctor.getFirstname()+" "+ doctor.getLastname());

		System.out.println("Nurses :");
		for (Nurse nurse: nurses) {
			System.out.println( nurse.getId() + ". " + nurse.getFirstname() + " " + nurse.getLastname());
		}
		System.out.println(opType.getValue());
		if(opType.getValue().equals("urgent") && room.getStage() != 0){
			System.out.println("All urgent operations must take place in the first floor we will assign it for you");
			room.setStage(0);
		}
		System.out.println("Operation cost :");
		double cost = scanner.nextInt();

		while(cost > patient.getWallet()) {
			System.out.println("You don't have enough money you poor little thing");
			System.out.println("1. Add Money");
			System.out.println("2. Check wallet");
			System.out.println("3. Exit");

			int choice = scanner.nextInt();

			switch (choice) {
				case 1 :System.out.println("amount : "); patient.addToWallet(scanner.nextDouble());break;
				case 2 :System.out.println(patient.getWallet());break;
				case 3 : System.exit(0);
			}

		}
		// insurance
		double toPay = cost;
		InsuranceType insType = null;

		insType = patient.getInsuranceType();

		switch (insType){
			 case CNOPS: patient.addToWallet(cost);break;
			 case RAMED: patient.addToWallet(cost*0.8);toPay = cost * 0.2;break;
			 case CNSS: patient.addToWallet(cost*0.7);break;
		}



		Operation operation = new Operation(hospital,room,doctor,nurses,patient,cost,toPay,opType);
		operations.add(operation);


		System.out.println("// Operation created successfully");

		System.out.println("Operation details : ");
		System.out.println();
		System.out.println(" --> Patient entry : " + patient.getHospitalEntryDate());
		System.out.println(" --> " + operation.getRoom());
		System.out.println(" --> Doctor assigned : " + doctor.getFirstname() + " " + doctor.getLastname());
		System.out.println();

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

			} else if (choice == 0) {
				break;
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
