/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author ce pc
 */
public class AccueilFXMLController implements Initializable {

    @FXML
    private Button id_gestion_user;
    @FXML
    private Button id_gestion_absence;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gerer_user(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/PageuserFXML.fxml"));
            Parent root =loader.load();
            id_gestion_user.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccueilFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void gerer_absence(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/PageabsenceFXML.fxml"));
            Parent root =loader.load();
            id_gestion_user.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccueilFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
