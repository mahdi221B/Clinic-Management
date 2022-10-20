/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisiteEntities;

import java.util.Date;

/**
 *
 * @author USER
 */
public class DossierPatient {
   private int idP;
   private String nomP;
   private String  AllergieMedicaments , Medicaments;
   private String Consultations;
   private String detailsOperation ,maladies;

    public DossierPatient() {
    }

    public DossierPatient(int idP) {
        this.idP = idP;
    }

    public DossierPatient(int idP, String nomP, String AllergieMedicaments, String Medicaments, String Consultations, String detailsOperation, String maladies) {
        this.idP = idP;
        this.nomP = nomP;
        this.AllergieMedicaments = AllergieMedicaments;
        this.Medicaments = Medicaments;
        this.Consultations = Consultations;
        this.detailsOperation = detailsOperation;
        this.maladies = maladies;
    }

    public DossierPatient(String nomP, String AllergieMedicaments, String Medicaments, String Consultations, String detailsOperation, String maladies) {
        this.nomP = nomP;
        this.AllergieMedicaments = AllergieMedicaments;
        this.Medicaments = Medicaments;
        this.Consultations = Consultations;
        this.detailsOperation = detailsOperation;
        this.maladies = maladies;
    }
   
    
    

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nom) {
        this.nomP = nomP;
    }

    public String getAllergieMedicaments() {
        return AllergieMedicaments;
    }

    public void setAllergieMedicaments(String AllergieMedicaments) {
        this.AllergieMedicaments = AllergieMedicaments;
    }

    public String getMedicaments() {
        return Medicaments;
    }

    public void setMedicaments(String Medicaments) {
        this.Medicaments = Medicaments;
    }

    public String getConsultations() {
        return Consultations;
    }

    public void setConsultations(String derniereConsultation) {
        this.Consultations = derniereConsultation;
    }

    public String getDetailsOperation() {
        return detailsOperation;
    }

    public void setDetailsOperation(String detailsOperation) {
        this.detailsOperation = detailsOperation;
    }

    public String getMaladies() {
        return maladies;
    }

    public void setMaladies(String maladies) {
        this.maladies = maladies;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idP;
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
        final DossierPatient other = (DossierPatient) obj;
        if (this.idP != other.idP) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DossierPatient{" + "id=" + idP + ", nom=" + nomP + ", AllergieMedicaments=" + AllergieMedicaments + ", Medicaments=" + Medicaments + ", derniereConsultation=" + Consultations + ", detailsOperation=" + detailsOperation + ", maladies=" + maladies + '}';
    }
    
    
    
}
