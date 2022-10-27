/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.absence;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
//import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.absenceservice;

/**
 * FXML Controller class
 *
 * @author ce pc
 */
public class AjouterFXMLController implements Initializable {

    @FXML
    private TextField tf_iduserab;
    @FXML
    private TextField tf_justtifab;
    @FXML
    private TextField tf_dureab;
    @FXML
    private DatePicker tf_dateab;
    @FXML
    private TextField tf_prenomab;
    @FXML
    private TextField tf_nomab;
    @FXML
    private Button idajout_ab;
    @FXML
    private Button id_annulerajab;
    
    private absenceservice as; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        as = new absenceservice();
    }    

    @FXML  
    private void ajouter_absence(ActionEvent event) {
        if(tf_iduserab.getText().isEmpty() || tf_iduserab.getText().length()> 4 ) {
            System.out.println("id user vide !!");
            JOptionPane.showMessageDialog(null,"id user vide !!");
        }else if(tf_nomab.getText().isEmpty()) {
         System.out.println("nom vide !!");
         JOptionPane.showMessageDialog(null,"nom vide !!");
        }
        else if(tf_prenomab.getText().isEmpty()) {System.out.println("prenom vide !!");
        JOptionPane.showMessageDialog(null,"prenom vide !!");}
        else if(tf_dateab.getValue().toString().isEmpty()) {System.out.println("date vide !!");
        JOptionPane.showMessageDialog(null,"date vide !!");}
        else if(tf_dureab.getText().isEmpty()) {System.out.println("dure vide !!");
        JOptionPane.showMessageDialog(null,"dure vide !!");}
        else if(tf_justtifab.getText().isEmpty()) {System.out.println("justification vide !!");
        JOptionPane.showMessageDialog(null,"justification vide !!");}
        else{
        
        absence a = new absence();
        a.setId_user(tf_iduserab.getText());
         a.setNom(tf_nomab.getText());
          a.setPrenom(tf_prenomab.getText());
          
       //   LocalDate ld = tf_dateab.getValue();
          
          
          
          
            a.setDate_absence(tf_dateab.getValue().toString());
          
          
            a.setDuré_absence(tf_dureab.getText());
             a.setJustification(tf_justtifab.getText());
            as.ajouter(a);
             JOptionPane.showMessageDialog(null,"absence ajoutée");
        }
        
        
    }

    @FXML
    private void annuler_ajouterab(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/PageabsenceFXML.fxml"));
            Parent root =loader.load();
            tf_nomab.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
