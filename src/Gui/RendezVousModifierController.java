/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.RendezVous;
import VisiteServices.ServiceRendezvous;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class RendezVousModifierController implements Initializable {

    @FXML
    private TextField modifnomed;
    @FXML
    private TextField modifdat;
    @FXML
    private TextField modifheur;
    @FXML
    private TextField modifnompat;
    @FXML
    private TextArea modifcaus;
 private int ID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
     public void init(RendezVous r) {
        ID = r.getIdRv();
        modifnomed.setText(r.getNomMedecinRv());
        modifdat.setText(r.getDateRendezVous());
        modifheur.setText(r.getHeure());
        modifnompat.setText(r.getNomPatient());
        modifcaus.setText(r.getCause());
       
    }  
    
    
    

    @FXML
    private void modifier(ActionEvent event)throws IOException {
      ServiceRendezvous C = new ServiceRendezvous();
        C.modifier(new RendezVous(modifnomed.getText(), modifdat.getText(), modifheur.getText(), modifnompat.getText(), modifcaus.getText()));
        JOptionPane.showMessageDialog(null,"Rendezvous modifié");
              
       
    }

 
    
}
