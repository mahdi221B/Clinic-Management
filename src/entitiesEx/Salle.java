/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesEx;

import java.util.Objects;

/**
 *
 * @author acila
 */
public class Salle {
    private int idSalle;
    private int idEtageSalle;
    private String blocs;
    private String appareilUtilise  ;

    public Salle(int idSalle, int idEtageSalle, String blocs, String appareilUtilise) {
        this.idSalle = idSalle;
        this.idEtageSalle = idEtageSalle;
        this.blocs = blocs;
        this.appareilUtilise = appareilUtilise;
    }

    public Salle(int idSalle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public int getIdEtageSalle() {
        return idEtageSalle;
    }

    public void setIdEtageSalle(int idEtageSalle) {
        this.idEtageSalle = idEtageSalle;
    }

    public String getBlocs() {
        return blocs;
    }

    public void setBlocs(String blocs) {
        this.blocs = blocs;
    }

    public String getAppareilUtilise() {
        return appareilUtilise;
    }

    public void setAppareilUtilise(String appareilUtilise) {
        this.appareilUtilise = appareilUtilise;
    }

    @Override
    public String toString() {
        return "Salle{" + "idSalle=" + idSalle + ", idEtageSalle=" + idEtageSalle + ", blocs=" + blocs + ", appareilUtilise=" + appareilUtilise + '}';
    }

    
}
