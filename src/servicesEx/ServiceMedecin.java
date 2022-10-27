/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesEx;

import entitiesEx.Medecin;
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
public class ServiceMedecin implements IServiceEx<Medecin> {
    Connection cnx;
    public ServiceMedecin() {
        MaBD bd =MaBD.getInstance();
        cnx=(Connection) bd.getCnx();}
    
    

    @Override
    public void ajouter(Medecin m) {
        try {
            String req = "INSERT INTO medecin (idMedecinm,nomprenomm,adrm) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,m.getIdMedecinm());
            ps.setString(2,m.getNomprenomm());
            ps.setString(3,m.getAdrm());
            ps.executeUpdate();
            System.out.println("Medecin ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Medecin m) {
        try {
            String req = "DELETE FROM medecin WHERE idMedecinm=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, m.getIdMedecinm());
            ps.executeUpdate();
            System.out.println("medecin supprimé !");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //idMedecinm=? ,
    @Override
    public void modifier(Medecin m) {
        try {
             String requete = "UPDATE medecin SET nomprenomm=?,adrm=? WHERE idMedecinm=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, m.getNomprenomm());
            
            pst.setString(2,m.getAdrm());
            
            pst.setInt(3,m.getIdMedecinm());
      
            pst.executeUpdate();
            System.out.println("Medecin modifié !");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Medecin> afficher() {
        List<Medecin> Medecins = new ArrayList<>();
        try {
            
            String requete = "SELECT * FROM medecin";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idMedecinm=rs.getInt("idMedecinm");
                String nomprenomm=rs.getString("nomprenomm");
                String adrm=rs.getString("adrm");
                Medecins.add(new Medecin(idMedecinm,nomprenomm));
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Medecins;
    
}

    public ObservableList<Medecin> getAll() {
        
        ObservableList<Medecin> Medecins = FXCollections.observableArrayList();try {
             String  req = "SELECT * FROM medecin";
            PreparedStatement st = cnx.prepareStatement(req);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                int idPatientp =rs.getInt("idMedecinm");
                String nomprenomp=rs.getString("nomprenomm");
                String dnp=rs.getString("adrm");
                Medecins.add(new Medecin(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Medecins;
        
}}