/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import com.twilio.Twilio;
import java.util.stream.Collectors;
import java.sql.Connection;
import outils.MyDb;
import  entites.commande;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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

import com.aspose.cells.*;
import java.io.*;


import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import java.time.LocalDate;
;
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
       public void Ajoutercommande2(commande c){
        try {
                String req = "INSERT INTO commande(QteC,date_ajout) VALUES ('"+c.getQteC()+"','"+c.getDate_ajout()+"')";
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
            String req="update commande SET  status=?,date_ajout=?,date_cloture=?,motif_cloture=? where id_commande=?" ;
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
       
     public void validecoamande(commande c ) {
        try {
            String req="update commande SET  status=?,date_cloture=?,motif_cloture=? where id_commande=?" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1,("sucess"));

            st.setString(2,LocalDate.now().toString());
            st.setString(3, c.getMotif_cloture());
            st.setInt(4, c.getId_commande());
            st.executeUpdate();
            System.out.println("commande valide succés");
          
        } catch (SQLException ex) {
            Logger.getLogger(commande_services .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
       public void refusercommande(commande c ) {
        try {
            String req="update commande SET  status=?,date_cloture=?,motif_cloture=? where id_commande=?" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1,("echec"));

            st.setString(2,LocalDate.now().toString());
            st.setString(3, c.getMotif_cloture());
            st.setInt(4, c.getId_commande());
            st.executeUpdate();
            System.out.println("commande refuse");
          
        } catch (SQLException ex) {
            Logger.getLogger(commande_services .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
     
     
     
     
 
       public ObservableList<commande> getallcommandes(){
       ObservableList<commande> commandelist =FXCollections.observableArrayList(); ;

           try {
             
             String  req = "SELECT * FROM commande ";
             PreparedStatement st = cnx.prepareStatement(req);
             ResultSet  rs =st.executeQuery();
             while(rs.next()){
             int id_commande=rs.getInt("id_commande");
             String status=rs.getString("status");
             String date_ajout=rs.getString("date_ajout");
               int QteC =rs.getInt("QteC");

             String date_cloture =rs.getString("date_cloture");
             String motif_cloture=rs.getString("motif_cloture");
             commandelist.add(new commande(id_commande,QteC,status, date_ajout, date_cloture, motif_cloture));
                        

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

     //type de chaine de caratc 
     //
     //field  asami les cloone lfou9 fel excel
    public  void toexcel() throws SQLException, IOException{
     /*List<commande> c= new ArrayList();
          List<commande> c2= new ArrayList();

            //3abbi el list article
            
             String  req = "SELECT * FROM commande";
             PreparedStatement st = cnx.prepareStatement(req);
             ResultSet  rs =st.executeQuery();
             while(rs.next()){
             int id_commande=rs.getInt("id_commande");
             String status=rs.getString("status");
             String date_ajout=rs.getString("date_ajout");
             int QteC =rs.getInt("QteC");
             String date_cloture =rs.getString("date_cloture");
             String motif_cloture=rs.getString("motif_cloture");
             c.add(new commande(id_commande,QteC,status, date_ajout, date_cloture, motif_cloture));
             }*/
                   //  c2=c.stream().filter(c1->( c1.getStatus().equals("a_traite"))).collect(Collectors.toList());
        
         
    
          
     
     

    }
/*
 public static final String ACCOUNT_SID = "AC2420083fb29a62edd5f592cfa12ac98f";
    public static final String AUTH_TOKEN = "c2daf4ab58d08620521e2471488640f5";

    public void sendSms() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message msg = Message.creator(new PhoneNumber("+21650700441"),new PhoneNumber("+12284600693"),("votre commande est validé")).create();
    
    }
    */
    
         
     public commande_services() {
        cnx=MyDb.getInstance().getCnx();
    }
  
}

















