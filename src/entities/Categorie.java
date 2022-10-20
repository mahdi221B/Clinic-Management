/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;

/**
 *
 * @author ThinkPad
 */
public class Categorie {
    int Id_Categorie;
    private String Text_Categorie;
    private String Date_Creation_Categorie;
    int Id_Createur_Categorie;

    public Categorie() {
    }

    public Categorie(int Id_Categorie) {
        this.Id_Categorie = Id_Categorie;
    }

    
    public Categorie(int Id_Categorie, String Text_Categorie, String Date_Creation_Categorie, int Id_Createur_Categorie) {
        this.Id_Categorie = Id_Categorie;
        this.Text_Categorie = Text_Categorie;
        this.Date_Creation_Categorie = Date_Creation_Categorie;
        this.Id_Createur_Categorie = Id_Createur_Categorie;
    }

    public Categorie(String Text_Categorie, String Date_Creation_Categorie, int Id_Createur_Categorie) {
        this.Text_Categorie = Text_Categorie;
        this.Date_Creation_Categorie = Date_Creation_Categorie;
        this.Id_Createur_Categorie = Id_Createur_Categorie;
    }

    public int getId_Categorie() {
        return Id_Categorie;
    }

    public void setId_Categorie(int Id_Categorie) {
        this.Id_Categorie = Id_Categorie;
    }

    public String getText_Categorie() {
        return Text_Categorie;
    }

    public void setText_Categorie(String Text_Categorie) {
        this.Text_Categorie = Text_Categorie;
    }

    public String getDate_Creation_Categorie() {
        return Date_Creation_Categorie;
    }

    public void setDate_Creation_Categorie(String Date_Creation_Categorie) {
        this.Date_Creation_Categorie = Date_Creation_Categorie;
    }

    public int getId_Createur_Categorie() {
        return Id_Createur_Categorie;
    }

    public void setId_Createur_Categorie(int Id_Createur_Categorie) {
        this.Id_Createur_Categorie = Id_Createur_Categorie;
    }

    @Override
    public String toString() {
        return "Categorie{" + "Id_Categorie=" + Id_Categorie + ", Text_Categorie=" + Text_Categorie + ", Date_Creation_Categorie=" + Date_Creation_Categorie + ", Id_Createur_Categorie=" + Id_Createur_Categorie + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.Id_Categorie;
        hash = 79 * hash + Objects.hashCode(this.Text_Categorie);
        hash = 79 * hash + Objects.hashCode(this.Date_Creation_Categorie);
        hash = 79 * hash + this.Id_Createur_Categorie;
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
        final Categorie other = (Categorie) obj;
        if (this.Id_Categorie != other.Id_Categorie) {
            return false;
        }
        if (this.Id_Createur_Categorie != other.Id_Createur_Categorie) {
            return false;
        }
        if (!Objects.equals(this.Text_Categorie, other.Text_Categorie)) {
            return false;
        }
        return Objects.equals(this.Date_Creation_Categorie, other.Date_Creation_Categorie);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

