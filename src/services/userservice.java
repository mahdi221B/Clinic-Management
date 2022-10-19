/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;




/**
 *
 * @author ce pc
 */
public class userservice  {
    
    private final Connection cnx;

    public userservice() {
        cnx=MyDB.getInstance().getConnection();
    }
    
    
  /*public void ajouteruser(user u){
  
        try {
            String req = "INSERT INTO user (nom,prenom,age) VALUES('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getAge()+"'  )";
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("user ajoute ");
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
  } */
  
 /* public void modifier (user u){
        try {
            String req = "UPDATE user (nom,prenom,age) VALUES('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getAge()+"'  )where id=5";
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
  }*/
  //PreparedStatement pst = null;

    /**
     *
     * @param
     */
    public void ajouter(user t) {
        
        PreparedStatement pst = null;
          try {
            String requete = "INSERT INTO user (nom,prenom,sexe,num_tel,CIN,mot_passe,role,adresse) VALUES (?,?,?,?,?,?,?,?)";
            pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getSexe());
            pst.setInt(4, t.getNum_tel());
            pst.setInt(5, t.getCIN());
            pst.setString(6, t.getMot_passe());
            pst.setString(7, t.getRole());
            pst.setString(8, t.getAdresse());
            
            
           
           
           
            
            pst.executeUpdate();
            System.out.println("Personne ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
        
    
    }
        
        public void Supprimeruser(user u){
        try {
            String req = "DELETE FROM User WHERE id_user="+u.getId_user()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modifier(user t) {
       try {
            String req="update user SET nom=?,prenom=?,sexe=?,num_tel=?,CIN=?,mot_passe=?,role=?,adresse=? where id_user=?" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, t.getNom());
            st.setString(2, t.getPrenom());
            st.setString(3, t.getSexe());
            st.setInt(4, t.getNum_tel());
            st.setInt(5, t.getCIN());  
            st.setString(6, t.getMot_passe());
            st.setString(7, t.getRole());
            st.setString(8, t.getAdresse());
            st.setInt(9, t.getId_user());
          
            st.executeUpdate();
            System.out.println("User Modifié avec succés");
          
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    public ObservableList<user> getAll() {
         ObservableList<user> users = FXCollections.observableArrayList();
    
   /* public List<user> afficher() {
         List<user> users ;
        users = new ArrayList<>();*/

         try {
             String  req = "SELECT * FROM user";
             PreparedStatement st = cnx.prepareStatement(req);
             ResultSet rs =st.executeQuery();
             while(rs.next()){
             int id_user=rs.getInt("id_user");
             String nom=rs.getString("nom");
             String prenom=rs.getString("prenom");
             String sexe=rs.getString("sexe");
             int num_tel=rs.getInt("num_tel");
             int CIN=rs.getInt("CIN");
             String mot_passe=rs.getString("mot_passe");
             String role =rs.getString("role");
             String adresse =rs.getString("adresse");
             users.add(new user(id_user,nom,prenom,sexe,num_tel,CIN,mot_passe,role,adresse));
             
                      }
             
         } catch (SQLException ex) {
             Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
         }
           
           return users;
            
    }

   
} 
 
   

