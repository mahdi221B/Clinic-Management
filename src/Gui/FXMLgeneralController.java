/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLgeneralController implements Initializable {

    @FXML
    private Pane rr;
    @FXML
    private TextField tfTitre;
    @FXML
    private Button rendez_vous;
    @FXML
    private Button consultation;
    @FXML
    private Button dossier;
    @FXML
    private Pane rr1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void espace_rdv(ActionEvent event) throws LoadException {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/RendezVousaffichage.fxml"));
            Parent root =loader.load();
            rendez_vous.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLgeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void espace_cons(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/ConsultationAffichage.fxml"));
            Parent root =loader.load();
            consultation.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLgeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void espace_dos(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/DossierAffichage.fxml"));
            Parent root =loader.load();
            dossier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLgeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ContacterMed(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/web.fxml"));
            Parent root =loader.load();
            dossier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLgeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
