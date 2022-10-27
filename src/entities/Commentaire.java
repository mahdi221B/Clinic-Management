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
public class Commentaire {
private int Id_Commentaire,User_Id_Commentaire,Id_Post_Commentaire;
private String Text_Commentaire;
 

public Commentaire() {

}

    public Commentaire(int Id_Commentaire,String Text_Commentaire ,int User_Id_Commentaire, int Id_Post_Commentaire) {
        this.Id_Commentaire = Id_Commentaire;
        this.User_Id_Commentaire = User_Id_Commentaire;
        this.Text_Commentaire = Text_Commentaire;
        this.Id_Post_Commentaire = Id_Post_Commentaire;
    }

    public Commentaire(int Id_Commentaire, int User_Id_Commentaire) {
        this.Id_Commentaire = Id_Commentaire;
        this.User_Id_Commentaire = User_Id_Commentaire;
    }
    

    public Commentaire(String Text_Commentaire,int User_Id_Commentaire, int Id_Post_Commentaire ) {
        this.Text_Commentaire = Text_Commentaire;
        this.User_Id_Commentaire = User_Id_Commentaire; 
        this.Id_Post_Commentaire = Id_Post_Commentaire;
    }

    
    
    public Commentaire(int Id_Commentaire) {
        this.Id_Commentaire = Id_Commentaire;
    }

    public int getId_Commentaire() {
        return Id_Commentaire;
    }

    public void setId_Commentaire(int Id_Commentaire) {
        this.Id_Commentaire = Id_Commentaire;
    }

    public int getUser_Id_Commentaire() {
        return User_Id_Commentaire;
    }

    public void setUser_Id_Commentaire(int User_Id_Commentaire) {
        this.User_Id_Commentaire = User_Id_Commentaire;
    }

    public int getId_Post_Commentaire() {
        return Id_Post_Commentaire;
    }

    public void setId_Post_Commentaire(int Id_Post_Commentaire) {
        this.Id_Post_Commentaire = Id_Post_Commentaire;
    }

    public String getText_Commentaire() {
        return Text_Commentaire;
    }

    public void setText_Commentaire(String Text_Commentaire) {
        this.Text_Commentaire = Text_Commentaire;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.Id_Commentaire;
        hash = 89 * hash + this.User_Id_Commentaire;
        hash = 89 * hash + this.Id_Post_Commentaire;
        hash = 89 * hash + Objects.hashCode(this.Text_Commentaire);
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
        final Commentaire other = (Commentaire) obj;
        if (this.Id_Commentaire != other.Id_Commentaire) {
            return false;
        }
        if (this.User_Id_Commentaire != other.User_Id_Commentaire) {
            return false;
        }
        if (this.Id_Post_Commentaire != other.Id_Post_Commentaire) {
            return false;
        }
        return Objects.equals(this.Text_Commentaire, other.Text_Commentaire);
    }

    
    

    @Override
    public String toString() {
        return "Commentaire{" + "Id_Commentaire=" + Id_Commentaire + ", Text_Commentaire=" + Text_Commentaire + ", User_Id_Commentaire=" + User_Id_Commentaire + ", Id_Post_Commentaire=" + Id_Post_Commentaire + + '}';
    }
}



