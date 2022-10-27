

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesEx;

/**
 *
 * @author acila
 */
public class SalleExamen {
    private int idSalle;
    private int idEx;
    private int idSalleEx;
    
    

    public SalleExamen(int idSalle, int idEx, int idSalleEx) {
        this.idSalle = idSalle;
        this.idEx = idEx;
        this.idSalleEx = idSalleEx;
    }

    public int getIdEx() {
        return idEx;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public int getIdSalleEx() {
        return idSalleEx;
    }

    public void setIdEx(int idEx) {
        this.idEx = idEx;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public void setIdSalleEx(int idSalleEx) {
        this.idSalleEx = idSalleEx;
    }

    @Override
    public String toString() {
        return "SalleExamen{" + "idSalle=" + idSalle + ", idEx=" + idEx + ", idSalleEx=" + idSalleEx + '}';
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
        final SalleExamen other = (SalleExamen) obj;
        if (this.idSalle != other.idSalle) {
            return false;
        }
        if (this.idEx != other.idEx) {
            return false;
        }
        if (this.idSalleEx != other.idSalleEx) {
            return false;
        }
        return true;
    }
    
    
    
/*
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
    public String toString() {
        return "SalleExamen{" + "idSalle=" + idSalle + ", idTechnicien=" + idTechnicien + ", appareiltilise=" + appareiltilise + '}';
    }

    
  */  

    public SalleExamen() {
    }
}

