/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesEx;

import entitesEx.Examen;
import outilsEx.MaBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author acila
 */
public class ServiceExamen {
    Connection cnx;
    public ServiceExamen(){
    MaBD bd =MaBD.getInstance();
    cnx=(Connection) bd.getCnx();}
    
    public void ajouterExamen(Examen e)
    {
        String req = "INSERT INTO examen (idEx,idMedecin,idSalle,dateEx) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,e.getIdEx());
            ps.setInt(2,e.getIdMedecin());
            ps.setInt(3,e.getIdSalle());
            ps.setDate(4, (Date) e.getDateEx());
            ps.executeUpdate();
            System.out.println("Personne ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
     public void supprimer(Examen e) {
        try {
            String req = "DELETE FROM examen WHERE idEx=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, e.getIdEx());
            ps.executeUpdate();
            System.out.println("Examen supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }

    /**
     *
     * @param e
     
    public void modifier(Examen e) {
        try {
            String requete = "UPDATE examen SET idMedecin=? ,idSalle=?, dateEx=? WHERE idEx=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, e.getIdMedecin());
            pst.setInt(2, e.getIdSalle());
            pst.setDate(3, (Date) e.getDateEx());
            pst.setInt(4, e.getIdEx());
            pst.executeUpdate();
            System.out.println("Examen modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    }*/

}
