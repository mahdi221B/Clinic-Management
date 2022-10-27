/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Categorie;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class FmodifierCategorieController implements Initializable {

    @FXML
    private TextField tfNomCat;
    private int ID;
    @FXML
    private Label warning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void init(Categorie C) {
        ID = C.getId_categorie();
        tfNomCat.setText(C.getNom_categorie());
    } 
 
    @FXML
    private void Exit(MouseEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ListCategorie.fxml")) ;
    Scene rcScene= new Scene(root);
    Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    window.setScene(rcScene);
    window.show();
    }

    @FXML
    private void Modifercategorie(ActionEvent event) throws IOException {
         if(tfNomCat.getText().isEmpty())
    {warning.setText("Remplissez tous les champs");
    }else{
        CategorieService cs = new CategorieService();
        cs.update(new Categorie(ID,tfNomCat.getText()));
        Notifications.create().title("NOTIFICATIONS")
                    .text("Catégorie modifiée avec succès")
                    .showInformation();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("../gui/ListCategorie.fxml")) ;
    	Scene rcScene= new Scene(root);
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        }
    }
    
}
