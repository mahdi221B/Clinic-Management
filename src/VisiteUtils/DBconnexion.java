/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisiteUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnexion {String url="jdbc:mysql://localhost/visite";
    String user="root";
    String password="";
    Connection cnx;
    
    
    static DBconnexion instance;
    private DBconnexion(){
        try {
            cnx= DriverManager.getConnection(url,user,password);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static DBconnexion getInstance(){
            if (instance==null){
                instance =new DBconnexion();
            }
            return instance;
        }
    
    public Connection getCnx() {
        return cnx;
    }
    
    
}
