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
public class ModifierPostController implements Initializable {
    
    @FXML
    private TextField tfSujet;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfReview;
    @FXML
    private TextField tfUser_Id;
    
    private int ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void init(Blog E) {
        
         
        ID = E.getId_Post();
       tfSujet.setText(E.getSujet_Post());
        tfDescription.setText(E.getDescription_Post());
        tfDate.setText(E.getDate_Post());
        tfReview.setText(E.getReview_Post());
        tfUser_Id.setText(Integer.toString(E.getUser_Id_Post()));
        
    }  

    @FXML
    private void ModifierPost(ActionEvent post) throws IOException{
        BlogService s = new BlogService();
       s.update(new Blog (ID,tfSujet.getText(),tfDescription.getText(),tfDate.getText(),tfReview.getText(),Integer.parseInt(tfUser_Id.getText())));
       JOptionPane.showMessageDialog(null,"Post modifiée");
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
