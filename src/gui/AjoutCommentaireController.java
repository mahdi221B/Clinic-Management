/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import static com.sun.media.jfxmediaimpl.MediaUtils.warning;
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
import javafx.scene.control.Label;
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
public class AjoutCommentaireController implements Initializable {

    @FXML
    private TextField tfText_Comm;
    @FXML
    private TextField tfUser_Comm;
    @FXML
    private TextField tfId_Comm;
    @FXML
    private Label warning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCom(ActionEvent Commentaire) throws IOException {
       if(tfText_Comm.getText().isEmpty() || tfUser_Comm.getText().isEmpty() || tfId_Comm.getText().isEmpty())
    {warning.setText("Remplissez tous les champs");
    }else{
        try {
            System.out.println(Integer.parseInt(tfId_Comm.getText()));
            try {
            System.out.println(Integer.parseInt(tfUser_Comm.getText()));
                 
         CommentaireService s = new CommentaireService();
       s.add(new Commentaire(tfText_Comm.getText(),Integer.parseInt(tfUser_Comm.getText()),Integer.parseInt(tfId_Comm.getText())));
    JOptionPane.showMessageDialog(null,"Commentaire ajouté");
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCommentaire.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)Commentaire.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
                 }catch(Exception e){
                 warning.setText("Doit etre de type entier");
                }
                    }catch(Exception e){
         warning.setText("Doit etre de type entier");
        }
        }
    }
   
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
 
    
    
    
    @FXML
    private void ExitCom(MouseEvent commentaire) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCommentaire.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)commentaire.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
}
