/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitesEx;

import java.util.*;

/**
 *
 * @author acila
 */
public class Examen {
    private int idEx,idMedecin,idSalle,idPatient;
    private Date dateEx;
    private TypeExamen typeEx;
    private String resultatEx;

    public Examen() {
    }
      public Examen(int idEx, int idMedecin, int idSalle, Date dateEx) {
        this.idEx = idEx;
        this.idMedecin = idMedecin;
        this.idSalle = idSalle;
        this.dateEx = dateEx;
       
    }

    public Examen(int idEx, int idMedecin, int idSalle, Date dateEx, TypeExamen typeEx) {
        this.idEx = idEx;
        this.idMedecin = idMedecin;
        this.idSalle = idSalle;
        this.dateEx = dateEx;
        this.typeEx = typeEx;
    }
    

    public Date getDateEx() {
        return dateEx;
    }

    public int getIdEx() {
        return idEx;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public TypeExamen getTypeEx() {
        return typeEx;
    }

    public String getResultatEx() {
        return resultatEx;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
    
    public void setDateEx(Date dateEx) {
        this.dateEx = dateEx;
    }

    public void setIdEx(int idEx) {
        this.idEx = idEx;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public void setTypeEx(TypeExamen typeEx) {
        this.typeEx = typeEx;
       
    }

    public void setResultatEx(String resultatEx) {
        this.resultatEx = resultatEx;
    }

    public Examen(int idEx, int idMedecin, int idSalle, int idPatient, Date dateEx, TypeExamen typeEx, String resultatEx) {
        this.idEx = idEx;
        this.idMedecin = idMedecin;
        this.idSalle = idSalle;
        this.idPatient = idPatient;
        this.dateEx = dateEx;
        this.typeEx = typeEx;
        this.resultatEx = resultatEx;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
