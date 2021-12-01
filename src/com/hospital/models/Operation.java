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
    // (done) Une opération sera dans un hopital, dans une salle spécifique, et géré par un médecin X qui fait partie de l'hopital :)

    // (done) Il faut vérifier l'assurance du patient avant de passer l'opération

	// (done) Ajouter une classe infirmière pour aider le médecin dans son travail
	
	// (done) l'assurance rembourse un pourcentage de 70% si c'est CNSS et 80% pour RAMED et 100% pour CNOPS
	
	// (done) chaque opération a un prix, le patient doit payer le montant et après l'hopital va lui remboursser (le cas du CNSS et CNOPS) , si RAMED le patient va juste
	// payer la différence dès le début (20%)
	
	// (done) Proposition : Ajouter un attribut portefeuille à la classe Patient pour gérer le solde du patient, et du coup il faut avoir aussi une classe transaction qui traçe les
	// actions de payments avec la date...
	
	// Essayer de structurer votre travail avec la création des interfaces qui vous permettez d'implémenter les méthodes nécessaires.

	// Après le payement d'une opération et si c'est passé avec succès le programme est terminé, sinon il faut renvoyer le montant vers la portefeuille patient
	// et dans ce cas son dossier est en stand by pour le discuter au tribunal. (vous devez gérer les status de chaque opération)
}