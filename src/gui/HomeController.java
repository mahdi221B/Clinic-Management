/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author miled
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void valide(ActionEvent event) throws IOException {
    
     Parent root = FXMLLoader.load(getClass().getResource("../gui/validercommande.fxml")) ;
     Scene rcScene= new Scene(root);
    	
  	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }

    @FXML
    private void commande(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("../gui/detaillecommande.fxml")) ;
     Scene rcScene= new Scene(root);
    	
  	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }

    @FXML
    private void article(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/detaillearticles.fxml")) ;
     Scene rcScene= new Scene(root);
    	
  	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }
    
}
