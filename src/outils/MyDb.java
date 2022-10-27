/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outils;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * 
 *
 * @author miled
 */
public class MyDb {
         String url="jdbc:mysql://localhost/pi2022";
    String user="root";
    String  password="";
    Connection cnx;
    static MyDb instances;
    
    private MyDb(){
          try {
              cnx=DriverManager.getConnection(url, user, password);
              System.out.println("connexion établit");
                     
          } catch (SQLException ex) {
              System.out.println(ex);
                  
          }
        
          
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    
    public static MyDb getInstance(){
        
        if(instances==null){
            
            instances= new MyDb();
        }
        return instances;   
}
}