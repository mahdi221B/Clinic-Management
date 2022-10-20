/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.DossierPatient;
import VisiteEntities.RendezVous;
import VisiteServices.ServiceDossierpatient;
import VisiteServices.ServiceRendezvous;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DossierAffichageController implements Initializable {

    @FXML
    private TableView<DossierPatient> tvDosp;
    @FXML
    private TableColumn<DossierPatient, String> npa;
    @FXML
    private TableColumn<DossierPatient, String> mlda;
    @FXML
    private TableColumn<DossierPatient, String> medica;
    @FXML
    private TableColumn<DossierPatient, String> allrga;
    @FXML
    private TableColumn<DossierPatient, String> cslta;
    @FXML
    private TableColumn<DossierPatient, String> oprta;
    @FXML
    private Label warning;
    @FXML
    private TextField tfTitre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceDossierpatient s = new  ServiceDossierpatient();
        npa.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("nomP"));
        mlda.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("maladies"));
        medica.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("Medicaments"));
        allrga.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("AllergieMedicaments"));
        cslta.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("Consultations"));
        oprta.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("detailsOperation"));
        ObservableList<DossierPatient> list = (ObservableList<DossierPatient>) s.afficher();
        tvDosp.setItems(list);
    }    

    @FXML
    private void ajouter(ActionEvent event) {
         try {
        //Change the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/DossierAjout.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        //get the new scene
        tfTitre.getScene().setRoot(root);
        
        }catch(IOException ex) {
	warning.setText("Selectionner un Dossier");
	}   
    }

    @FXML
    private void modifier(ActionEvent event) {
         try {
        DossierPatient r = tvDosp.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
        //Change the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/DossierModif.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        DossierModifController dpc = loader.getController();
        //get the new scene
        tfTitre.getScene().setRoot(root);
        //Initializer les donnees de formateur
        dpc.init(r);
        }catch(IOException ex) {
	warning.setText("Selectionner un Dossier");
        
        
	}
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
         DossierPatient R = tvDosp.getSelectionModel().getSelectedItem();
    ServiceDossierpatient s = new  ServiceDossierpatient();
    s.supprimer(new DossierPatient(R.getIdP()));
    JOptionPane.showMessageDialog(null,"Dossier supprimé");
    }
    }
    

