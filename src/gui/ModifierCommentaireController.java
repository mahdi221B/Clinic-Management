/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Categorie;
import entities.Commentaire;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.CategorieService;
import service.CommentaireService;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class ModifierCommentaireController implements Initializable {

    @FXML
    private TextField tfText_Comm;
    @FXML
    private TextField tfUser_Comm;
    @FXML
    private TextField tfId_Comm;
    
    private int IDComm;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
      
    }    
  public void init(Commentaire C) {
      IDComm = C.getId_Commentaire();
       tfText_Comm.setText(C.getText_Commentaire());
       tfUser_Comm.setText(Integer.toString(C.getUser_Id_Commentaire()));
       tfId_Comm.setText(Integer.toString(C.getId_Post_Commentaire()));
  }

    
    
    @FXML
    private void ModifierComm(ActionEvent commenaitre) throws IOException {
        
       CommentaireService s = new CommentaireService();
       s.update(new Commentaire(IDComm,tfText_Comm.getText(),Integer.parseInt(tfUser_Comm.getText()),Integer.parseInt(tfId_Comm.getText())));
       JOptionPane.showMessageDialog(null,"Commentaire modifiée");
       Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCommentaire.fxml"));

       Scene rcScene = new Scene(root);

       Stage window = (Stage) ((Node) commenaitre.getSource()).getScene().getWindow();
       window.setScene(rcScene);
       window.show();
        
        
        
    }

    @FXML
    private void ExitComm(MouseEvent commentaire) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCommentaire.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)commentaire.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
        
    }
    

   
  