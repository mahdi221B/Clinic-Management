/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesEx;

import java.util.*;
import javafx.scene.Scene;
import servicesEx.ServiceExamen;

/**
 *
 * @author acila
 */
public class Examen {

    private int idEx;
    private String idMedecin;
    private String idSalle;
    private String idPatient;
    private String dateEx;
    private String typeEx;
    private String resEx;

    public Examen(int idEx, String idMedecin, String idSalle, String idPatient, String dateEx, String typeEx, String resEx) {
        this.idEx = idEx;
        this.idMedecin = idMedecin;
        this.idSalle = idSalle;
        this.idPatient = idPatient;
        this.dateEx = dateEx;
        this.typeEx = typeEx;
        this.resEx = resEx;
    }

    public Examen(int idEx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdEx() {
        return idEx;
    }

    public void setIdEx(int idEx) {
        this.idEx = idEx;
    }

    public String getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(String idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getDateEx() {
        return dateEx;
    }

    public void setDateEx(String dateEx) {
        this.dateEx = dateEx;
    }

    public String getTypeEx() {
        return typeEx;
    }

    public void setTypeEx(String typeEx) {
        this.typeEx = typeEx;
    }

    public String getResEx() {
        return resEx;
    }

    public void setResEx(String resEx) {
        this.resEx = resEx;
    }

    @Override
    public String toString() {
        return "Examen{" + "idEx=" + idEx + ", idMedecin=" + idMedecin + ", idSalle=" + idSalle + ", idPatient=" + idPatient + ", dateEx=" + dateEx + ", typeEx=" + typeEx + ", resEx=" + resEx + '}';
    }

    
}
