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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.userservice;

/**
 * FXML Controller class
 *
 * @author ce pc
 */
public class PageuserFXMLController implements Initializable {

    @FXML
    private TableColumn<user, String> tu_nom;
    @FXML
    private TableColumn<user, String> tu_prenom;
    @FXML
    private TableColumn<user, String> tu_sexe;
    @FXML
    private TableColumn<user, Integer> tu_numtel;
    @FXML
    private TableColumn<user, Integer> tu_cin;
    @FXML
    private TableColumn<user, String> tu_motpass;
    @FXML
    private TableColumn<user, String> tu_role;
    @FXML
    private TableColumn<user, String> tu_adrs;
    @FXML
    private Button id_ajoutuser;
    @FXML
    private Button id_suppuser;
    @FXML
    private Button id_modifuser;
    @FXML
    private TableView<user> treevuser;
    @FXML
    private Button exit_acu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        userservice us = new userservice();
        tu_nom.setCellValueFactory(new PropertyValueFactory<user, String>("nom"));
        tu_prenom.setCellValueFactory(new PropertyValueFactory<user, String>("prenom") );
        tu_sexe.setCellValueFactory(new PropertyValueFactory<user, String>("sexe") );
        tu_numtel.setCellValueFactory(new PropertyValueFactory<user, Integer>("num_tel") );
        tu_cin.setCellValueFactory(new PropertyValueFactory<user, Integer>("CIN") );
        
         tu_motpass.setCellValueFactory(new PropertyValueFactory<user, String>("mot_passe") );
          tu_role.setCellValueFactory(new PropertyValueFactory<user, String>("role") );
           tu_adrs.setCellValueFactory(new PropertyValueFactory<user, String>("adresse") );
        
        
        ObservableList<user> list = us.getAll();
        treevuser.setItems(list);
        
        
        
        
        
        // TODO
    }    


    @FXML
    private void supprimer_user(ActionEvent event) throws IOException {
        
        user  u = treevuser.getSelectionModel().getSelectedItem();
    userservice us = new userservice();
    us.Supprimeruser(new user(u.getId_user()));
    JOptionPane.showMessageDialog(null,"absence supprimé");
        
        
        Parent root = FXMLLoader.load(getClass().getResource("../gui/PageuserFXML.fxml"));
        Scene rcScene = new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rcScene);
        window.show();
        
        
        
        
        
    }

    @FXML
    private void modifier_user(ActionEvent event) throws IOException {
        user u = treevuser.getSelectionModel().getSelectedItem();
        
         //Change the scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifieruserFXML.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        ModifieruserFXMLController dpc = loader.getController();
        
        //get the new scene
            treevuser.getScene().setRoot(root);
        
        //Initializer les donnees de formateur
            dpc.init(u);
        
    }

    @FXML
    private void pass_ajouter_user(ActionEvent event) {
        
        
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjouteruserFXML.fxml"));
            Parent root =loader.load();
            treevuser.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(PageuserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void exit_acu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AccueilFXML.fxml"));
            Parent root =loader.load();
            treevuser.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(PageuserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
