/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Interfaces.IService;
import entites.Categorie;
import entites.Sponsor;
import java.sql.Connection;
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
 * @author mahdi
 */
public class CategorieService implements IService<Categorie>  {
    Connection cnx ;
    public CategorieService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    /**
     *
     * @param s
     */
    @Override
    public void add (Categorie s){
        try {
            String req = "INSERT INTO categorie(nom_categorie) VALUES ('"+s.getNom_categorie()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("categorie ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void update(Categorie s) {
        try {
            String req="update categorie SET nom_categorie='"+s.getNom_categorie()+"' where id_categorie='"+s.getId_categorie()+"'" ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("categorie Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
    } 
    
    @Override
    public void delete (Categorie s){
        try {
            String req = "DELETE FROM categorie WHERE id_categorie="+s.getId_categorie()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("categorie supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
   /* public Categorie getOne(int id) {
        Categorie c = new Categorie();
        try {
            String req="select * from categorie WHERE id_categorie="+id+"" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                int ID=rs.getInt("id_categorie");
                String NOM=rs.getString("nom_categorie");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c ;  
    }
    */
    @Override
    public ObservableList<Categorie> getAll() {
        ObservableList<Categorie> listCategorie = FXCollections.observableArrayList();
        try {
            String req="select * from categorie" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                int ID=rs.getInt("id_categorie");
                String NOM=rs.getString("nom_categorie");
                listCategorie.add(new Categorie(ID,NOM));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listCategorie ;  
    }
    
 /*   public List<String> getList() {
        List<String> listCategorie = new ArrayList<>();
        try {
            String req="select * from categorie" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                //int ID=rs.getInt("id_categorie");
                String NOM=rs.getString("nom_categorie");
                Categorie e = new Categorie(NOM);
                listCategorie.add(e.getNom_categorie());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listCategorie ;  
    }
    */
    
}
