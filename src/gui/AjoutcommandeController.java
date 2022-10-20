/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.commande_services;

/**
 * FXML Controller class
 *
 * @author miled
 */
public class AjoutcommandeController implements Initializable {

    @FXML
    private TextField status;
    @FXML
    private DatePicker date_ajout;
    @FXML
    private DatePicker date_cloture;
    @FXML
    private TextField motif_cloture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajoutercommande(ActionEvent event) {
    
        commande_services cs = new commande_services();
        cs.Ajoutercommande(new commande(status.getText() , date_ajout.getValue().toString(), date_cloture.getValue().toString(), motif_cloture.getText() ));
               JOptionPane.showMessageDialog(null,"commande ajoutée");
        Parent root = null;
               
  Scene rcScene= new Scene(root);
    	
  	Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }  
                
    }
    
