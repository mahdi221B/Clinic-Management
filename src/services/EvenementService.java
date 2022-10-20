/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import Interfaces.IService;
import outils.MyDB;
import entites.Evenement;

import java.sql.Connection;

import java.sql.SQLException;

import java.sql.Statement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author mahdi
 */
public class EvenementService implements IService<Evenement> {
    Connection cnx ;
    public EvenementService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    public void add (Evenement s){
        try {
            String req = "INSERT INTO evenement(titre,description,lieu,nom_organisateur,email_organisateur,phone_organisateur,date_debut,date_fin,montant_recole) VALUES ('"+s.getTitre()+"','"+s.getDescription()+"','"+s.getLieu()+"','"+s.getNom_organisateur()+"','"+s.getEmail_organisateu()+"','"+s.getPhone_organisateur()+"','"+s.getDate_debut()+"','"+s.getDate_fin()+"','"+s.getMontant_recolte()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("evenement ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void update(Evenement s) {
        try {
            String req="update evenement SET titre='"+s.getTitre()+"',description='"+s.getDescription()+"',lieu='"+s.getLieu()+"',nom_organisateur='"+s.getNom_organisateur()+"',email_organisateur='"+s.getEmail_organisateu()+"',phone_organisateur='"+s.getPhone_organisateur()+"',date_debut='"+s.getDate_debut()+"',date_fin='"+s.getDate_fin()+"',montant_recole='"+s.getMontant_recolte()+"' where id_evenement='"+s.getId_evenement()+"'" ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("evenement Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
    } 
    
    public void delete (Evenement s){
        try {
            String req = "DELETE FROM evenement WHERE id_evenement="+s.getId_evenement()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("evenement supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public ObservableList<Evenement> getAll() {
        ObservableList<Evenement> listEvenement = FXCollections.observableArrayList();
        try {
            String req="select * from evenement" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                int id=rs.getInt("id_evenement");
                int Numero=rs.getInt("Phone_organisateur");
                int Montant=rs.getInt("Montant_recole");
                String Titre=rs.getString("Titre");
                String Description=rs.getString("Description");
                String Lieu=rs.getString("Lieu"); 
                String Nom=rs.getString("Nom_organisateur"); 
                String Email=rs.getString("email_organisateur"); 
                String Ddebut=rs.getString("Date_debut"); 
                String Dfin=rs.getString("Date_fin"); 
                
                CategorieService cs =new CategorieService();
               // Categorie c = cs.get
                
                listEvenement.add(new Evenement(id,Numero,Montant,Titre,Description,Lieu,Nom,Email,Ddebut,Dfin));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listEvenement ;  
    }
}
