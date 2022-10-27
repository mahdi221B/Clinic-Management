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
public class AjoutExamenController implements Initializable {

    @FXML
    private TextField idMedecin;
    
    @FXML
    private TextField idSalle;
    @FXML
    private TextField idPatient;
    
    @FXML
    private ComboBox typeEx;
    @FXML
    private TextField dateEx;
    private int ID;
    @FXML
    private ComboBox resEx;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> TypeExamens = FXCollections.observableArrayList("bilan","radiologie","examen allergie","covid");
        typeEx.setItems(TypeExamens);
        ObservableList<String> resExs = FXCollections.observableArrayList("Positive","negative");
        resEx.setItems(resExs);
    }    

     @FXML
    private void select(ActionEvent event) {
        String t=typeEx.getSelectionModel().getSelectedItem().toString();
    }
    
    @FXML
    private void selectRes(ActionEvent event) {
        String r=resEx.getSelectionModel().getSelectedItem().toString();
    }
    
    @FXML
    private void ajouter(ActionEvent event) {
       
        ServiceExamen e = new ServiceExamen();
        // if (idMedecin.getText().isEmpty()){
          //  System.out.println("message");}
        e.ajouter(new Examen(ID,idMedecin.getText(),
        idSalle.getText(),idPatient.getText(), typeEx.getSelectionModel().getSelectedItem().toString(),dateEx.getText(),resEx.getSelectionModel().getSelectedItem().toString()));
    JOptionPane.showMessageDialog(null,"Examen ajouté");
            Parent root = null;
    /*
    Scene rcScene= new Scene(root);
    Stage window;
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();*/
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

   
    
}
