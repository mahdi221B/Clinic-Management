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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.userservice;

/**
 * FXML Controller class
 *
 * @author ce pc
 */
public class ModifieruserFXMLController implements Initializable {

    @FXML
    private TextField mu_nom;
    @FXML
    private TextField mu_prenom;
    @FXML
    private TextField mu_sexe;
    @FXML
    private TextField mu_cin;
    @FXML
    private TextField mu_numtel;
    @FXML
    private TextField mu_motpass;
    @FXML
    private TextField mu_role;
    @FXML
    private TextField mu_adress;
    @FXML
    private Button mu_modif;
    @FXML
    private Button mu_exit;
    
    
    private userservice us; 
    private int ID;
    @FXML
    private TextField mu_Id_user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        us = new userservice();
        
        
        // TODO
    }  
    
    
    public void init(user u) {
        ID = u.getId_user();
        mu_Id_user.setText(Integer.toString(u.getId_user()));
       // mu_nom.setText(u.getId_user());
        mu_nom.setText(u.getNom());
        mu_prenom.setText(u.getPrenom());
        mu_sexe.setText(u.getSexe());
        mu_numtel.setText(Integer.toString(u.getNum_tel()));
        mu_cin.setText(Integer.toString(u.getCIN()));
        mu_motpass.setText(u.getMot_passe());
        
        mu_role.setText(u.getRole());
        mu_adress.setText(u.getAdresse());
        
        
    }  
    
    
    

    @FXML
    private void modifier_user(ActionEvent event) {
        user u = new user();
        if(mu_Id_user.getText().isEmpty()){
            System.out.println("id user vide !!");
            JOptionPane.showMessageDialog(null,"id user vide !!");
        }
        
        else if(mu_nom.getText().isEmpty() ) {
            System.out.println("nom vide !!");
            JOptionPane.showMessageDialog(null,"nom vide !!");
        }else if(mu_prenom.getText().isEmpty()) {
         System.out.println("prenom vide !!");
         JOptionPane.showMessageDialog(null,"prenom vide !!");
        }
        else if(mu_sexe.getText().isEmpty()) {System.out.println("sexe vide !!");
        JOptionPane.showMessageDialog(null,"sexe vide !!");}
        else if(mu_numtel.getText().isEmpty()) {System.out.println("num tel vide !!");
        JOptionPane.showMessageDialog(null,"num tel vide !!");}
        else if(mu_cin.getText().isEmpty()) {
            System.out.println("cin vide !!");
        JOptionPane.showMessageDialog(null,"cin vide !!");}
        else if(mu_motpass.getText().isEmpty()) {System.out.println("mot de passe vide !!");
        JOptionPane.showMessageDialog(null,"mot de passe vide !!");}
        else if(mu_role.getText().isEmpty()) {System.out.println("role vide !!");
        JOptionPane.showMessageDialog(null,"role vide !!");}
        else if (mu_adress.getText().isEmpty()) {System.out.println("adresse vide !!");
        JOptionPane.showMessageDialog(null,"adresse vide !!");
                }
        else {       
        
        
        
        
        
        
        
        
        us.modifier(new user(ID,mu_nom.getText(),mu_prenom.getText(),mu_sexe.getText(),Integer.parseInt(mu_numtel.getText()),Integer.parseInt(mu_cin.getText()),mu_motpass.getText(),mu_role.getText(),mu_adress.getText()));
        
         JOptionPane.showMessageDialog(null,"user modifiée");
        }
    }

    @FXML
    private void exitmodif(ActionEvent event) throws IOException {
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/PageuserFXML.fxml"));
            Parent root =loader.load();
            mu_adress.getScene().setRoot(root);
    }

    
    
}
