/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesEx;

import entitiesEx.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outilsEx.MaBD;

/**
 *
 * @author acila
 */
public class ServicePatient {
    Connection cnx;

    public ServicePatient() {
         MaBD bd =MaBD.getInstance();
         cnx=(Connection) bd.getCnx();
    }
     public void ajouter(Patient p)
    {
        
        String req = "INSERT INTO patient (idPatientp,nomprenomp,dnp,sexep,adrp) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,p.getIdPatientp());
            ps.setString(2,p.getNomprenomp());
            ps.setString(3,p.getDnp());
            ps.setString(4,p.getSexep());
            ps.setString(5,p.getAdrp());
            
            ps.executeUpdate();
            System.out.println("Patient ajouté !");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
     public void supprimer(Patient p) {
        try {
            String req = "DELETE FROM patient WHERE idPatientp=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p.getIdPatientp());
            ps.executeUpdate();
            System.out.println("patient supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }

    /**,sexep=?
     *
     * @param e
     */
    public void modifier(Patient p) {
        try {
            String requete = "UPDATE patient SET  nomprenomp=? , dnp=? , sexep=? ,adrp=? WHERE idPatientp=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(5, p.getIdPatientp());
            pst.setString(2,p.getDnp());
            pst.setString(1, p.getNomprenomp());
            pst.setString(3,p.getSexep());
            pst.setString(4,p.getAdrp());
            
      
            pst.executeUpdate();
            System.out.println("patient modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public List<Patient> afficher() {
        List<Patient> Patients = new ArrayList<>();

        try {
            String requete = "SELECT * FROM patient";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idPatientp=rs.getInt("idPatientp");
                String nomprenomp=rs.getString("nomprenomp");
                String dnp=rs.getString("dnp");
                String sexep=rs.getString("sexep");
                String adrp=rs.getString("adrp");
                
                Patients.add(new Patient (idPatientp,nomprenomp,dnp,sexep,adrp));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return Patients;
    }   

    public ObservableList<Patient> getAll() {
          ObservableList<Patient> Patients = FXCollections.observableArrayList();
         

         try {
             String  req = "SELECT * FROM patient";
             PreparedStatement st = cnx.prepareStatement(req);
             ResultSet rs =st.executeQuery();
             while(rs.next()){
                int idPatientp =rs.getInt("idPatientp");

                String nomprenomp=rs.getString("nomprenomp");
                String dnp=rs.getString("dnp");
                String sexep=rs.getString("sexep");
                String adrp=rs.getString("adrp");
                Patients.add(new Patient(idPatientp,nomprenomp,dnp,sexep,adrp));
             
                      }
             
         } catch (SQLException ex) {
             Logger.getLogger(ServiceSalle.class.getName()).log(Level.SEVERE, null, ex);
         }
           
           return Patients ;
    }
}
