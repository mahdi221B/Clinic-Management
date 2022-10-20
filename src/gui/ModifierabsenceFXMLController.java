/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.absence;
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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.absenceservice;

/**
 * FXML Controller class
 *
 * @author ce pc
 */
public class ModifierabsenceFXMLController implements Initializable {

    @FXML
    private TextField md_iduserab;
    @FXML
    private TextField md_nomab;
    @FXML
    private TextField md_prenomab;
    @FXML
    private TextField md_dateab;
    @FXML
    private TextField md_dureab;
    @FXML
    private TextField md_justtifab;
    @FXML
    private Button idmodif_ab;
    @FXML
    private Button id_annulermodifab;
    @FXML
    private TextField md_idabsence;
    
   
    private absenceservice as; 
    private int ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        as = new absenceservice();
       
        // TODO
    }    

    
    
    public void init(absence E) {
        ID = E.getId_absence();
        md_idabsence.setText(Integer.toString(E.getId_absence()));
        md_iduserab.setText(E.getId_user());
        md_nomab.setText(E.getNom());
        md_prenomab.setText(E.getPrenom());
        md_dateab.setText(E.getDate_absence());
        md_dureab.setText(E.getDuré_absence());
        md_justtifab.setText(E.getJustification());
        
    }  
    
    
    
    
    
    @FXML
    private void modifier_absence(ActionEvent event) {
        
       absence a = new absence();
      
       
       if(md_iduserab.getText().isEmpty() && md_idabsence.getText().isEmpty() ) {
            System.out.println("(id user ou id absence) vide !!");
            JOptionPane.showMessageDialog(null,"(id user ou id absence) vide !!");
        }else if(md_nomab.getText().isEmpty()) {
         System.out.println("nom vide !!");
         JOptionPane.showMessageDialog(null,"nom vide !!");
        }
        else if(md_prenomab.getText().isEmpty()) {System.out.println("prenom vide !!");
        JOptionPane.showMessageDialog(null,"prenom vide !!");}
        else if(md_dateab.getText().isEmpty()) {System.out.println("date vide !!");
        JOptionPane.showMessageDialog(null,"date vide !!");}
        else if(md_dureab.getText().isEmpty()) {System.out.println("dure vide !!");
        JOptionPane.showMessageDialog(null,"dure vide !!");}
        else if(md_justtifab.getText().isEmpty()) {System.out.println("justification vide !!");
        JOptionPane.showMessageDialog(null,"justification vide !!");}
        else{
       
       
     
     
     as.modifier(new absence(ID,md_iduserab.getText(),md_nomab.getText(),md_prenomab.getText(),md_dateab.getText(),md_dureab.getText(),md_justtifab.getText()));
      JOptionPane.showMessageDialog(null,"absence modifiée");
      
        }
      
      
      /*  a.setId_user(md_iduserab.getText());
         a.setNom(md_nomab.getText());
          a.setPrenom(md_prenomab.getText());
           a.setDate_absence(md_dateab.getText());
            a.setDuré_absence(md_dureab.getText());
             a.setJustification(md_justtifab.getText());
            
               a.Integer.parseInt(id.getText()
             
             
            as.modifier(a);
             JOptionPane.showMessageDialog(null,"absence modifier");*/
        
        
    }

    @FXML
    private void annuler_modifierab(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/PageabsenceFXML.fxml"));
            Parent root =loader.load();
            idmodif_ab.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ModifierabsenceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
