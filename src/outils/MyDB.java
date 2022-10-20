/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ce pc
 */
public class MyDB {
    private final String url="jdbc:mysql://localhost/pi2022" ;
   private final String user="root";
   private final String password="";  
    private Connection cnx;
    private static MyDB instance;
    
    private MyDB() {
        try {
            cnx=DriverManager.getConnection(url, user, password);
            System.out.println("connesion établie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }
    
    public static MyDB getInstance(){
    if(instance == null){
    instance = new MyDB();
                     }
    return instance;
    
    } 
    public Connection getConnection(){
    return cnx;
   
    }
}
