/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.absence;
import entities.user;
import services.absenceservice;
import services.userservice;


/**
 *
 * @author ce pc
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // MyDB instance = MyDB.getInstance();
        
 /********************************************************************************************************/
      //////////////////////////////////////ajouter user/////////////////////////////////////////////////  
          userservice us = new userservice();                              
         us.ajouter(new user("ll","ll","ll",2,06,"nnn","gg","mm"));
     //////////////////////////////////////////////////////////////////////////////////////////////    
        
     //////////////////////////////ajouter ab////////////////////////////////////////////////
         absenceservice ab = new absenceservice();                               
       //  ab.ajouter(new absence(6,"nmn","gbbbbkk","eeeeeeem","pppmf","ppppjjm"));
     //////////////////////////////////////////////////////////////////////////////////////////         
 /************************************************************************************************************/     
      
   /*********************************************************************************************************/            
      /////////////////////////supprimer///////////////////////////////
              //   user u=new user(5);         //test suprimer user
              //  us.Supprimeruser(u);         //test supprimer user
              //    absence a=new absence(2);    //test supprimer ab
              //    ab.Supprimerabsence(a);       //test supprimer ab
   //////////////////////////////////////////////////////////////////////////////
   
   /*******************************************************************************************/
             //  user u = new user(3,"Ahmed","Ahmed","h",12,12,"ff"); //test modifier
             //  us.modifier(u); //test modif
   /**********************************************************************************************/
   /***********************************modif ab*************************************************/
             //   absence a =new absence(1,"8","ad","sm","5f","77jm","oi");
             //    ab.modifier(a);
   /*********************************************************************************************/          
             
             // System.out.println(ab.afficher())  ;//--afficher ab
             // System.out.println(us.afficher())  ;
              
    }
    
}
