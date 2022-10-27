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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import service.BlogService;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class DetailCategorieController implements Initializable {

 
    @FXML
    private TableView<Categorie> tvCategorie;
    @FXML
    private TableColumn<Categorie, String> collText_C;
    @FXML
    private TableColumn<Categorie, String> collDate_C;
    @FXML
    private TableColumn<Categorie, Integer> collId_C;
    @FXML
    private Label controleC;
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieService s = new CategorieService();
        collText_C.setCellValueFactory(new PropertyValueFactory<Categorie, String>("Text_Categorie"));
        collDate_C.setCellValueFactory(new PropertyValueFactory<Categorie, String>("Date_Creation_Categorie"));
        collId_C.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("Id_Createur_Categorie"));
        
        ObservableList<Categorie> list = s.getAll();
        tvCategorie.setItems(list);
    }    

   
    @FXML
    private void AjouterC(ActionEvent categorie)throws IOException {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjoutCategorie.fxml"));
            Parent root = loader.load();
          
            tvCategorie.getScene().setRoot(root);

        } catch (IOException ex) {
            controleC.setText("Selectionner une categorie");
        }

    }
    

    @FXML
    private void SupprimerC(ActionEvent categorie) throws IOException {
        
        Categorie C = tvCategorie.getSelectionModel().getSelectedItem();
        CategorieService s = new CategorieService();
        s.delete(new Categorie(C.getId_Categorie()));
        Notifications.create().title("Alert")
                    .text("Categorie supprimé")
                    .showInformation();
        Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCategorie.fxml"));

        Scene rcScene = new Scene(root);

        Stage window = (Stage) ((Node) categorie.getSource()).getScene().getWindow();
        window.setScene(rcScene);
        window.show();
        
    }

    @FXML
    private void ModifierC(ActionEvent categorie) throws IOException{
        
        try {
            if (tvCategorie.getSelectionModel().getSelectedItem() != null) 
                 {
                Categorie C = tvCategorie.getSelectionModel().getSelectedItem();
              
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierCategorie.fxml"));
                Parent root = loader.load();
                
                ModifierCategorieController dpc = loader.getController();
                //get the new scene
                controleC.getScene().setRoot(root);
               
                dpc.init(C);
            }
        } catch (IOException ex) {
            
        
    }
    
    
    }

    @FXML
    private void Exit(MouseEvent event) {
    }

    @FXML
    private void back1(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailPost.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }



    }


 

    

