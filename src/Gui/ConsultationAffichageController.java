/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.Consultation;
import VisiteEntities.RendezVous;
import VisiteServices.ServiceConsultation;
import VisiteServices.ServiceRendezvous;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ConsultationAffichageController implements Initializable {

    @FXML
    private TableColumn<Consultation, String> nmco;
    @FXML
    private TableColumn<Consultation, String> datca;
    @FXML
    private TableColumn<Consultation, String> npatco;
    @FXML
    private TableColumn<Consultation, String> lexcoa;
    @FXML
    private TableColumn<Consultation, String> lmedicoa;
    @FXML
    private TableColumn<Consultation, String> traitcoa;
    @FXML
    private Label warning;
    @FXML
    private TextField tfTitre;
    @FXML
    private TableView<Consultation> tvConsult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceConsultation C = new  ServiceConsultation();
         datca.setCellValueFactory(new PropertyValueFactory<Consultation, String>("dateConsultation"));
         npatco.setCellValueFactory(new PropertyValueFactory<Consultation, String>("nomPatient"));
        nmco.setCellValueFactory(new PropertyValueFactory<Consultation, String>("nomMedecin"));
         lmedicoa.setCellValueFactory(new PropertyValueFactory<Consultation, String>("listMedicament"));
        lexcoa.setCellValueFactory(new PropertyValueFactory<Consultation, String>("listExamens"));
        traitcoa.setCellValueFactory(new PropertyValueFactory<Consultation, String>("traitement"));
       
        ObservableList<Consultation> li = (ObservableList<Consultation>) C.afficher();
        tvConsult.setItems(li);
        
    }    

    @FXML
    private void ajouterC(ActionEvent event) {
         try {
        //Change the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/ConsultationAjout.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        //get the new scene
        tfTitre.getScene().setRoot(root);
        
        }catch(IOException ex) {
	warning.setText("Selectionner une consultation");
	}   
    }

    @FXML
    private void modifierC(ActionEvent event) {
        try {
        Consultation r = tvConsult.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
        //Change the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/ConsultationModif.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        ConsultationModifController dpc = loader.getController();
        //get the new scene
        tfTitre.getScene().setRoot(root);
        //Initializer les donnees de formateur
        dpc.init(r);
        }catch(IOException ex) {
	warning.setText("Selectionner une consultation");
        }
    }

    @FXML
    private void supprimerC(ActionEvent event) throws IOException {
     Consultation R = tvConsult.getSelectionModel().getSelectedItem();
    ServiceConsultation s = new  ServiceConsultation();
    s.supprimer(new Consultation(R.getIdCon()));
    JOptionPane.showMessageDialog(null,"Consultation supprimé");
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ConsultationAffichage.fxml")) ;
    	Scene rcScene= new Scene(root);
        
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    
    }
    

    @FXML
    private void Exit(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/acceuil.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
}
