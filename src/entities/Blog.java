/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ThinkPad
 */
public class Blog {
   
    private int Id_Post,User_Id_Post;
    private String Sujet_Post,Description_Post,Review_Post,Date_Post;
   



public Blog(){

}

    public Blog(int Id_Post,String Sujet_Post, String Description_Post,  String Date_Post,String Review_Post,int User_Id_Post) {
        this.Id_Post = Id_Post;
        this.Sujet_Post = Sujet_Post;
        this.Description_Post = Description_Post;
        this.Date_Post = Date_Post;
        this.Review_Post = Review_Post;
        this.User_Id_Post = User_Id_Post;
        
    }

    public Blog(int Id_Post, int User_Id_Post, String Sujet_Post, String Description_Post, String Review_Post) {
        this.Id_Post = Id_Post;
        this.User_Id_Post = User_Id_Post;
        this.Sujet_Post = Sujet_Post;
        this.Description_Post = Description_Post;
        this.Review_Post = Review_Post;
    }
    
    

   

    public Blog(String Sujet_Post, String Description_Post, String Date_Post, String Review_Post,int User_Id) {
        
        this.Sujet_Post = Sujet_Post;
        this.Description_Post = Description_Post;
        this.Date_Post = Date_Post;
        this.Review_Post = Review_Post;
        this.User_Id_Post = User_Id;
    }


    public Blog(int User_Id_Post, String Sujet_Post, String Description_Post, String Review_Post, String Date_Post) {
        this.User_Id_Post = User_Id_Post;
        this.Sujet_Post = Sujet_Post;
        this.Description_Post = Description_Post;
        this.Review_Post = Review_Post;
        this.Date_Post = Date_Post;
    }

    public Blog(int Id_Post, String Sujet_Post, String Description_Post, String Review_Post, int User_Id_Post) {
        this.Id_Post = Id_Post;
        this.Sujet_Post = Sujet_Post;
        this.Description_Post = Description_Post;
        this.Review_Post = Review_Post;
        this.User_Id_Post = User_Id_Post;
    }

    public int getId_Post() {
        return Id_Post;
    }

    public void setId_Post(int Id_Post) {
        this.Id_Post = Id_Post;
    }

    public int getUser_Id_Post() {
        return User_Id_Post;
    }

    public void setUser_Id_Post(int User_Id_Post) {
        this.User_Id_Post = User_Id_Post;
    }

    public String getSujet_Post() {
        return Sujet_Post;
    }

    public void setSujet_Post(String Sujet_Post) {
        this.Sujet_Post = Sujet_Post;
    }

    public String getDescription_Post() {
        return Description_Post;
    }

    public void setDescription_Post(String Description_Post) {
        this.Description_Post = Description_Post;
    }

    public String getReview_Post() {
        return Review_Post;
    }

    public void setReview_Post(String Review_Post) {
        this.Review_Post = Review_Post;
    }

    public String getDate_Post() {
        return Date_Post;
    }

    public void setDate_Post(String Date_Post) {
        this.Date_Post = Date_Post;
    }
    
     

    public Blog(int Id_Post) {
        this.Id_Post = Id_Post;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.Id_Post;
        hash = 97 * hash + this.User_Id_Post;
        hash = 97 * hash + Objects.hashCode(this.Sujet_Post);
        hash = 97 * hash + Objects.hashCode(this.Description_Post);
        hash = 97 * hash + Objects.hashCode(this.Review_Post);
        hash = 97 * hash + Objects.hashCode(this.Date_Post);
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
        final Blog other = (Blog) obj;
        if (this.Id_Post != other.Id_Post) {
            return false;
        }
        if (this.User_Id_Post != other.User_Id_Post) {
            return false;
        }
        if (!Objects.equals(this.Sujet_Post, other.Sujet_Post)) {
            return false;
        }
        if (!Objects.equals(this.Description_Post, other.Description_Post)) {
            return false;
        }
        if (!Objects.equals(this.Review_Post, other.Review_Post)) {
            return false;
        }
        return Objects.equals(this.Date_Post, other.Date_Post);
    }

    

  
    
     
}
   