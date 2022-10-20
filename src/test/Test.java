/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import entities.Blog;
import entities.Categorie;
import entities.Commentaire;
import outils.MyDB;
import service.BlogService;
import service.CategorieService;
import service.CommentaireService;

/**
 *
 * @author ThinkPad
 */
public class Test {
    
    public static void main(String[] args) {
            
              BlogService us = new BlogService();
     
      
      
    //Blog u = new Blog ("20-20","2","desc","9262564",4);
  //  us.add(u);
       
      Blog u = new Blog(7);
      us.delete(u);
       
      //Blog u = new Blog (3,"199999999999999999999999","aaa","okjra","9262564",9);
      //us.update(u);
       
     
 System.out.println(us.getAll()); //afichage
 

  //CommentaireService a = new CommentaireService();
  
 // Commentaire u = new Commentaire("text",5,5);
  //a.add(u);
  
  
  
  //Commentaire u = new Commentaire(1,"aa",5,9);
  //a.update(u);
          
  //Commentaire u = new Commentaire(3);
  //a.delete(u);
  
  
  //System.out.println(a.getAllCommentaire());
  
  
  
        CategorieService C = new CategorieService();
  
  
  //Categorie u = new Categorie("c","a",5);
 // C.add(u);
  
 // Categorie u = new Categorie(1,"5","48",5);
 // C.update(u);
  
  //Categorie u = new Categorie(1);
  //C.delete(u);
  
 //System.out.println(C.getAll());
}
    
}

