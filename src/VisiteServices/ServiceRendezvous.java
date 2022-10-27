/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisiteServices;

import VisiteEntities.DossierPatient;
import VisiteEntities.RendezVous;
import VisiteInterfaces. IService;
import VisiteUtils.DBconnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 *
 * @author USER
 */

public class ServiceRendezvous implements  IService<RendezVous>{
private Statement ste;
Connection cnx;

    public ServiceRendezvous() {
        DBconnexion c = DBconnexion.getInstance();
        cnx = c.getCnx();
    }
    @Override
    public void ajouter(RendezVous r) {
 try {
            String requete = "INSERT INTO rendez_vous (nomPatient,heure_rdv,nom_medecin,cause_rdv,date_rdv) VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, r.getNomPatient());
            pst.setString(2, r.getHeure());
             pst.setString(3, r.getNomMedecinRv());
              pst.setString(4, r.getCause());
               pst.setString(5, r.getDateRendezVous());
               
            pst.executeUpdate();
            System.out.println("Rendez_vous  ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public void supprimer(RendezVous r) {
try {
            String requete = "DELETE FROM rendez_vous WHERE id_rdv="+r.getIdRv()+"";
            Statement pst = cnx.createStatement();
            pst.executeUpdate(requete);
            System.out.println("RendezVous supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}

    @Override
    public void modifier(RendezVous r) {
        
         try {
            String req="UPDATE rendez_vous SET nomPatient='"+r.getNomPatient()+"',heure_rdv='"+r.getHeure()+"',nom_medecin='"+r.getNomMedecinRv()+"',cause_rdv='"+r.getCause()+"',date_rdv='"+r.getDateRendezVous()+"' where id_rdv='"+r.getIdRv()+"' "; 
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rendez_vous Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  
    }
   
    
    @Override
     public ObservableList<RendezVous> afficher() {
        ObservableList<RendezVous> listRDV = FXCollections.observableArrayList();
        try {
            String req="select * from rendez_vous" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                int idRv=rs.getInt("id_rdv");
                String nomPatient=rs.getString("nomPatient");
                String dateRendezVous=rs.getString("date_rdv");
                String heure=rs.getString("heure_rdv");
                String nomMedecinRv=rs.getString("nom_medecin");
                String cause=rs.getString("cause_rdv"); 
                
                listRDV.add(new RendezVous(idRv,nomPatient,dateRendezVous,heure,nomMedecinRv,cause));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listRDV ;  
    }
    

public void nbPationsTotal(RendezVous r) {
try {
            PreparedStatement ste = cnx.prepareStatement("update rendez_vous set id_rdv=id_rdv+1 WHERE id_rdv=" + r.getIdRv());

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RendezVous.class.getName()).log(Level.SEVERE, null, ex);
        }
   
           

}
 
    
      /*public List<RendezVous> TrierParDateRDV() throws SQLException {
       List<RendezVous> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from rendezvous ORDER BY date_rdv DESC");
        RendezVous com = null;
        while (res.next()) {
            com = new RendezVous(res.getInt(1),res.getString(2), res.getString(3),res.getString(4),res.getString(5),res.getString(6));
            list.add(com);
            System.out.println(list);
        }
        return list;*/
        
    
 public List<RendezVous> triParCause(){
        return afficher().stream().sorted(Comparator.comparing(RendezVous::getCause)).collect(Collectors.toList());
    }
 
    public List<RendezVous> triParNom(){
         List<RendezVous>myList = new ArrayList<>();
        try {
            
            String requet2="SELECT * FROM post order by titre";
            Statement st = cnx.prepareStatement(requet2);              
            ResultSet rs = st.executeQuery(requet2);
            while(rs.next()){
                RendezVous P = new RendezVous();
                P.setIdRv(rs.getInt(1));
                P.setNomPatient(rs.getString("nomPatient"));
                P.setHeure(rs.getString("heure_rdv"));
                P.setNomMedecinRv(rs.getString("nom_medecin"));
                P.setCause(rs.getString("cause_rdv"));
                P.setDateRendezVous(rs.getString("date_rdv"));
                myList.add(P);
            }
               
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
        return myList;
  
    }

   
}

