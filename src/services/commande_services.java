/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import outils.MyDb;
import  entites.commande;

//import entites.statut_commande;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author miled
 */


public class commande_services  
{
    Connection cnx;

    
    
      public void Ajoutercommande(commande c){
        try {
                String req = "INSERT INTO commande(status,date_ajout,date_cloture,motif_cloture) VALUES ('"+c.getStatus() +"','"+c.getDate_ajout()+"','"+c.getDate_cloture()+"','"+c.getMotif_cloture()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("commande ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
     /*
      public void Ajoutercommande(commande c)
    {    //date date = new Date();

        String req = "INSERT INTO commande  (status,date_ajout,date_cloture,motif_cloture) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,c.getStatus().toString());
            ps.setDate(2,java.sql.Date.valueOf(("1998-1-17")));
            ps.setDate(3,java.sql.Date.valueOf(("2022-1-17")));
            ps.setString(4,c.getMotif_cloture());
            ps.executeUpdate();
            System.out.println("commande ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
      */
       public void updatecoamande(commande c ) {
        try {
            String req="update commande SET status=?,date_ajout=?,date_cloture=?,motif_cloture=? where id_commande=?" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1,(c.getStatus()));

            st.setString(2,c.getDate_ajout());
            st.setString(3,c.getDate_cloture());
            st.setString(4, c.getMotif_cloture());
            st.setInt(5, c.getId_commande());
            st.executeUpdate();
            System.out.println("commande Modifié avec succés");
          
        } catch (SQLException ex) {
            Logger.getLogger(commande_services .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
    
     
 
       public ObservableList<commande> getallcommandes(){
       ObservableList<commande> commandelist =FXCollections.observableArrayList(); ;

           try {
             
             String  req = "SELECT * FROM commande";
             PreparedStatement st = cnx.prepareStatement(req);
             ResultSet  rs =st.executeQuery();
             while(rs.next()){
             int id_commande=rs.getInt("id_commande");
             String status=rs.getString("status");
             String date_ajout=rs.getString("date_ajout");
             String date_cloture =rs.getString("date_cloture");
             String motif_cloture=rs.getString("motif_cloture");
             commandelist.add(new commande(id_commande,status, date_ajout, date_cloture, motif_cloture));
                        

             }  
           } catch (SQLException ex) {
             Logger.getLogger(commande_services.class.getName()).log(Level.SEVERE, null, ex);
         }
           
           return commandelist;
            
       }
        public void Supprimercommande(commande c){
        try {
            String req = "DELETE FROM commande WHERE Id_commande="+c.getId_commande()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("commande  supprimeé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }   

     public commande_services() {
        cnx=MyDb.getInstance().getCnx();
    }
     
     
     
     
     
     
}
