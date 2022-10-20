/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.DossierPatient;
import VisiteEntities.RendezVous;
import VisiteServices.ServiceDossierpatient;
import VisiteServices.ServiceRendezvous;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DossierAjoutController implements Initializable {

    @FXML
    private TextField medicDos;
    @FXML
    private TextField NPatDos;
    @FXML
    private TextField ConsDos;
    @FXML
    private TextField MalDos;
    @FXML
    private TextField AlergDos;
    @FXML
    private TextField OpertDos;
    @FXML
    private Label warn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterDossier(ActionEvent event) throws IOException {
         if(medicDos.getText().isEmpty() || NPatDos.getText().isEmpty() || ConsDos.getText().isEmpty() || MalDos.getText().isEmpty() || AlergDos.getText().isEmpty()|| OpertDos.getText().isEmpty())
    {warn.setText("Remplissez tous les champs");
    }else{
           ServiceDossierpatient s = new ServiceDossierpatient ();
           DossierPatient r = new DossierPatient(medicDos.getText(), NPatDos.getText(), ConsDos.getText(), MalDos.getText(), AlergDos.getText(), OpertDos.getText());
           System.out.println(r);
           s.ajouter(r);
           JOptionPane.showMessageDialog(null,"DossierPatient  ajouté");
                 

   
       
       Parent root = FXMLLoader.load(getClass().getResource("../gui/DossierAffichage.fxml")) ;
            Scene rcScene= new Scene(root);	
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
               }
    }}

