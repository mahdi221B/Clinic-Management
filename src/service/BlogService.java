/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import outils.MyDB;
import entities.Blog;
import interfaces.IService;

import java.util.List;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author ThinkPad
 */
public class BlogService implements IService<Blog> {
    Connection cnx ; 

    public BlogService() {
    cnx = MyDB.getInstance().getCnx();
    
}
    
    public void add(Blog s){
        try {
            String req = "INSERT INTO post (Sujet_Post,Description_Post,Date_Post,Review_Post,User_Id_Post) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,s.getSujet_Post());
            ps.setString(2,s.getDescription_Post());
            ps.setString(3,s.getDate_Post());
            ps.setString(4,s.getReview_Post());
            ps.setInt(5,s.getUser_Id_Post());
            ps.executeUpdate();

            System.out.println("Post ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    

public void update(Blog s) {
        try {
            String req="update post SET Sujet_Post='"+s.getSujet_Post()+"',Description_Post='"+s.getDescription_Post()+"',Date_Post='"+s.getDate_Post()+"',Review_Post='"+s.getReview_Post()+"',User_Id_Post='"+s.getUser_Id_Post()+"' where Id_Post='"+s.getId_Post()+"'" ;                                                                                                               
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Post Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     
        
        
        
    } 
public void delete(Blog s){
        try {
            String req = "DELETE FROM post WHERE Id_Post="+s.getId_Post()+"";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("post supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}


    @Override
    public ObservableList<Blog> getAll() {
        ObservableList<Blog> listpost =  FXCollections.observableArrayList();
        try {
            String req="select * from post" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
               
                int Id_Post =rs.getInt("Id_Post");
                String Sujet_Post=rs.getString("Sujet_Post");
                String Description_Post=rs.getString("Description_Post");
                String Date_Post=rs.getString("Date_Post"); 
                String Review_Post=rs.getString("Review_Post");
                int User_Id_Post=rs.getInt("User_Id_Post");
                
                listpost.add(new Blog(Id_Post,Sujet_Post,Description_Post,Date_Post,Review_Post,User_Id_Post)) ;
            
                    

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listpost ;  
        }
    
    
    public int TotalPOST() {
    
    int n = 0;
    try {
        String req = "select * from post";
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
    }
    
    
    

