/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisiteEntities;

import java.util.Date;



public class RendezVous {
    private int idRv;
    private String nomPatient;
    private String dateRendezVous;
    private String heure,nomMedecinRv,cause;

    public RendezVous() {
    }

    public RendezVous(int idRv) {
        this.idRv = idRv;
    }

    public RendezVous(String nomPatient, String dateRendezVous, String heure, String nomMedecinRv, String cause) {
        this.nomPatient = nomPatient;
        this.dateRendezVous = dateRendezVous;
        this.heure = heure;
        this.nomMedecinRv = nomMedecinRv;
        this.cause = cause;
    }

    public RendezVous(int idRv, String nomPatient, String dateRendezVous, String heure, String nomMedecinRv, String cause) {
        this.idRv = idRv;
        this.nomPatient = nomPatient;
        this.dateRendezVous = dateRendezVous;
        this.heure = heure;
        this.nomMedecinRv = nomMedecinRv;
        this.cause = cause;
    }

    public int getIdRv() {
        return idRv;
    }

    public void setIdRv(int idRv) {
        this.idRv = idRv;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(String dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getNomMedecinRv() {
        return nomMedecinRv;
    }

    public void setNomMedecinRv(String nomMedecinRv) {
        this.nomMedecinRv = nomMedecinRv;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idRv;
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
        final RendezVous other = (RendezVous) obj;
        if (this.idRv != other.idRv) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RendezVous{" + "id=" + idRv+ ", nomPatient=" + nomPatient + ", dateRendezVous=" + dateRendezVous + ", heure=" + heure + ", nomMedecinRv=" + nomMedecinRv + ", cause=" + cause + '}';
    }
    
    
    
    
}
