/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mahdi
 */
public class MyDB {String url="jdbc:mysql://localhost/PI2022GC";
    String user="root";
    String password="";
    Connection cnx;
    
    
    static MyDB instance;
    private MyDB(){
        try {
            cnx= DriverManager.getConnection(url,user,password);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static MyDB getInstance(){
            if (instance==null){
                instance =new MyDB();
            }
            return instance;
        }
    
    public Connection getCnx() {
        return cnx;
    }
    
    
}