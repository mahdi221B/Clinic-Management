/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gui;

import VisiteEntities.RendezVous;
import VisiteServices.ServiceRendezvous;
import static com.sun.media.jfxmediaimpl.MediaUtils.warning;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static sun.management.Agent.warning;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class RendezVousaffichageController implements Initializable {

    @FXML
    private TableView<RendezVous> TvRDV;
    @FXML
    private TableColumn<RendezVous, String> CNomed;
    @FXML
    private TableColumn<RendezVous, String> Cdat;
    @FXML
    private TableColumn<RendezVous, String> Cheure;
    @FXML
    private TableColumn<RendezVous, String> Cnompat;
    @FXML
    private TableColumn<RendezVous, String> Ccaus;
    @FXML
    private Label warning;
    @FXML
    private TextField tfTitre;
    @FXML
    private Button Submit;
    private VBox pnItems;
    @FXML
    private TextField tafftotal;

    /**
     * Initializes the controller class.
    */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceRendezvous s = new  ServiceRendezvous();
        CNomed.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("nomMedecinRv"));
        Cdat.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("dateRendezVous"));
        Cheure.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("heure"));
        Cnompat.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("nomPatient"));
        Ccaus.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("cause"));
        ObservableList<RendezVous> list = (ObservableList<RendezVous>) s.afficher();
        TvRDV.setItems(list);
        
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
         try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/RendezVousajout.fxml"));
        Parent root =loader.load();
        
        tfTitre.getScene().setRoot(root);
        
        }catch(IOException ex) {
	warning.setText("Selectionner un Rendez-vous");
	}   
    }
    

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
    RendezVous R = TvRDV.getSelectionModel().getSelectedItem();
    ServiceRendezvous s = new  ServiceRendezvous();
    s.supprimer(new RendezVous(R.getIdRv()));
    JOptionPane.showMessageDialog(null,"RendezVous supprimé");
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/RendezVousaffichage.fxml")) ;
    	Scene rcScene= new Scene(root);
        
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }


    @FXML
    private void modifier(ActionEvent event) {
        
        try {
        RendezVous r = TvRDV.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/RendezVousModifier.fxml"));
        Parent root =loader.load();
        
        RendezVousModifierController dpc = loader.getController();
        
        tfTitre.getScene().setRoot(root);
      
        dpc.init(r);
        }catch(IOException ex) {
	warning.setText("Selectionner un Rendez vous");
        
        
	}
        
        
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/acceuil.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

  

   
        
    

    @FXML
    private void nbrRDV(ActionEvent event) throws SQLException {
        ServiceRendezvous rd=new ServiceRendezvous();
      
       
    }
   
    
    
}
