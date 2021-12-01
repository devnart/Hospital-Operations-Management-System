package com.hospital.models;

import com.hospital.interfaces.OperationInterface;

import javax.print.Doc;
import java.util.List;

public class Operation {

    private Hospital hospital;
    private Room room;
    private Doctor doctor;
    private List<Nurse> nurse;
    private Patient patient;
    private Double cost;
    private Double toPay;
    private String status;

    public Operation(Hospital hospital, Room room, Doctor doctor, List<Nurse> nurse, Patient patient, Double cost, Double toPay) {
        this.hospital = hospital;
        this.room = room;
        this.doctor = doctor;
        this.nurse = nurse;
        this.patient = patient;
        this.cost = cost;
        this.toPay = toPay;

    }

    public Hospital getHospital() {
        return hospital;
    }

    public Room getRoom() {
        return room;
    }

    public Double getCost() {
        return cost;
    }

    public Double getToPay() {
        return toPay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "hospital='" + hospital + '\'' +
                ", room=" + room +
                ", doctor=" + doctor +
                ", nurse=" + nurse +
                ", patient=" + patient +
                ", cost=" + cost +
                ", toPay=" + toPay +
                '}';
    }
    // (done) Une op�ration sera dans un hopital, dans une salle sp�cifique, et g�r� par un m�decin X qui fait partie de l'hopital :)

    // (done) Il faut v�rifier l'assurance du patient avant de passer l'op�ration

	// (done) Ajouter une classe infirmi�re pour aider le m�decin dans son travail
	
	// (done) l'assurance rembourse un pourcentage de 70% si c'est CNSS et 80% pour RAMED et 100% pour CNOPS
	
	// (done) chaque op�ration a un prix, le patient doit payer le montant et apr�s l'hopital va lui remboursser (le cas du CNSS et CNOPS) , si RAMED le patient va juste
	// payer la diff�rence d�s le d�but (20%)
	
	// (done) Proposition : Ajouter un attribut portefeuille � la classe Patient pour g�rer le solde du patient, et du coup il faut avoir aussi une classe transaction qui tra�e les
	// actions de payments avec la date...
	
	// Essayer de structurer votre travail avec la cr�ation des interfaces qui vous permettez d'impl�menter les m�thodes n�cessaires.

	// Apr�s le payement d'une op�ration et si c'est pass� avec succ�s le programme est termin�, sinon il faut renvoyer le montant vers la portefeuille patient
	// et dans ce cas son dossier est en stand by pour le discuter au tribunal. (vous devez g�rer les status de chaque op�ration)
}