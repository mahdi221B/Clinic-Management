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
public class user {
    private int id_user ;
    private String nom;
    private String prenom;
    private String sexe;
    private int num_tel;
    private int CIN;
    private String mot_passe;
    private String role ;
    private String adresse;
    
    
    
public user(){
        
    } 
    
public user(String nom, String prenom,String sexe,int num_tel,int CIN,String mot_passe,String role,String adresse ){ 
    this.nom=nom;
    this.prenom=prenom;
    this.sexe=sexe;
    this.num_tel=num_tel;
    this.CIN=CIN;
    this.mot_passe=mot_passe;
    this.role=role;
    this.adresse=adresse;

}  

public user(int id_user ){ 
    this.id_user=id_user;
    
}   

    public user(int id_user, String nom, String prenom, String sexe, int num_tel, int CIN, String mot_passe,String role,String adresse) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.num_tel = num_tel;
        this.CIN = CIN;
        this.mot_passe = mot_passe;
        this.role=role;
        this.adresse=adresse;
        
    }

  
    public int getId_user() {
        return id_user;
    }

   public void setId_user(int id_user) {
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public int getNum_tel(){
    return num_tel;
    }
    public void setNum_tel(int num_tel){
        this.num_tel=num_tel;
    }
    public int getCIN(){
    return CIN;
    }
    public void setCIN(int CIN){
    this.CIN=CIN;
    
    }
    public String getMot_passe(){
    return mot_passe;
    }
    
    public void setMot_passe(String mot_passe){
    this.mot_passe=mot_passe;
    }
    public String getRole(){
    return role;
    
    }
    public void setRole(String role){
    this.role=role;
    }
     public String getAdresse(){
    return adresse;
     }
     public void setAdresse(String adresse){
    this.adresse=adresse;
    }
    
    
    @Override
    public String toString() {
       return "user{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom +", sexe=" + sexe + ", num_tel=" + num_tel + ", CIN=" + CIN + ", mot_passe=" + mot_passe +", role=" + role + ", adresse=" + adresse + '}';
    }

   

    
}
