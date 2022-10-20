/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entites.commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import outils.MyDb;
import entites.ligne_de_commande;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miled
 */
public class lignedecommande_services {
       Connection cnx;

    public lignedecommande_services() {
        cnx=MyDb.getInstance().getCnx();
    }
    
    
    
  public void Ajouterlignecommande(ligne_de_commande lc){
        try {
             String req = "INSERT INTO ligne_de_commande (Qte,id_article,id_commande,id_infermier) VALUES (?,?,?,?)";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,lc.getQte());
            ps.setInt(2,lc.getId_article());
            ps.setInt(3,lc.getId_commande());
            ps.setInt(4,lc.getId_infermier());
            ps.executeUpdate();
            System.out.println("ligne  ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
    }
    public void updateligne_coamande(ligne_de_commande lc ) {
        try {
 
            
            String req="update commande SET Qte=?,id_articel=?,id_commande=?,id_infermier=? where id_commande=?" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt (1,(lc.getQte()));

            st.setInt (2,(lc.getId_article()));
            st.setInt(3, lc.getId_commande());

            st.setInt(4, lc.getId_ligne_commande());
            st.executeUpdate();
            System.out.println("commande Modifié avec succés");
          
        } catch (SQLException ex) {
            Logger.getLogger(commande_services .class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


 public List<ligne_de_commande> getalllignecommandes(){
       List<ligne_de_commande> lignecommandes = new ArrayList<>() ;

           try {
             
             String  req = "SELECT * FROM ligne_de_commande";
             PreparedStatement st = cnx.prepareStatement(req);
             ResultSet  rs =st.executeQuery();
             while(rs.next()){
             int id_ligne_commande =rs.getInt("id_ligne_commande");
             int Qte =rs.getInt("Qte");
             int id_article =rs.getInt("id_article");


             
             lignecommandes.add(new ligne_de_commande(id_ligne_commande, Qte, id_article, id_ligne_commande, id_article));
                        
           return lignecommandes;

             }  
           } catch (SQLException ex) {
             Logger.getLogger(commande_services.class.getName()).log(Level.SEVERE, null, ex);
         }
           
           return lignecommandes;
            
       }
 
    public void Supprimerlignecommande(ligne_de_commande lc){
        try {
            String req = "DELETE FROM commande WHERE id_ligne_commande="+lc.getId_ligne_commande()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ligne commande  supprimeé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }   

 
    
}
