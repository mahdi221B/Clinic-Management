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
public class Medecin {
    private int idMedecinm;
    private String nomprenomm;
    private String adrm;

    public String getAdrm() {
        return adrm;
    }

    public void setAdrm(String adrm) {
        this.adrm = adrm;
    }

    public Medecin(int idMedecinm, String nomprenomm, String adrm) {
        this.idMedecinm = idMedecinm;
        this.nomprenomm = nomprenomm;
        this.adrm = adrm;
    }

    public Medecin(int idMedecinm, String nomprenomm) {
        this.idMedecinm = idMedecinm;
        this.nomprenomm = nomprenomm;
    }

    public Medecin(int idMedecinm) {
        
    }

    public int getIdMedecinm() {
        return idMedecinm;
    }

    public void setIdMedecinm(int idMedecinm) {
        this.idMedecinm = idMedecinm;
    }

    public String getNomprenomm() {
        return nomprenomm;
    }

    public void setNomprenomm(String nomprenomm) {
        this.nomprenomm = nomprenomm;
    }

    @Override
    public String toString() {
        return "Medecin{" + "idMedecinm=" + idMedecinm + ", nomprenomm=" + nomprenomm + ", adrm=" + adrm + '}';
    }
    
    
}
