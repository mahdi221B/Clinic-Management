/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import entities.Commentaire;
import interfaces.IService;
import outils.MyDB;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author ThinkPad
 */
public class CommentaireService implements IService<Commentaire>{
     Connection cnx ; 

    public CommentaireService() {
    cnx = MyDB.getInstance().getCnx();
    }
    
    public void add(Commentaire u){
        try {
            
            String req = "INSERT INTO commentaire (Text_Commentaire,User_Id_Commentaire,Id_Post_Commentaire) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,u.getText_Commentaire());
            ps.setInt(2,u.getUser_Id_Commentaire());
            ps.setInt(3,u.getId_Post_Commentaire());
            ps.executeUpdate();
            System.out.println("Commentiare ajouté avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }




public void update(Commentaire u) {
    
        try {
            String req="update commentaire SET Text_Commentaire='"+u.getText_Commentaire()+"',User_Id_Commentaire='"+u.getUser_Id_Commentaire()+"',Id_Post_Commentaire='"+u.getId_Post_Commentaire()+"' where Id_Commentaire='"+u.getId_Commentaire()+"'" ;                                                                                                               
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Commentaire Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        
       
        }
}

public void delete(Commentaire u){
        try {
            String req = "DELETE FROM commentaire WHERE Id_Commentaire="+u.getId_Commentaire()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Commentaire supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
}
public ObservableList<Commentaire> getAll() {
        ObservableList<Commentaire> listCommentaires = FXCollections.observableArrayList();
        try {
            String req="select * from commentaire" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                Commentaire e ;
               
                int Id_Commentaire=rs.getInt("Id_Commentaire");
                String Text_Commentaire=rs.getString("Text_Commentaire");
                int User_Id_Commentaire =rs.getInt("User_Id_Commentaire");
                int Id_Post_Commentaire=rs.getInt("Id_Post_Commentaire"); 
               
                listCommentaires.add(new Commentaire(Id_Commentaire, Text_Commentaire, User_Id_Commentaire, Id_Post_Commentaire));
            
            
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listCommentaires ;  
        }




public int TotalComments() {
    
    int n = 0;
    try {
        String req = "select * from commentaire";
        Statement st =cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        while (rs.next()) {
            n = n+1;
        }
    } catch(SQLException ex) {
        System.out.println(ex);
    }
    return n;
}


public int getTop () {

        try {
            String req="select COUNT(*) AS most , User_Id_Commentaire as id FROM commentaire GROUP BY User_Id_Commentaire ORDER by most DESC LIMIT 1;" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            while(rs.next()) {
                  int idMostLiked = rs.getInt("id");
                  return idMostLiked;
            }
           
        } catch (SQLException ex) {
                                    System.out.println("error occured ");         
            }
         return 0;

}

}



