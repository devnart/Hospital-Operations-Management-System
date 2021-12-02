package com.hospital.app;

import com.hospital.Impl.MailImpl;
import com.hospital.Impl.OperationImpl;
import com.hospital.enumerations.InsuranceType;
import com.hospital.enumerations.operationType;
import com.hospital.models.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Operation> operations = new ArrayList<>();
        List<Doctor> doctors = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();
        List<Nurse> nurses = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();


        // write your code here

        TimeSlot slot = new TimeSlot(12,15);

        Doctor doctor = new Doctor("Hamza","Bouchikhi","06050102","n/1","12342",slot,1200);
        Doctor doctor2 = new Doctor("Hera","Apo","06050102","n/1","12342",slot,1200);
        doctors.add(doctor);
        doctors.add(doctor2);


        Room room = new Room(2,1);
        rooms.add(room);

        Date entry = new Date(2021, Calendar.FEBRUARY,25);
        InsuranceType insurance = InsuranceType.CNOPS;
        InsuranceType insurance2 = InsuranceType.RAMED;

        Patient patient = new Patient("Salma","Kalkhi","0909876","Seb gwoula",entry,"0876",insurance,298.97);
        Patient patient2 = new Patient("Achraf","LOLKI","0909876","Lamiae",entry,"0876",insurance2,524.12);

        patients.add(patient);
        patients.add(patient2);

        Nurse nurse = new Nurse("Loubna","Soussi","0908716","Anass","123",slot,600);
        nurses.add(nurse);

        Hospital hospital = new Hospital("BCH","Berkane",doctors,nurses,rooms);

        OperationImpl operation = new OperationImpl();

        operationType opType = operationType.URGENT;
        operation.addOperation(operations,hospital,doctor,nurses,patient2,room,opType);

        MailImpl mail = new MailImpl();

        // generate string from operation
        String str = mail.generateString(operations);

        mail.sendMail("igpttdev@gmail.com","Operation Report",str);
    }
}
