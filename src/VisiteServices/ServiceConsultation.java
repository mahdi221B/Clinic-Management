/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisiteServices;

import VisiteEntities.Consultation;
import VisiteEntities.DossierPatient;
import VisiteUtils.DBconnexion;
import static java.awt.Event.INSERT;
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
import javax.activation.DataSource;
import VisiteInterfaces.IService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author USER
 */
public class ServiceConsultation implements IService<Consultation> {
  Connection cnx;

    public ServiceConsultation() {
        DBconnexion c = DBconnexion.getInstance();
        cnx = c.getCnx();
    }
    @Override
    public void ajouter(Consultation t) {
         try {
            String requete = "INSERT INTO consultation_visite (nom_patient,nom_medecin,list_exam,list_medic,traitement,date_cons) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getNomPatient());
            pst.setString(2, t.getNomMedecin());
             pst.setString(3, t.getListExamens());
              pst.setString(4, t.getListMedicament());
               pst.setString(5, t.getTraitement());
               pst.setString(6, t.getDateConsultation());
            pst.executeUpdate();
            System.out.println("Consultation ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Consultation t) {
 try {
            String requete = "DELETE FROM consultation_visite WHERE id_cons="+t.getIdCon()+"";
            Statement pst = cnx.createStatement();
            pst.executeUpdate(requete);
            System.out.println("Consultation supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}
    
    @Override
    public void modifier(Consultation t) {
 try {
  String req="update consultation_visite SET nom_patient='"+t.getNomPatient()+"',nom_medecin='"+t.getNomMedecin()+"',list_exam='"+t.getListExamens()+"',list_medic='"+t.getListMedicament()+"',traitement='"+t.getTraitement()+"',date_cons='"+t.getDateConsultation()+"'" ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Consultation Modifiee avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }  }

    
  @Override
      public ObservableList<Consultation> afficher() {
        ObservableList<Consultation> listco = FXCollections.observableArrayList();
        try {
            String req="select * from consultation_visite" ;
            Statement st = cnx.createStatement(); 
            ResultSet rst = st.executeQuery(req) ;
            
            while(rst.next()) {
                 int idCon=rst.getInt("id_cons");
                 String dateConsultation=rst.getString("date_cons");
                 String listExamens=rst.getString("list_exam");
                String listMedicament=rst.getString("list_medic");
                String nomMedecin=rst.getString("nom_medecin");
                String nomPatient=rst.getString("nom_patient"); 
                String traitement=rst.getString("traitement");
                listco.add(new Consultation(idCon,dateConsultation,listExamens,listMedicament,nomMedecin,nomPatient,traitement));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listco ;  
    }
    
    
    
 
}