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
public class Evenement {
    private int id_evenement,id_categorie,phone_organisateur, montant_recolte;
    private String titre, description, lieu, nom_organisateur, email_organisateu;
    private String date_debut,date_fin;
    private String categorie;

    public Evenement() {
    }

    public Evenement(String titre) {
        this.titre = titre;
    }
    
    public Evenement(int montant_recolte ,String titre) {
        this.titre = titre;
        this.montant_recolte = montant_recolte;

    }

    
    
    public Evenement(int phone_organisateur, int montant_recolte, String titre, String description, String lieu, String nom_organisateur, String email_organisateu, String date_debut, String date_fin) {
        this.phone_organisateur = phone_organisateur;
        this.montant_recolte = montant_recolte;
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.nom_organisateur = nom_organisateur;
        this.email_organisateu = email_organisateu;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    
     public Evenement(int id_evenement, int phone_organisateur, int montant_recolte, String titre, String description, String lieu, String nom_organisateur, String email_organisateu, String date_debut, String date_fin, int id_categorie) {
        this.id_evenement = id_evenement;
        this.phone_organisateur = phone_organisateur;
        this.montant_recolte = montant_recolte;
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.nom_organisateur = nom_organisateur;
        this.email_organisateu = email_organisateu;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_categorie = id_categorie;
    }
     
     

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    
     public Evenement(int phone_organisateur, int montant_recolte, String titre, String description, String lieu, String nom_organisateur, String email_organisateu, String date_debut, String date_fin,int id_categorie) {
        this.phone_organisateur = phone_organisateur;
        this.montant_recolte = montant_recolte;
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.nom_organisateur = nom_organisateur;
        this.email_organisateu = email_organisateu;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_categorie = id_categorie;
    }
    
    public Evenement(int id_evenement,int phone_organisateur, int montant_recolte, String titre, String description, String lieu, String nom_organisateur, String email_organisateu, String date_debut, String date_fin,String categorie) {
        this.id_evenement = id_evenement;
        this.phone_organisateur = phone_organisateur;
        this.montant_recolte = montant_recolte;
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.nom_organisateur = nom_organisateur;
        this.email_organisateu = email_organisateu;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.categorie = categorie;
    }
    


    public Evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public Evenement(int id_evenement, int phone_organisateur, int montant_recolte, String titre, String description, String lieu, String nom_organisateur, String email_organisateu, String date_debut, String date_fin) {
        this.id_evenement = id_evenement;
        this.phone_organisateur = phone_organisateur;
        this.montant_recolte = montant_recolte;
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.nom_organisateur = nom_organisateur;
        this.email_organisateu = email_organisateu;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    
    public int getId_evenement() {
        return id_evenement;
    }

    public int getPhone_organisateur() {
        return phone_organisateur;
    }

    public int getMontant_recolte() {
        return montant_recolte;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getLieu() {
        return lieu;
    }

    public String getNom_organisateur() {
        return nom_organisateur;
    }

    public String getEmail_organisateu() {
        return email_organisateu;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setPhone_organisateur(int phone_organisateur) {
        this.phone_organisateur = phone_organisateur;
    }

    public void setMontant_recolte(int montant_recolte) {
        this.montant_recolte = montant_recolte;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setNom_organisateur(String nom_organisateur) {
        this.nom_organisateur = nom_organisateur;
    }

    public void setEmail_organisateu(String email_organisateu) {
        this.email_organisateu = email_organisateu;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_evenement=" + id_evenement + ", phone_organisateur=" + phone_organisateur + ", montant_recolte=" + montant_recolte + ", titre=" + titre + ", description=" + description + ", lieu=" + lieu + ", nom_organisateur=" + nom_organisateur + ", email_organisateu=" + email_organisateu + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", categorie=" + categorie + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id_evenement;
        hash = 59 * hash + this.phone_organisateur;
        hash = 59 * hash + this.montant_recolte;
        hash = 59 * hash + Objects.hashCode(this.titre);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.lieu);
        hash = 59 * hash + Objects.hashCode(this.nom_organisateur);
        hash = 59 * hash + Objects.hashCode(this.email_organisateu);
        hash = 59 * hash + Objects.hashCode(this.date_debut);
        hash = 59 * hash + Objects.hashCode(this.date_fin);
        return hash;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
        final Evenement other = (Evenement) obj;
        if (this.id_evenement != other.id_evenement) {
            return false;
        }
        if (this.phone_organisateur != other.phone_organisateur) {
            return false;
        }
        if (this.montant_recolte != other.montant_recolte) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.nom_organisateur, other.nom_organisateur)) {
            return false;
        }
        if (!Objects.equals(this.email_organisateu, other.email_organisateu)) {
            return false;
        }
        if (!Objects.equals(this.date_debut, other.date_debut)) {
            return false;
        }
        return Objects.equals(this.date_fin, other.date_fin);
    }


 
    
}
