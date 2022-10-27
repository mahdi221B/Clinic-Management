/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import entities.Categorie;
import interfaces.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;


/**
 *
 * @author ThinkPad
 */
public class CategorieService implements IService<Categorie> {
     Connection cnx ; 

    public CategorieService() {
    cnx = MyDB.getInstance().getCnx();
    }
    
    public void add(Categorie s){
        try {
            String req = "INSERT INTO Categorie (Text_Categorie,Date_Creation_Categorie,Id_Createur_Categorie) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,s.getText_Categorie());
            ps.setString(2,s.getDate_Creation_Categorie());
            ps.setInt(3,s.getId_Createur_Categorie());
            ps.executeUpdate();
            System.out.println("Categorie ajouté avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


public void update(Categorie s) {
        try {
            String req="update Categorie SET Text_Categorie='"+s.getText_Categorie()+"',Date_Creation_Categorie='"+s.getDate_Creation_Categorie()+"',Id_Createur_Categorie='"+s.getId_Createur_Categorie()+"' where Id_Categorie='"+s.getId_Categorie()+"'" ;                                                                                                               
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        
       
        }
}
public void delete(Categorie u){
        try {
            String req = "DELETE FROM categorie WHERE Id_Categorie="+u.getId_Categorie()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }


        }
     @Override
     public ObservableList<Categorie> getAll() {
        ObservableList<Categorie> listCategories =  FXCollections.observableArrayList();
        try {
            String req="select * from categorie" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
               
                int Id_Categorie=rs.getInt("Id_Categorie");
                String Text_Categorie=rs.getString("Text_Categorie");
                String Date_Creation_Categorie =rs.getString("Date_Creation_Categorie");
                int Id_Createur_Categorie=rs.getInt("Id_Createur_Categorie"); 
               
                listCategories.add(new Categorie(Id_Categorie, Text_Categorie, Date_Creation_Categorie, Id_Createur_Categorie)) ;
            
            
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listCategories ;  
        }

     public List<Categorie> TrierParCategorie() throws SQLException {
        List<Categorie> retour = new ArrayList<>();
        Statement st = cnx.createStatement();
        String req = "SELECT * from categorie order by Date_Creation_Categorie";
       ResultSet rs = st.executeQuery(req) ;
        while (rs.next()) {
           int Id_Categorie=rs.getInt("Id_Categorie");
                String Text_Categorie=rs.getString("Text_Categorie");
                String Date_Creation_Categorie =rs.getString("Date_Creation_Categorie");
                int Id_Createur_Categorie=rs.getInt("Id_Createur_Categorie"); 

            Categorie p = new Categorie(Id_Categorie, Text_Categorie, Date_Creation_Categorie, Id_Createur_Categorie);

            retour.add(p);

        }

        return retour;
    }
}
