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
public class Patient {
    private int idPatientp;
    private String nomprenomp ;
    private String dnp;
    private String sexep;
    private String adrp;

    public Patient(String text, String text0, String toString, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getSexep() {
        return sexep;
    }

    public void setSexep(String sexep) {
        this.sexep = sexep;
    }

    public String getAdrp() {
        return adrp;
    }

    public void setAdrp(String adrp) {
        this.adrp = adrp;
    }

    public Patient(int idPatientp, String nomprenomp, String dnp, String sexep, String adrp) {
        this.idPatientp = idPatientp;
        this.nomprenomp = nomprenomp;
        this.dnp = dnp;
        this.sexep = sexep;
        this.adrp = adrp;
    }
    
    

    public Patient(int idPatientp, String nomprenomp) {
        this.idPatientp = idPatientp;
        this.nomprenomp = nomprenomp;
    }

    public Patient(int idPatientp) {
        
    }
    public Patient( String nomprenomp) {
        
        this.nomprenomp = nomprenomp;
    }


    public int getIdPatientp() {
        return idPatientp;
    }

    public void setIdPatientp(int idPatientp) {
        this.idPatientp = idPatientp;
    }

    public String getNomprenomp() {
        return nomprenomp;
    }

    public void setNomprenomp(String nomprenomp) {
        this.nomprenomp = nomprenomp;
    }

    public Patient(int idPatientp, String nomprenomp, String dnp) {
        this.idPatientp = idPatientp;
        this.nomprenomp = nomprenomp;
        this.dnp = dnp;
    }

    public String getDnp() {
        return dnp;
    }

    public void setDnp(String dnp) {
        this.dnp = dnp;
    }

   
}
