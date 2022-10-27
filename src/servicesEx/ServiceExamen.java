/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesEx;

import entitiesEx.Examen;
import outilsEx.MaBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author acila
 */
public class ServiceExamen implements IServiceEx<Examen>{
    Connection cnx;
    public ServiceExamen(){
    MaBD bd =MaBD.getInstance();
    cnx=(Connection) bd.getCnx();}
    
    public void ajouter(Examen e)
    {
        java.util.Date date = new java.util.Date();
        String dateEx = new SimpleDateFormat("yyyy-MM-dd").format(date);
        e.setDateEx(dateEx);
        String req = "INSERT INTO examen (idEx,idSalle,idMedecin,idPatient,typeEx,dateEx, resEx ) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,e.getIdEx());
            ps.setString(2,e.getIdMedecin());
            ps.setString(3,e.getIdSalle());
            ps.setString(4, e.getIdPatient());
            ps.setString(6, e.getDateEx());
            ps.setString(5, e.getTypeEx());
            ps.setString(7, e.getResEx());

            ps.executeUpdate();
            System.out.println("Examen ajoutée !");
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
            System.out.println("Examen supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }
     

    /**
     *
     * @param e
     */
    public void modifier(Examen e) {
        try {
            String requete = "UPDATE examen SET  idMedecin=? ,idSalle=?, idPatient=?,typeEx=? , dateEx=? ,resEx=? WHERE idEx=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(2, e.getIdSalle());
            pst.setString(1, e.getIdMedecin());
            pst.setString(3, e.getIdPatient());
            pst.setString(5,e.getDateEx());
            pst.setString(4,e.getTypeEx());
            pst.setInt(7, e.getIdEx());
            pst.setString(6, e.getResEx());
            pst.executeUpdate();
            System.out.println("Examen modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public List<Examen> afficher() {
        List<Examen> examens = new ArrayList<>();

        try {
            String requete = "SELECT * FROM examen";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idEx=rs.getInt("idEx");
                String idMedecin=rs.getString("idMedecin");
                String idSalle=rs.getString("idSalle");
                String idPatient=rs.getString("idPatient");
                String typeEx=rs.getString("typeEx");
                String dateEx=rs.getString("dateEx");
                String resEx=rs.getString("resEx");
                examens.add(new Examen(idEx,idMedecin,idSalle,idPatient,typeEx,dateEx,resEx));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return examens;
    }

  

    public ObservableList<Examen> getAll() throws SQLException {
        ObservableList<Examen> examens = FXCollections.observableArrayList();
    
         String  req = "SELECT * FROM examen";
             PreparedStatement st = cnx.prepareStatement(req);
             ResultSet rs =st.executeQuery();
             while(rs.next()){
             int idEx=rs.getInt("idEx");
             String idMedecin=rs.getString("idMedecin");
             String idSalle=rs.getString("idSalle");
             String idPatient=rs.getString("idPatient");
             String typeEx=rs.getString("typeEx");
             String dateEx=rs.getString("dateEx");
             String resEx=rs.getString("resEx");
             
             
             examens.add(new Examen(idEx,idMedecin,idSalle,idPatient,typeEx,dateEx,resEx));
    }
               return examens ;

    }
   
}
     
