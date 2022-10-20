/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.Consultation;
import VisiteEntities.RendezVous;
import VisiteServices.ServiceConsultation;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ConsultationAjoutController implements Initializable {

    @FXML
    private TextField nomedco;
    @FXML
    private TextField nompatco;
    @FXML
    private TextField dateco;
    @FXML
    private TextArea listexam;
    @FXML
    private TextArea listmedic;
    @FXML
    private TextArea trait;
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
    private void ajouter_consult(ActionEvent event) throws IOException {
    
    
  if(nomedco.getText().isEmpty() || nompatco.getText().isEmpty() || dateco.getText().isEmpty() || listexam.getText().isEmpty() || listmedic.getText().isEmpty()|| trait.getText().isEmpty())
    {warn.setText("Remplissez tous les champs");
    }else{
           ServiceConsultation s = new ServiceConsultation ();
           Consultation r = new Consultation(nomedco.getText(), nompatco.getText(), dateco.getText(), listexam.getText(), listmedic.getText(), trait.getText());
           System.out.println(r);
           s.ajouter(r);
           JOptionPane.showMessageDialog(null,"Consultation  ajouté");
                 
       
       Parent root = FXMLLoader.load(getClass().getResource("../gui/ConsultationAffichage.fxml")) ;
            Scene rcScene= new Scene(root);	
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
               }
    }}