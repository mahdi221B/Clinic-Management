/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesEx;

import entitiesEx.Examen;
import entitiesEx.SalleExamen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import outilsEx.MaBD;

/**
 *
 * @author acila
 */
public class ServiceSalleExamen implements IServiceEx<SalleExamen>{
     Connection cnx;
    public ServiceSalleExamen(){
    MaBD bd =MaBD.getInstance();
    cnx=(Connection) bd.getCnx();}
    
    public void ajouter(SalleExamen se)
    {
      
        
        String req = "INSERT INTO salleexamen (idSalle,idEx,idSalleEx) VALUES (?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,se.getIdSalle());
            ps.setInt(2,se.getIdEx());
            ps.setInt(3,se.getIdSalleEx());
            ps.executeUpdate();
            System.out.println("Salle Examen ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
     public void supprimer(SalleExamen se) {
        try {
            String req = "DELETE FROM salleexamen WHERE idSalleEx=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, se.getIdSalleEx());
            ps.executeUpdate();
            System.out.println("Salle Examen supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }

   
    @Override
    public void modifier(SalleExamen se) {
          try {
            String requete = "UPDATE salleexamen SET idEx=? ,idSalle=? WHERE idSalleEx=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, se.getIdEx());
            pst.setInt(2, se.getIdSalle());
            pst.setInt(4, se.getIdSalleEx());
            pst.executeUpdate();
            System.out.println("Salle Examen modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<SalleExamen> afficher() {
         List<SalleExamen> Salleexamens = new ArrayList<>();

        try {
            String requete = "SELECT * FROM salleexamen";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idEx=rs.getInt("idEx");
                int idSalle=rs.getInt("idSalle");
                int idSalleExamen=rs.getInt("idSalleExamen");
                Salleexamens.add(new SalleExamen(idEx,idSalle,idSalleExamen));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return Salleexamens;
    }}
