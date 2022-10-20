/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

import java.sql.Date;

/**
 *
 * @author miled
 */
public class commande {

    
 
    private int id_commande;
    private String status;
    private String date_ajout;
    private String date_cloture ;
    private String motif_cloture ;

    public commande(int id_commande, String status, String date_ajout, String date_cloture, String motif_cloture) {
        this.id_commande = id_commande;
        this.status = status;
        this.date_ajout = date_ajout;
        this.date_cloture = date_cloture;
        this.motif_cloture = motif_cloture;
    }

 
    public commande() {
    }

    public commande(String status, String date_ajout, String date_cloture, String motif_cloture) {
        this.status = status;
        this.date_ajout = date_ajout;
        this.date_cloture = date_cloture;
        this.motif_cloture = motif_cloture;
    }

    
    
    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(String date_ajout) {
        this.date_ajout = date_ajout;
    }

    public String getDate_cloture() {
        return date_cloture;
    }

    public void setDate_cloture(String date_cloture) {
        this.date_cloture = date_cloture;
    }

    public String getMotif_cloture() {
        return motif_cloture;
    }

    public void setMotif_cloture(String motif_cloture) {
        this.motif_cloture = motif_cloture;
    }

    public commande(int id_commande) {
        this.id_commande = id_commande;
    }
   
    
    
}
