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
import java.util.ArrayList;
import java.util.List;
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
    
    @Override
    public void add (Evenement s){
        try {
            String req = "INSERT INTO evenement2(titre,description,lieu,nom_organisateur,email_organisateur,phone_organisateur,date_debut,date_fin,montant_recole,id_categorie) VALUES ('"+s.getTitre()+"','"+s.getDescription()+"','"+s.getLieu()+"','"+s.getNom_organisateur()+"','"+s.getEmail_organisateu()+"','"+s.getPhone_organisateur()+"','"+s.getDate_debut()+"','"+s.getDate_fin()+"','"+s.getMontant_recolte()+"',"+s.getId_categorie()+")";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("evenement ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void update(Evenement s) {
        try {
            String req="update evenement2 SET titre='"+s.getTitre()+"',description='"+s.getDescription()+"',lieu='"+s.getLieu()+"',nom_organisateur='"+s.getNom_organisateur()+"',email_organisateur='"+s.getEmail_organisateu()+"',phone_organisateur='"+s.getPhone_organisateur()+"',date_debut='"+s.getDate_debut()+"',date_fin='"+s.getDate_fin()+"',montant_recole='"+s.getMontant_recolte()+"',id_categorie="+s.getId_categorie()+" where id_evenement='"+s.getId_evenement()+"'" ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Evenement Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
    } 
    
    @Override
    public void delete (Evenement s){
        try {
            String req = "DELETE FROM evenement2 WHERE id_evenement="+s.getId_evenement()+"";
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
            String req="SELECT * FROM evenement2 JOIN categorie ON evenement2.id_categorie = categorie.id_categorie";
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
                String categorie=rs.getString("nom_categorie"); 
                
                listEvenement.add(new Evenement(id,Numero,Montant,Titre,Description,Lieu,Nom,Email,Ddebut,Dfin,categorie));
                System.out.println(listEvenement);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                System.out.println(listEvenement);

        return listEvenement ;  
    }
    
     public ObservableList<String> getAllEvTitle() {
        List<Evenement> listEvenement = new ArrayList();
        ObservableList<String> listEven =  FXCollections.observableArrayList();
        try {
            String req="SELECT titre FROM `evenement2`;" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            while(rs.next()) {
                String Titre=rs.getString("titre");
                listEvenement.add(new Evenement(Titre));
                }
           // System.out.println(listEvenement);
            
            for (int i = 0; i < listEvenement.size(); i++) {
               listEven.add(listEvenement.get(i).getTitre());
            } 

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return listEven;  
    }
     
     
     public ObservableList<Integer> getAllEvMont() {
        List<Evenement> listEvenement = new ArrayList();
        ObservableList<Integer> listEven =  FXCollections.observableArrayList();
        try {
            String req="SELECT montant_recole FROM evenement2;" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            while(rs.next()) {
                Integer Montant=rs.getInt("montant_recole");
                listEvenement.add(new Evenement(Montant));
            }
          //  System.out.println(listEvenement);
            
            for (int i = 0; i < listEvenement.size(); i++) {
               listEven.add(listEvenement.get(i).getId_evenement());
            } 

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return listEven;  
    }
     
     
     
     
     /**********************************Metier******************************/
     
      public int Total() {
        int n = 0;
    try {
            String req="select * from evenement";
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                n=n+1;           
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;  
    }
    
    public int MTotal() {
        int M = 0;
        try {
            String req="select * from evenement" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                M=M+rs.getInt("Montant_recole");         
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return M ;  
    }
    
    public String HMontant() {
        String Titre = "";
        try {
            String req="SELECT MAX(montant_recole) ,titre FROM evenement2 GROUP BY titre ORDER BY MAX(montant_recole) DESC limit 1" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                 Titre=rs.getString("Titre");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return Titre;  
    }
    
    
    
     
    
    
    

}
