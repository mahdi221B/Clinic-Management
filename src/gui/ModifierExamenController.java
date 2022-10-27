/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entitiesEx.Examen;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import servicesEx.ServiceExamen;

/**
 * FXML Controller class
 *
 * @author acila
 */
public class ModifierExamenController implements Initializable {

   
    @FXML
    private TextField idMedecin;
     @FXML
    private TextField idSalle;
    @FXML
    private ComboBox typeEx;
    @FXML
    private TextField dateEx;
    @FXML
    private TextField idPatient;
    private int ID;
    @FXML
    private ComboBox resEx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList<String> TypeExamens = FXCollections.observableArrayList("bilan","radiologie","examen allergie","covid");
        typeEx.setItems(TypeExamens);
        ObservableList<String> resExs = FXCollections.observableArrayList("Positive","negative");
        resEx.setItems(resExs);
    }    

    void init(Examen e) {
       
       idMedecin.setText(e.getIdMedecin());
       idSalle.setText(e.getIdSalle());
       idPatient.setText(e.getIdPatient());
       
      dateEx.setText(e.getDateEx());
      
    }
    @FXML
    private void modifier(ActionEvent event) {
       ServiceExamen s = new ServiceExamen();
       s.modifier(new Examen(ID,idMedecin.getText(),idSalle.getText(),idPatient.getText(),typeEx.getSelectionModel().getSelectedItem().toString(),dateEx.getText(),resEx.getSelectionModel().getSelectedItem().toString()));
       JOptionPane.showMessageDialog(null,"Examen modifié");
       
    }

    @FXML
    private void Exit(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
            Scene rcScene= new Scene(root);
            
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierExamenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void select(ActionEvent event) {
        String t=typeEx.getSelectionModel().getSelectedItem().toString();
        
    }

   
    @FXML
    private void selectres(ActionEvent event) {
        String r=resEx.getSelectionModel().getSelectedItem().toString();
    }
    
}
