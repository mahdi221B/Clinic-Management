/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitesEx;

/**
 *
 * @author acila
 */
public class SalleExamen {
    private int idSalle,idTechnicien;
    private String appareiltilise;

    public SalleExamen() {
    }

    public SalleExamen(int idSalle, int idTechnicien, String appareiltilise) {
        this.idSalle = idSalle;
        this.idTechnicien = idTechnicien;
        this.appareiltilise = appareiltilise;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    
    public int getIdTechnicien() {
        return idTechnicien;
    }

    public void setIdTechnicien(int idTechnicien) {
        this.idTechnicien = idTechnicien;
    }

    public String getAppareiltilise() {
        return appareiltilise;
    }

    public void setAppareiltilise(String appareiltilise) {
        this.appareiltilise = appareiltilise;
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

