/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Interfaces.articleinterface;
import entities.articles;
import entities.commande;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import outils.MyDb;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

/**
 *
 * @author miled
 */
public class articels_services implements articleinterface {

    Connection cnx;

    public articels_services() {
        cnx = MyDb.getInstance().getCnx();
    }
    //public void verifajout(articles a)
    // select * fromartil
    //while boucli l liste
    // if artiles.name == input a.nom
    // text area(nom esisyant)
    //else 

    public void verifajout(articles ar) throws SQLException {

        String req1 = "SELECT * FROM articles";
        PreparedStatement st1 = cnx.prepareStatement(req1);
        ResultSet rs = st1.executeQuery();
        while (rs.next()) {
            int id_articles = rs.getInt("id_articles");
            String nom_articles = rs.getString("nom_articles");
            int Qte = rs.getInt("Qte");
            String description = rs.getString("description");
            String type = (rs.getString("type"));
            String a_qui_destiné = rs.getString("a_qui_destiné");
        }
        if (rs.getString("nom_articles").toUpperCase() == (ar.getNom_articles().toUpperCase())) {
            System.out.println("same name");
            //req update qte

        } else {
            Ajoutrarticle(ar);
        }
    }

    public void Ajoutrarticle(articles a) {

        try {
            String req = "INSERT INTO articles(nom_articles,Qte,description,type,a_qui_destiné) VALUES ('" + a.getNom_articles() + "','" + a.getQte() + "','" + a.getDescription() + "','" + a.getType() + "','" + a.getA_qui_destiné() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("article ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }
    //  ps.setString(1,c.getStatus().toString());
/*
       PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,a.getNom());
            ps.setInt(2,a.getQte());
            ps.setString(3,a.getDescription());
            ps.setString(4,a.getType());

            ps.setString(5,a.getA_qui_destiné());
                        ps.executeUpdate();

            System.out.println("articles ajouter avec succés");
        }
         catch (SQLException ex) {
            System.out.println(ex);
      } 
      }  */

    //String req = "INSERT INTO articles (nom,Qte,description,type,a_qui_destiné) VALUES (?,?,?,?,?)";

    /*
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,a.getNom());
            ps.setInt(2,a.getQte());
            ps.setString(3,a.getDescription());
            ps.setString(4,a.getType());

            ps.setString(5,a.getA_qui_destiné());
                        ps.executeUpdate();

            System.out.println("articles ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
    public void updatearticles(articles a) {
        try {
            //('"+a.getNom()+"','"+a.getQte()+"','"+a.getDescription()+"','"+a.getType()+"','"+a.getA_qui_destiné()+"')"
            String req = "update articles  SET nom_articles='" + a.getNom_articles() + "',Qte='" + a.getQte() + "',description='" + a.getDescription() + "',type='" + a.getType() + "',a_qui_destiné='" + a.getA_qui_destiné() + "' where id_articles='" + a.getId_articles() + "'";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("article ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            /*String req="update articles SET nom=?,Qte=?,description =?,type=?,a_qui_destiné=? where id_articles=?" ;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,a.getId_articles());
            ps.setString(2,a.getNom());
            ps.setInt(3,a.getQte());
            ps.setString(4,a.getDescription());
            ps.setString(5,a.getType());
            ps.setString(6,a.getA_qui_destiné());
            ps.executeUpdate();
            System.out.println("articles Modifié avec succés");
          
        } catch (SQLException ex) {
            Logger.getLogger(commande_services .class.getName()).log(Level.SEVERE, null, ex);
        } */
        

    }

    public ObservableList<articles> getallarticles() {
        ObservableList<articles> articleslist = FXCollections.observableArrayList();

        try {

            String req = "SELECT * FROM articles";
            PreparedStatement st = cnx.prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_articles = rs.getInt("id_articles");
                String nom_articles = rs.getString("nom_articles");
                int Qte = rs.getInt("Qte");
                String description = rs.getString("description");
                String type = (rs.getString("type"));
                String a_qui_destiné = rs.getString("a_qui_destiné");

                articleslist.add(new articles(id_articles, nom_articles, Qte, description, type, a_qui_destiné));
            }
        } catch (SQLException ex) {
            Logger.getLogger(articels_services.class.getName()).log(Level.SEVERE, null, ex);
        }

        return articleslist;

    }
    
/*
    
    
    */ public void retirerarticles(int id_articles, int qte  ) {
         //System.out.println(id_articles);
         //System.out.println(qte);
         try {
                    String query = "SELECT * FROM articles WHERE id_articles = ? ";
	PreparedStatement preparedStmt = cnx.prepareStatement(query);
            preparedStmt.setInt(1, id_articles);
                    ResultSet result = preparedStmt.executeQuery();
                    int newquantite = 0;
                    
                    while (result.next()) {
                        newquantite=result.getInt("Qte") - qte ;
                    //System.out.println("aaaaaaaaaaa " + result.getInt("Qte"));
                    }
             //System.out.println("old qte " + id_articles + " new qte " + newquantite );
            String req = "update articles  SET Qte='" + newquantite + "' where id_articles='" + id_articles + "'";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("article retiré  avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}
    
    public void Supprimerarticle(articles a) {
        try {
            String req = "DELETE FROM articles WHERE id_articles=" + a.getId_articles() + "";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("article  supprimeé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    
    
public List<articles> recherche(String s) throws SQLException {
        List<articles> retour = new ArrayList<>();
        Statement stm = cnx.createStatement();
        String req = "SELECT * from `articles` where nom LIKE '%"+s+"%'";
        ResultSet rs = stm.executeQuery(req);
        while (rs.next()) {
            int id_articles = rs.getInt("id_articles");
                String nom_articles = rs.getString("nom_articles");
                int Qte = rs.getInt("Qte");
                String description = rs.getString("description");
                String type = (rs.getString("type"));
                String a_qui_destiné = rs.getString("a_qui_destiné");
            articles a = new articles(id_articles, nom_articles, Qte, description, type, a_qui_destiné);

            retour.add(a);
            

        }

        return retour;
        
        
    }
   
}
