/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entitiesEx.Patient;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import servicesEx.ServicePatient;

/**
 * FXML Controller class
 *
 * @author acila
 */
public class AffichagePatientController implements Initializable {

    @FXML
    private TableView<Patient> tabpatient;
    @FXML
    private TableColumn<Patient, String> colnomprenomp;
    @FXML
    private TableColumn<Patient, String> coldnp;
    @FXML
    private TableColumn<Patient, String> colsexep;
    @FXML
    private TableColumn<Patient, String> coladrp;
    @FXML
    private TextField filtrep;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServicePatient s = new ServicePatient();
            
            
            colnomprenomp.setCellValueFactory(new PropertyValueFactory<Patient,String>("nomprenomp"));
            coldnp.setCellValueFactory(new PropertyValueFactory<Patient,String>("dnp"));
            colsexep.setCellValueFactory(new PropertyValueFactory<Patient,String>("sexep"));
            coladrp.setCellValueFactory(new PropertyValueFactory<Patient,String>("adrp"));
            ObservableList<Patient> list =s.getAll();
            
            list = s.getAll();
            tabpatient.setItems(list);
            
    }    
   
   
    @FXML
    private void modifier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierPatient.fxml"));
        Parent root =loader.load();
        tabpatient.getScene().setRoot(root);
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
         Patient E = tabpatient.getSelectionModel().getSelectedItem();
        ServicePatient s = new ServicePatient();
        s.supprimer(new Patient(E.getIdPatientp()));
        JOptionPane.showMessageDialog(null,"Patient supprimé");

        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichagePatient.fxml")) ;
    	Scene rcScene= new Scene(root);
        
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjoutPatient.fxml"));
        Parent root =loader.load();
        tabpatient.getScene().setRoot(root);
    }
    
}
