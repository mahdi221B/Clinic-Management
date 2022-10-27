/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesEx;

import entitiesEx.Salle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import outilsEx.MaBD;

/**
 *
 * @author acila
 */
public class ServiceSalle implements IServiceEx<Salle>{
  Connection cnx;
    public ServiceSalle(){
    MaBD bd =MaBD.getInstance();
    cnx=(Connection) bd.getCnx();}
    private Statement ste;
    
    public void ajouter(Salle s)
    {
        java.util.Date date = new java.util.Date();
        String req = "INSERT INTO salle (idSalle,idEtageSalle,blocs,appareilUtilise) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,s.getIdSalle());
            ps.setInt(2,s.getIdEtageSalle());
            ps.setString(3, s.getBlocs());
            ps.setString(4, s.getAppareilUtilise());
            
            ps.executeUpdate();
            System.out.println("Salle ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
     public void supprimer(Salle s) {
        try {
            String req = "DELETE FROM salle WHERE idSalle=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, s.getIdSalle());
            ps.executeUpdate();
            System.out.println("salle supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }

    /**
     *
     * @param e
     */
    public void modifier(Salle s) {
        try {
            String requete = "UPDATE salle SET idEtageSalle=?,blocs=?, Appareilutilise=? WHERE idSalle=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, s.getIdEtageSalle());
            pst.setString(2, s.getBlocs());
            
            pst.setString(3,s.getAppareilUtilise());
            
            pst.setInt(4,s.getIdSalle());
      
            pst.executeUpdate();
            System.out.println("salle modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public List<Salle> afficher() {
        List<Salle> salles = new ArrayList<>();

        try {
            String requete = "SELECT * FROM salle";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idEtageSalle=rs.getInt("idEtageSalle");
                int idSalle=rs.getInt("idSalle");
                String blocs=rs.getString("blocs");
                String Appareiltilise=rs.getString("appareilUtilise");
                
                salles.add(new Salle (idSalle,idEtageSalle,blocs,Appareiltilise));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return salles;
    }   

    public ObservableList<Salle> getAll() {
          ObservableList<Salle> Salles = FXCollections.observableArrayList();
         

         try {
             String  req = "SELECT * FROM salle";
             PreparedStatement st = cnx.prepareStatement(req);
             ResultSet rs =st.executeQuery();
             while(rs.next()){
             int idSalle=rs.getInt("idSalle");
             int idEtageSalle=rs.getInt("idEtageSalle");
             String blocs=rs.getString("blocs");
             String appareilUtilise=rs.getString("appareilUtilise");
             
             Salles.add(new Salle(idSalle,idEtageSalle,blocs,appareilUtilise));
             
                      }
             
         } catch (SQLException ex) {
             Logger.getLogger(ServiceSalle.class.getName()).log(Level.SEVERE, null, ex);
         }
           
           return Salles ;
    }
    
  /*  
     private void chercherDos(ActionEvent event) throws IOException {
          ServiceDossierpatient f = new  ServiceDossierpatient();
           Parent p1;   
   
         
        try {
            DossierPatient p = new DossierPatient();
           
           ArrayList<DossierPatient> ps = f.afficheDossier(tf1.getText());   
                   
            data = FXCollections.observableArrayList();
         
            
            
            
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
            a1.setTitle("Fiche trouvée");
            a1.setContentText(ps.toString());
            a1.show();
            p1 = FXMLLoader.load(getClass().getResource("../gui/DossierAffichage.fxml"));
            
            Scene test1 = new Scene(p1);
            
            Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            App1.setScene(test1);
            App1.show();
          
         
            
        }
     catch(IOException ex ){
  
         Alert alert = new Alert(Alert.AlertType.WARNING);
            
            alert.setTitle("No Name found");
            alert.setHeaderText("Nom du patient n'existe pas ");
            alert.setContentText("s'il vous plais cherchez avec un autre nom ou bien ecrivez un nouveau dossier avec ce nom ");

            alert.showAndWait();
        
        
    }
    
    public Salle filtrer(String s)
    {   Salle f = new Salle();
        try {
            String req = "SELECT * from salle where idEtageSalle ='"+s+"';";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
       
              while (rs.next()) 
        {  
            //pst.setInt(getIdEtageSalle(1));
            //pst.setInt( s.getIdSalle(2));
            //pst.setString(s.getAppareilUtilise());
            f.setIdSalle(rs.getInt(1));
            f.getIdEtageSalle(rs.getInt(2));
            f.getAppareilUtilise(rs.getString(3));
           

        }
            
        } catch (SQLException e) {
               Alert alert = new Alert(Alert.AlertType.NONE);
            
            alert.setTitle("No Name found");
            alert.setHeaderText("Nom du patient n'existe pas ");
            alert.setContentText("Please search a name of a patient or create a new fiche with this name ");

            alert.show();
        }
        System.out.println("Salle dans Etage numéro: "+f.getIdEtageSalle()+" Trouvée ");
        return f;
    }

   /* public int getTotal(long u) {
    ObservableList<Salle> Evenement = FXCollections.observableArrayList();
        String req = "SELECT count(*) as total FROM `salle` where user_ID="+u;
       
        try {
           
            ste = cnx.createStatement();
            ResultSet resultSet = ste.executeQuery(req);
            int x =0 ;
            while(resultSet.next()){
                Salle ev = new Salle();
                x = resultSet.getInt("total");
            }
            return x;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceSalle.class.getName()).log(Level.SEVERE, null, ex);    
        }
        return 0;
    }
*/
   
}
