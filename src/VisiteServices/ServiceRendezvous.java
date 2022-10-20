/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisiteServices;

import VisiteEntities.DossierPatient;
import VisiteEntities.RendezVous;
import VisiteInterfaces. IService;
import VisiteUtils.DBconnexion;
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
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 *
 * @author USER
 */
public class ServiceRendezvous implements  IService<RendezVous>{
Connection cnx;

    public ServiceRendezvous() {
        DBconnexion c = DBconnexion.getInstance();
        cnx = c.getCnx();
    }
    @Override
    public void ajouter(RendezVous r) {
 try {
            String requete = "INSERT INTO rendez_vous (nomPatient,heure_rdv,nom_medecin,cause_rdv,date_rdv) VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, r.getNomPatient());
            pst.setString(2, r.getHeure());
             pst.setString(3, r.getNomMedecinRv());
              pst.setString(4, r.getCause());
               pst.setString(5, r.getDateRendezVous());
               
            pst.executeUpdate();
            System.out.println("Rendez_vous  ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public void supprimer(RendezVous r) {
try {
            String requete = "DELETE FROM rendez_vous WHERE id_rdv="+r.getIdRv()+"";
            Statement pst = cnx.createStatement();
            pst.executeUpdate(requete);
            System.out.println("RendezVous supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}

    @Override
    public void modifier(RendezVous r) {
        
         try {
            String req="update rendez_vous SET nomPatient='"+r.getNomPatient()+"',heure_rdv='"+r.getHeure()+"',nom_medecin='"+r.getNomMedecinRv()+"',cause_rdv='"+r.getCause()+"',date_rdv='"+r.getDateRendezVous()+"'" ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rendez_vous Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  
    }

  
   
    
    
    
    
    
    
    
    
    
    
    @Override
     public ObservableList<RendezVous> afficher() {
        ObservableList<RendezVous> listRDV = FXCollections.observableArrayList();
        try {
            String req="select * from rendez_vous" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                int idRv=rs.getInt("id_rdv");
                String nomPatient=rs.getString("nomPatient");
                String dateRendezVous=rs.getString("date_rdv");
                String heure=rs.getString("heure_rdv");
                String nomMedecinRv=rs.getString("nom_medecin");
                String cause=rs.getString("cause_rdv"); 
                
                listRDV.add(new RendezVous(idRv,nomPatient,dateRendezVous,heure,nomMedecinRv,cause));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listRDV ;  
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    }

   
    

