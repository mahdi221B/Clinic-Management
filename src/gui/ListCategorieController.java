/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Categorie;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class ListCategorieController implements Initializable {

    @FXML
    private AnchorPane ListCategorie;
    @FXML
    private TableView<Categorie> TCatego;
    @FXML
    private TableColumn<Categorie, String> Cnom;

    @FXML
    private Label warning;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieService cs = new CategorieService();
        Cnom.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nom_categorie"));
        ObservableList<Categorie> list = cs.getAll();
        TCatego.setItems(list);
    }    


    @FXML
    private void Modifier(ActionEvent event) throws IOException {
     try {
        Categorie C = TCatego.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/FmodifierCategorie.fxml"));
        Parent root =loader.load();
        FmodifierCategorieController dpc = loader.getController();
        dpc.init(C);
        
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        }catch(Exception ex) {
	warning.setText("Selectionner une Categorie");
	}
    }
    

    @FXML
    private void Delete(ActionEvent event) throws IOException {
        try{
    Categorie C = TCatego.getSelectionModel().getSelectedItem();
    CategorieService cs = new CategorieService();
    cs.delete(new Categorie(C.getId_categorie()));
    Notifications.create().title("NOTIFICATIONS")
                    .text("Catégorie supprimer avec succès")
                    .showInformation();
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ListCategorie.fxml")) ;
    Scene rcScene= new Scene(root);
    Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    window.setScene(rcScene);
    window.show();
    }catch(Exception ex) {
	warning.setText("Selectionner une Categorie");
        }   
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/FajouterCategorie.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
            }catch(IOException ex) {
            
            }  
    }

    @FXML
    private void Exit(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/ModiferEvent.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
}
