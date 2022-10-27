/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;


import java.util.Objects;

/**
 *
 * @author miled
 */
public class articles {
    private int id_articles;

    public articles(int id_articles, String nom, int Qte, String description) {
        this.id_articles = id_articles;
        this.nom_articles = nom;
        this.Qte = Qte;
        this.description = description;
    }

   

    private String nom_articles;
    private int  Qte;
    private String description ;
    //private type_articles  type
    private String type ;
    private String  a_qui_destiné;

    public articles(int id_articles) {
        this.id_articles = id_articles;
    }
     public articles(int id_articles, int Qte) {
        this.id_articles = id_articles;
        this.Qte = Qte;
    }
    //private destine  a_qui_destiné;

    public int getId_articles() {
        return id_articles;
    }

    public void setId_articles(int id_articles) {
        this.id_articles = id_articles;
    }

    public String getNom_articles() {
        return nom_articles;
    }

    public void setNom_articles(String nom_articles) {
        this.nom_articles = nom_articles;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int Qte) {
        this.Qte = Qte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getA_qui_destiné() {
        return a_qui_destiné;
    }

    public void setA_qui_destiné(String a_qui_destiné) {
        this.a_qui_destiné = a_qui_destiné;
    }

    public articles(String nom, int Qte, String description, String type, String a_qui_destiné) {
        this.nom_articles = nom;
        this.Qte = Qte;
        this.description = description;
        this.type = type;
        this.a_qui_destiné = a_qui_destiné;
    }

    public articles() {
    }

    public articles(int id_articles, String nom, int Qte, String description, String type, String a_qui_destiné) {
        this.id_articles = id_articles;
        this.nom_articles = nom;
        this.Qte = Qte;
        this.description = description;
        this.type = type;
        this.a_qui_destiné = a_qui_destiné;
    }
  @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id_articles;
        hash = 31 * hash + Objects.hashCode(this.nom_articles);
        hash = 31 * hash + this.Qte;
        hash = 31 * hash + Objects.hashCode(this.description);
        hash = 31 * hash + Objects.hashCode(this.type);
        hash = 31 * hash + Objects.hashCode(this.a_qui_destiné);
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
        final articles other = (articles) obj;
        if (this.id_articles != other.id_articles) {
            return false;
        }
        if (this.Qte != other.Qte) {
            return false;
        }
        if (!Objects.equals(this.nom_articles, other.nom_articles)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return Objects.equals(this.a_qui_destiné, other.a_qui_destiné);
    }
    }

     
    
    

