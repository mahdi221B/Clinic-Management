/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import static com.sun.media.jfxmediaimpl.MediaUtils.warning;
import entites.articles;
import java.io.IOException;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import services.articels_services;


/**
 * FXML Controller class
 *
 * @author miled
 */
public class AjoutarticlesController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField Qte;
    @FXML
    private TextField description;
    @FXML
    private TextField type_article;
    @FXML
    private TextField aquidestine;
    @FXML
    private Label warning;
    
    
  //  ObservableList typelist = FXCollections.observableArrayList("medicament","equipement");
//ObservableList destine_lyste = FXCollections.observableArrayList("enfant","adulte","tous");
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
        //type_article.getItems().setAll(type_articles.values()) ;
         // aquidestine.getItems().setAll(destine.values());
         
         //type_article.setItems(typelist);
         //aquidestine.setItems(destine_lyste);

    

    }

    

     //c type_articles ta  = type_article.getValue();
       //  public destine dest = aquidestine.getValue();

               @FXML
    private void ajoutearticles(ActionEvent event) {
            if(nom.getText().isEmpty() || Qte.getText().isEmpty() || description.getText().isEmpty() || type_article.getText().isEmpty() ||  aquidestine.getText().isEmpty() )
    {warning.setText("Remplissez tous les champs");
    } else {
           articels_services as = new articels_services();
        as.Ajoutrarticle(new articles(nom.getText(), Integer.parseInt(Qte.getText()) , description.getText() ,type_article.getText() , aquidestine.getText() )) ;
        //System.out.println((type_article.getSelectionModel().getSelectedItem()).getClass() );
       JOptionPane.showMessageDialog(null,"articles ajoutée");
        Parent root = null;
               
  Scene rcScene= new Scene(root);
    	
  	Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }}

    @FXML
    private void exit(ActionEvent event) throws IOException {
     
        Parent root = FXMLLoader.load(getClass().getResource("../gui/detaillearticles.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    }

    
  
    
   
