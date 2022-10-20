/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;
import java.util.Objects;

/**
 *
 * @author mahdi
 */
public class Sponsor {
    private int id_sponsor,phone_societe,montant_donnee;
    private String nom_societe, email_societe; 
    private String ts;

    public Sponsor() {
    }

    public Sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    
    
    public Sponsor(int phone_societe, int montant_donnee, String nom_societe, String email_societe, String ts) {
        this.phone_societe = phone_societe;
        this.montant_donnee = montant_donnee;
        this.nom_societe = nom_societe;
        this.email_societe = email_societe;
        this.ts = ts;
    }
    
    public Sponsor(int id_sponsor, int phone_societe, int montant_donnee, String nom_societe, String email_societe, String ts) {
        this.id_sponsor = id_sponsor;
        this.phone_societe = phone_societe;
        this.montant_donnee = montant_donnee;
        this.nom_societe = nom_societe;
        this.email_societe = email_societe;
        this.ts = ts;
    }

    public int getId_sponsor() {
        return id_sponsor;
    }

    public int getPhone_societe() {
        return phone_societe;
    }

    public int getMontant_donnee() {
        return montant_donnee;
    }

    public String getNom_societe() {
        return nom_societe;
    }

    public String getEmail_societe() {
        return email_societe;
    }

    public String getTs() {
        return ts;
    }

    public void setId_sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    public void setPhone_societe(int phone_societe) {
        this.phone_societe = phone_societe;
    }

    public void setMontant_donnee(int montant_donnee) {
        this.montant_donnee = montant_donnee;
    }

    public void setNom_societe(String nom_societe) {
        this.nom_societe = nom_societe;
    }

    public void setEmail_societe(String email_societe) {
        this.email_societe = email_societe;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id_sponsor;
        hash = 89 * hash + this.phone_societe;
        hash = 89 * hash + this.montant_donnee;
        hash = 89 * hash + Objects.hashCode(this.nom_societe);
        hash = 89 * hash + Objects.hashCode(this.email_societe);
        hash = 89 * hash + Objects.hashCode(this.ts);
        return hash;
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
        final Sponsor other = (Sponsor) obj;
        if (this.id_sponsor != other.id_sponsor) {
            return false;
        }
        if (this.phone_societe != other.phone_societe) {
            return false;
        }
        if (this.montant_donnee != other.montant_donnee) {
            return false;
        }
        if (!Objects.equals(this.nom_societe, other.nom_societe)) {
            return false;
        }
        if (!Objects.equals(this.email_societe, other.email_societe)) {
            return false;
        }
        return Objects.equals(this.ts, other.ts);
    }

    
}