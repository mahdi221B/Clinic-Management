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
import java.text.SimpleDateFormat;
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
        
        java.util.Date date = new java.util.Date();
        String date_cons = new SimpleDateFormat("yyyy-MM-dd").format(date);
        t.setDateConsultation(date_cons);
        
         try {
            String requete = "INSERT INTO consultation_visite (date_cons,nom_patient,nom_medecin,list_medic,list_exam,traitement) VALUES (?,?,?,?,?,?) ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getDateConsultation());
            pst.setString(2, t.getNomPatient());
            pst.setString(3, t.getNomMedecin());
             pst.setString(4, t.getListMedicament());
             pst.setString(5, t.getListExamens());
               pst.setString(6, t.getTraitement());
              
            pst.executeUpdate();
            System.out.println("Consultation ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    
    
    public void supprimer(Consultation t) {
        try {
            String req = "DELETE FROM consultation_visite WHERE id_cons="+t.getIdCon()+"";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getIdCon());
            ps.executeUpdate();
            System.out.println("consultation  supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }


    
    @Override
  
/*public void modifier(Consultation t) {
        try {
            String requete = "update consultation_visite  set date_cons =? , nom_patient =? , nom_medecin =? , list_medic =? , list_exam =? ,traitement =? where id_cons=?  ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getDateConsultation());
            pst.setString(2, t.getNomPatient());
            pst.setString(3, t.getNomMedecin());
             pst.setString(4, t.getListMedicament());
             pst.setString(5, t.getListExamens());
             pst.setString(6, t.getTraitement());
            
      
            pst.execute();
            System.out.println("Consultation modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  */


public void modifier(Consultation t){
        String sql = "UPDATE consultation_visite SET `date_cons`=?,`nom_patient`=? ,`nom_medecin`=? ,`list_medic`=? , `list_exam`=? , `traitement`=? WHERE id_cons=" + t.getIdCon();
        PreparedStatement ste;
        try {
            ste = cnx.prepareStatement(sql);

            ste.setString(1, t.getDateConsultation());

            ste.setString(2, t.getNomPatient());
            ste.setString(3, t.getNomMedecin());
            ste.setString(4, t.getListMedicament());
            ste.setString(5, t.getListExamens());
            ste.setString(6, t.getTraitement());
            
           

            ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification est faite " );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceRendezvous.class.getName()).log(Level.SEVERE, null, ex);
        }
    }










  @Override
      public ObservableList<Consultation> afficher() {
        ObservableList<Consultation> listco = FXCollections.observableArrayList();
        try {
            String req="select * from consultation_visite" ;
            Statement st = cnx.createStatement(); 
            ResultSet rst = st.executeQuery(req) ;
            
            while(rst.next()) {
                 
                 String dateConsultation=rst.getString("date_cons");
                 String nomPatient=rst.getString("nom_patient"); 
                  String nomMedecin=rst.getString("nom_medecin");
                   String listMedicament=rst.getString("list_medic");
                 String listExamens=rst.getString("list_exam");
              
                String traitement=rst.getString("traitement");
                listco.add(new Consultation(dateConsultation,nomPatient,nomMedecin,listMedicament,listExamens,traitement));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listco ;  
    }
    
    
    
 
}