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
public class ModifierarticlesController implements Initializable {

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
  private int id;
    @FXML
    private Label warning;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
 public void init(articles a) {
        id = a.getId_articles();
        nom.setText(a.getNom_articles());
        Qte.setText( Integer.toString(a.getQte()) );
        description.setText(a.getDescription());
        //type_article.setText(a.getType());
       //aquidestine.setText(a.getA_qui_destiné());
     
    }          

    @FXML
    private void updatearticles(ActionEvent event) throws IOException {
        
        if(nom.getText().isEmpty() || Qte.getText().isEmpty() || description.getText().isEmpty() )
    {warning.setText("Remplissez tous les champs");
    } else {
        articels_services as = new articels_services();
    as.updatearticles(new articles(id,nom.getText(), Integer.parseInt(Qte.getText()) , description.getText()  ));
        JOptionPane.showMessageDialog(null,"articles modifiée");
        Parent root = FXMLLoader.load(getClass().getResource("../gui/detaillearticles.fxml")) ;
     Scene rcScene= new Scene(root);
    	
  	Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }
    }
}
