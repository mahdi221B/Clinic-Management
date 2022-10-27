/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.user;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.userservice;

/**
 * FXML Controller class
 *
 * @author ce pc
 */
public class AjouteruserFXMLController implements Initializable {

    @FXML
    private TextField tu_prenom;
    @FXML
    private TextField tu_nom;
    @FXML
    private TextField tu_sexe;
    @FXML
    private TextField tu_numtel;
    @FXML
    private TextField tu_cin;
    @FXML
    private TextField tu_motpass;
    @FXML
    private ComboBox tu_role;
    @FXML
    private TextField tu_adrs;
    @FXML
    private Button tu_ajouteruser;
    @FXML
    private Button tu_passrt;
    
    private userservice us; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        us = new userservice();
        ObservableList<String> list = FXCollections.observableArrayList("medecin","infirmier","admin","agent_de stock","secretaire");
        tu_role.setItems(list);
        
        // TODO
    }    

    @FXML
    private void ajouter_user(ActionEvent event) {
        
         user u = new user();
        
        
         if(tu_nom.getText().isEmpty() ) {
            System.out.println("nom vide !!");
            JOptionPane.showMessageDialog(null,"nom vide !!");
        }else if(tu_prenom.getText().isEmpty()) {
         System.out.println("prenom vide !!");
         JOptionPane.showMessageDialog(null,"prenom vide !!");
        }
        else if(tu_sexe.getText().isEmpty()) {System.out.println("sexe vide !!");
        JOptionPane.showMessageDialog(null,"sexe vide !!");}
        else if(tu_numtel.getText().isEmpty()) {System.out.println("num tel vide !!");
        JOptionPane.showMessageDialog(null,"num tel vide !!");}
        else if(tu_cin.getText().isEmpty()) {
            System.out.println("cin vide !!");
        JOptionPane.showMessageDialog(null,"cin vide !!");}
        else if(tu_motpass.getText().isEmpty()|| tu_motpass.getText().length()< 4 ) {System.out.println("mot de passe vide !!");
        JOptionPane.showMessageDialog(null,"mot de passe vide !!");}
       /* else if(tu_role.getText().isEmpty()) {System.out.println("role vide !!");
        JOptionPane.showMessageDialog(null,"role vide !!");}*/
        else if(tu_adrs.getText().isEmpty() || tu_adrs.getText().matches("\\\\w{3,}@\\\\S+")) 
        
        
        {System.out.println("adresse vide ou format non conforme !!");
        JOptionPane.showMessageDialog(null,"adresse vide ou format non conforme !!");
                }
        else {       
         
         
         
         
         
         
         
         
         u.setNom(tu_nom.getText());
          u.setPrenom(tu_prenom.getText());
          u.setSexe(tu_sexe.getText());
          u.setCIN(Integer.parseInt(tu_cin.getText()));
          u.setNum_tel(Integer.parseInt(tu_numtel.getText()));
           u.setMot_passe(tu_motpass.getText());
           u.setRole(tu_role.getSelectionModel().getSelectedItem().toString());
           u.setAdresse(tu_adrs.getText());
            
            us.ajouter(u);
             JOptionPane.showMessageDialog(null,"user ajoutée");
        }
        
    }

    @FXML
    private void pass_homme_exit(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/PageuserFXML.fxml"));
            
            Parent root =loader.load();
            tu_nom.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouteruserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void select(ActionEvent event) {
     String s = tu_role.getSelectionModel().getSelectedItem().toString();
     
        
        
    }
    
}
