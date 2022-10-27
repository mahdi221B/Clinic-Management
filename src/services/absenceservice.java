 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author ce pc
 */

import entities.absence;
import entities.user;


import java.sql.Connection;
import java.sql.Date;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ce pc
 */
public class absenceservice {
    
     private final Connection cnx;

    public absenceservice() {
        cnx=MyDB.getInstance().getConnection();
    }
    
      public void ajouter(absence t) {
        PreparedStatement pst = null;
          try {
            String requete = "INSERT INTO absence (id_user,nom,prenom,date_absence,duré_absence,justification) VALUES (?,?,?,?,?,?)";
            pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getId_user());
            pst.setString(2, t.getNom());
            pst.setString(3, t.getPrenom());
            pst.setString(4, t.getDate_absence());
            pst.setString(5, t.getDuré_absence());
            pst.setString(6, t.getJustification());
            
            
            pst.executeUpdate();
            System.out.println("Personne ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
        
    
    }
    
      
       public void Supprimerabsence(absence a){
        try {
            String req = "DELETE FROM absence WHERE id_absence="+a.getId_absence()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
      
      
      public void modifier(absence t) {
       try {
            String req="update absence SET id_user=?,nom=?,prenom=?,date_absence=?,duré_absence=?,justification=? where id_absence=?" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, t.getId_user());
            st.setString(2, t.getNom());
            st.setString(3, t.getPrenom());
            st.setString(4, t.getDate_absence());                         
            st.setString(5, t.getDuré_absence());
            st.setString(6, t.getJustification());
            st.setInt(7, t.getId_absence());
          
            st.executeUpdate();
            System.out.println("absence Modifié avec succés");
          
        } catch (SQLException ex) {
            Logger.getLogger(absenceservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      
      
      
      
      
      public ObservableList<absence> getAll() {
         ObservableList<absence> absences = FXCollections.observableArrayList();
         

         try {
             String  req = "SELECT * FROM absence";
             PreparedStatement st = cnx.prepareStatement(req);
             ResultSet rs =st.executeQuery();
             while(rs.next()){
             int id_absence=rs.getInt("id_absence");
             String id_user=rs.getString("id_user");
             String nom=rs.getString("nom");
             String prenom=rs.getString("prenom");
             String date_absence=rs.getString("date_absence");
             
             
             String duré_absence=rs.getString("duré_absence");
             String justification =rs.getString("justification");
             
             absences.add(new absence(id_absence,id_user,nom,prenom,date_absence,duré_absence,justification));
             
                      }
             
         } catch (SQLException ex) {
             Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
         }
           
           return absences ;
            
    }
      
      
}
