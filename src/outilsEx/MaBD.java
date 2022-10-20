/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outilsEx;

import com.sun.corba.se.pept.transport.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acila
 */
public class MaBD {
    String url ="jdbc:mysql://localhost/GestionExamen";
    String user ="root";
    String passwd ="";
    Connection cnx;
    static MaBD instance;
    
    private MaBD(){
        try {
            cnx = (Connection) DriverManager.getConnection(url,user,passwd);
            System.err.println("Connexion établie");
        }catch(SQLException excp ){
            System.out.println(excp);}
    }

    /**
     *
     * @return
     */
    public static MaBD getInstance(){
        if ( instance == null){
            instance = new MaBD();
        }
    return instance;
    }
    public Connection getCnx(){
        return cnx;}
}
