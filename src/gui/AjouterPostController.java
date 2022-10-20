/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Blog;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.BlogService;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class AjouterPostController implements Initializable {

    @FXML
    private TextField tfSujet;
    @FXML
    private TextField tfDescription;
    @FXML
    private DatePicker tfDate;
    @FXML
    private TextField tfReview;
    @FXML
    private TextField tfUser_Id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterPost(ActionEvent post) throws IOException {
        
         BlogService s = new BlogService();
   s.add(new Blog(Integer.parseInt(tfUser_Id.getText()),tfSujet.getText(),tfDescription.getText(),tfReview.getText(),tfDate.getValue().toString()));
    JOptionPane.showMessageDialog(null,"Post ajoutée");
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailPost.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)post.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
 
   }
    
    
 
    

    @FXML
    private void Exit(MouseEvent post) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailPost.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)post.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
   
    
    
    
       
    }

