/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisiteServices;

import VisiteEntities.Consultation;
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

/**
 *
 * @author USER
 */
public class ServiceDossierpatient implements  IService<DossierPatient> {
Connection cnx;

    public ServiceDossierpatient() {
        DBconnexion c = DBconnexion.getInstance();
        cnx = c.getCnx();
    }
    @Override
    public void ajouter(DossierPatient d) {
        try {
            String requete = "INSERT INTO dossierpatient (nom,Allergie_medic,medicaments,consultations,details_op,maladies) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, d.getNomP());
            pst.setString(2, d.getMaladies());
             pst.setString(3, d.getMedicaments());
              pst.setString(4, d.getAllergieMedicaments());
               pst.setString(5, d.getDetailsOperation());
               pst.setString(6, d.getConsultations());
            pst.executeUpdate();
            System.out.println("Dossier patient  ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(DossierPatient d) {
try {
            String requete = "DELETE FROM dossierpatient WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,d.getIdP());
            pst.executeUpdate();
            System.out.println("Dossier patient supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }      }

    @Override
    public void modifier(DossierPatient d) {
 try {
            String requete = "update DossierPatient SET nom='"+d.getNomP()+"',maladies='"+d.getMaladies()+"',medicaments='"+d.getMedicaments()+"',allergie_medic='"+d.getAllergieMedicaments()+"',details_op='"+d.getDetailsOperation()+"'";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Dossier Modifiee avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }     }

  
    
    
    
@Override
     public ObservableList<DossierPatient> afficher() {
        ObservableList<DossierPatient> listdoc = FXCollections.observableArrayList();
        try {
            String req="select * from dossierpatient" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                int idP=rs.getInt("id");
                 String nomP=rs.getString("nom");
                String AllergieMedicaments=rs.getString("Allergie_medic");
                String Medicaments=rs.getString("medicaments");
                String Consultations=rs.getString("consultations");
                String detailsOperation=rs.getString("details_op"); 
                String maladies=rs.getString("maladies");
                listdoc.add(new DossierPatient(idP,nomP,AllergieMedicaments,Medicaments,Consultations,detailsOperation,maladies));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listdoc ;  
    }
    
    
    
    
    
    
    
    
    
    
    
    }

   
    

