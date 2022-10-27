/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.commande;
//import java.util.Date;
import outils.MyDb;
import services.commande_services;
import services.articels_services;
import entities.articles;
import entities.ligne_de_commande;
import services.lignedecommande_services;
import java.sql.Date;
import java.sql.SQLException;
/**
 *
 * @author miled
 */
public class test {
    public static void main(String[] args) throws SQLException {
          System.out.println(MyDb.getInstance());
          
         commande_services  cs = new commande_services();
         articels_services as = new articels_services();
         lignedecommande_services lcs = new lignedecommande_services();
      //   articles ar1 = new articles("doliprane",5 , "description" ,"equipement" ,"adulte");
         
        //as.Ajoutrarticle(ar1);
                  //ligne_de_commande lc =new ligne_de_commande(1,+  2, 3, 4) ;
         //lcs.Ajouterlignecommande(lc);
         
       
       commande c3 = new commande(50,"2015-10-10" );
         // commande c = new commande( statut_commande ,Date.valueOf("1665-08-08"),Date.valueOf("1665-08-08")  ,"echec") ;   
//commande c = new commande(2);
       cs.Ajoutercommande2(c3);
       //cs.Supprimercommande(c);
       cs.getallcommandes();
//       System.out.println(cs.getallcommandes());
//cs.updatecoamande(c3);
     
  //fournisseur f2 =  new fournisseur(1,"drii", 50, 2);                        
  //fs.Ajouterfournisseur(f2);
  //fs.updateFournisseur(f2);
  //getallcommandes());
  //cs.Supprimercommande(c2);
        
       
    }   
    
    
}
