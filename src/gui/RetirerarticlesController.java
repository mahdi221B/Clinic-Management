/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.articles;
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
import services.articels_services;

/**
 * FXML Controller class
 *
 * @author miled
 */
public class RetirerarticlesController implements Initializable {

    private int id;
    @FXML
    private Label warning;
    @FXML
    private TextField Qte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void init(articles a){
      int qt = a.getQte();

    id = a.getId_articles();
        Qte.setText( Integer.toString(a.getQte()) );
    }
    @FXML
    private void retirerarticles(ActionEvent event ) throws IOException {
     
        
        articels_services as = new articels_services();
            // articles a  = retirerarticels.getSelectionModel().getSelectedItem();

    as.retirerarticles(id,(Integer.parseInt(Qte.getText())));
        JOptionPane.showMessageDialog(null,"articles modifiée");
        Parent root = FXMLLoader.load(getClass().getResource("../gui/detaillearticles.fxml")) ;
     Scene rcScene= new Scene(root);
    	
  	Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }
    }   



   

   
      

