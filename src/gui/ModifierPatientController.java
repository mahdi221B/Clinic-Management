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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import servicesEx.ServicePatient;

/**
 * FXML Controller class
 *
 * @author acila
 */
public class ModifierPatientController implements Initializable {

    @FXML
    private TextField tfnomprenomp;
    @FXML
    private TextField dnp;
    @FXML
    private TextField adrp;
    @FXML
    private TextField sexep;
    private int ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> sexes = FXCollections.observableArrayList("homme","femme");
       // sexep.setItems(sexes);sexep.getSelectionModel().getSelectedItem().toString()
    }    
     void init(Patient p) {
       ID = p.getIdPatientp();
       tfnomprenomp.setText(p.getNomprenomp());
       dnp.setText(p.getDnp());
       adrp.setText(p.getAdrp());
    }

    @FXML
    private void modifier(ActionEvent event) {
       ServicePatient s = new ServicePatient();
       s.modifier(new Patient(ID,tfnomprenomp.getText(),dnp.getText(),sexep.getText(),adrp.getText()));
       JOptionPane.showMessageDialog(null,"Patient modifié");
       
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichagePatient.fxml")) ;
            Scene rcScene= new Scene(root);
            
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
    }

   /* private void selectg(ActionEvent event) {
        String t=sexep.getSelectionModel().getSelectedItem().toString();
    }*/
    
}
