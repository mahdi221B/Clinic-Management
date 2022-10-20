/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Blog;
import entities.Categorie;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.BlogService;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class ModifierCategorieController implements Initializable {

    @FXML
    private TextField tfText;
    @FXML
    private TextField tfDate_c;
    @FXML
    private TextField tfId_Crea;
    
    private int IDC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    public void init(Categorie C) {
        
         
       IDC = C.getId_Categorie();
       tfText.setText(C.getText_Categorie());
       tfDate_c.setText(C.getDate_Creation_Categorie());
       tfId_Crea.setText(Integer.toString(C.getId_Createur_Categorie()));
        
    } 

    @FXML
    private void ModifierCat(ActionEvent categorie) throws IOException {
        CategorieService s = new CategorieService();
       s.update(new Categorie(IDC,tfText.getText(),tfDate_c.getText(),Integer.parseInt(tfId_Crea.getText())));
       JOptionPane.showMessageDialog(null,"Categorie modifiée");
     Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCategorie.fxml"));

        Scene rcScene = new Scene(root);

        Stage window = (Stage) ((Node) categorie.getSource()).getScene().getWindow();
        window.setScene(rcScene);
        window.show();
        
    }

    @FXML
    private void ExitC(ActionEvent categorie) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCategorie.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)categorie.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
}
