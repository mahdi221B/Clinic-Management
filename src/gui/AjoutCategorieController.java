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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.BlogService;
import service.CategorieService;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class AjoutCategorieController implements Initializable {

    @FXML
    private TextField tfText;
    @FXML
    private DatePicker tfDate_c;
    @FXML
    private TextField tfId_Crea;
    @FXML
    private Label warning;
    @FXML
    private Label warning2;
    @FXML
    private Label warning3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCategorie(ActionEvent categorie) throws IOException {
     //    if(tfText.getText().isEmpty() || tfDate_c.getText().isEmpty() || tfId_Crea.getText().isEmpty())
    {warning.setText("Remplissez tous les champs");
    warning2.setText("Remplissez tous les champs");
    warning3.setText("Remplissez tous les champs");
   // }else{
        try {
            System.out.println(tfText.getText());
            try {
           // System.out.println(Integer.parseInt(tfDate_c.()));
                 try{
                     System.out.println(Integer.parseInt(tfId_Crea.getText()));
        
        CategorieService s = new CategorieService();
       s.add(new Categorie(tfText.getText(),tfDate_c.getValue().toString(),Integer.parseInt(tfId_Crea.getText())));
        Notifications.create().title("Alert")
                    .text("categorie ajouté")
                    .showInformation();
    
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCategorie.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)categorie.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
         
         }catch(Exception e){
                 warning2.setText("Doit etre de type String");
                 }
            } catch(Exception e){
                 warning.setText("Doit etre de type entier");
                 
                }
                    }catch(Exception e){
         warning.setText("Doit etre de type entier");
        }
        
        }
    }

    @FXML
    private void exit(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCategorie.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    

    
}
   

  
    

