/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisiteEntities;

import VisiteEntities.Traitement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USER
 */

public class Consultation {
    private int idCon;
    private String dateConsultation;
    private String nomPatient,nomMedecin;
   private String listMedicament ;
    private String listExamens ;
    private String traitement;

    public Consultation() {
    }

  public Consultation(int idCon, String dateConsultation, String nomPatient, String nomMedecin, String listMedicament, String listExamens, String traitement) {
        this.idCon = idCon;
        this.dateConsultation = dateConsultation;
        this.nomPatient = nomPatient;
        this.nomMedecin = nomMedecin;
        this.listMedicament = listMedicament;
        this.listExamens = listExamens;
        this.traitement = traitement;
    }

    public Consultation(int idCon) {
        this.idCon = idCon;
    }

  public Consultation(String nomPatient, String nomMedecin, String listMedicament, String listExamens, String traitement) {
        this.nomPatient = nomPatient;
        this.nomMedecin = nomMedecin;
        this.listMedicament = listMedicament;
        this.listExamens = listExamens;
        this.traitement = traitement;
    }

    public Consultation(String dateConsultation, String nomPatient, String nomMedecin, String listMedicament, String listExamens, String traitement) {
        this.dateConsultation = dateConsultation;
        this.nomPatient = nomPatient;
        this.nomMedecin = nomMedecin;
        this.listMedicament = listMedicament;
        this.listExamens = listExamens;
        this.traitement = traitement;
    }

    public int getIdCon() {
        return idCon;
    }

    public void setIdCon(int idCon) {
        this.idCon = idCon;
    }

    public String getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(String date) {
        this.dateConsultation = dateConsultation;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getListMedicament() {
        return listMedicament;
    }

    public void setListMedicament(String listMedicament) {
        this.listMedicament = listMedicament;
    }

    public String getListExamens() {
        return listExamens;
    }

    public void setListExamens(String listExamens) {
        this.listExamens = listExamens;
    }

   
    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idCon;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consultation other = (Consultation) obj;
        if (this.idCon != other.idCon) {
            return false;
        }
        return true;
    }

   
    
    

    
    

   
    

    @Override
    public String toString() {
        return "Consultation{" + "id=" + idCon + ", date=" + dateConsultation + ", nomPatient=" + nomPatient + ", nomMedecin=" + nomMedecin + ", listMedicament=" + listMedicament + ", listExamens=" + listExamens + ", traitement=" + traitement + '}';
    }
    
    
    
    
    
}
