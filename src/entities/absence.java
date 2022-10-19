/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ce pc
 */
public class absence {
    private int id_absence ;
    private String id_user ;
    private String nom;
    private String prenom;
    private String date_absence;
    private String duré_absence ;      
    private String justification;
    
    public absence(){
        
    } 

    public absence(String id_user, String nom, String prenom, String date_absence, String duré_absence, String justification) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.date_absence = date_absence;
        this.duré_absence = duré_absence;
        this.justification = justification;
    }
   
    
 
    public absence(int id_absence ){ 
    this.id_absence=id_absence;  
    }   

    public absence(String nom, String prenom, String date_absence, String duré_absence, String justification) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_absence = date_absence;
        this.duré_absence = duré_absence;
        this.justification = justification;
    }


    public absence(int id_absence,String id_user, String nom, String prenom, String date_absence, String duré_absence, String justification) {
        this.id_absence=id_absence;
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.date_absence = date_absence;
        this.duré_absence = duré_absence;
        this.justification = justification;
    }

    
    
 
   

    public int getId_absence() {
        return id_absence;
    }

    public void setId_absence(int id_absence) {
        this.id_absence = id_absence;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_absence() {
        return date_absence;
    }

    public void setDate_absence(String date_absence) {
        this.date_absence = date_absence;
    }

    public String getDuré_absence() {
        return duré_absence;
    }

    public void setDuré_absence(String duré_absence) {
        this.duré_absence = duré_absence;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

 @Override
    public String toString() {
       return "absence{" + "id_absence=" + id_absence +",id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom +", date_absence=" + date_absence + ", duré_absence=" + duré_absence + ", justification=" + justification + '}';
    }
    
    
}
