/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Interfaces.IService;
import entites.Categorie;
import outils.MyDB;
import entites.Sponsor;

import java.sql.Connection;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author mahdi
 */
public class SponsorService implements IService<Sponsor> {
    Connection cnx ;
    public SponsorService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    public void add(Sponsor s){
        try {
            String req = "INSERT INTO sponsor(nom_societe,email_societe,Phone_societe,montant_donnee,type_sponsoring) VALUES ('"+s.getNom_societe()+"','"+s.getEmail_societe()+"','"+s.getPhone_societe()+"','"+s.getMontant_donnee()+"','"+s.getTs()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("sponsor ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void update(Sponsor s) {
        try {
            String req="update sponsor SET nom_societe='"+s.getNom_societe()+"',email_societe='"+s.getEmail_societe()+"',Phone_societe='"+s.getPhone_societe()+"',montant_donnee='"+s.getMontant_donnee()+"',type_sponsoring='"+s.getTs()+"' where id_sponsor='"+s.getId_sponsor()+"'" ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("sponsor Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
    } 
    
    public void delete(Sponsor s){
        try {
            String req = "DELETE FROM sponsor WHERE id_sponsor="+s.getId_sponsor()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("sponsor supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public ObservableList<Sponsor> getAll() {
        ObservableList<Sponsor> listSponsor = FXCollections.observableArrayList();
        try {
            String req="select * from sponsor" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                int id=rs.getInt("id_sponsor");
                String nom=rs.getString("nom_societe");
                String mail=rs.getString("email_societe");
                int numero=rs.getInt("Phone_societe");
                int montant=rs.getInt("montant_donnee");
                String type=rs.getString("type_sponsoring"); 
                listSponsor.add(new Sponsor(id,numero,montant,nom,mail,type.toString()));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listSponsor ;  
        }
}
