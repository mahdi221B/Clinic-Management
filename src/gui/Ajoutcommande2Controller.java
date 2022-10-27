/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.commande;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.commande_services;

/**
 * FXML Controller class
 *
 * @author miled
 */
public class Ajoutcommande2Controller implements Initializable {

    @FXML
    private TextField QteC;
    @FXML
    private DatePicker date_ajout;
    @FXML
    private Label warning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajoutercommande(ActionEvent event) throws IOException {
     if( QteC.getText().isEmpty()  )
    {warning.setText("veuiller remplire  la quantite  ");
    } else {
        
    commande_services cs = new commande_services();
      cs.Ajoutercommande2(new commande(Integer.parseInt(QteC.getText())  ,date_ajout.getValue().toString() ));
        JOptionPane.showMessageDialog(null,"commande ajoutée");
               
      Parent root = FXMLLoader.load(getClass().getResource("../gui/detaillearticles.fxml")) ;
     Scene rcScene= new Scene(root);
    	
  	Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }  
    }}
    

