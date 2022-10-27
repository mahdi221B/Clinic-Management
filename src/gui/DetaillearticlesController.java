/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.articles;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.articels_services;
import java.io.IOException;
import javafx.collections.ObservableList;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author miled
 */
public class DetaillearticlesController implements Initializable {

    @FXML
    private TableColumn< articles,String> nom;
    @FXML
    private TableColumn< articles,Integer> qte;
    @FXML
    private TableColumn< articles,String> description;
    @FXML
    private TableColumn< articles,String> type;
    @FXML
    private TableColumn<articles,String> a_qui_destiné;
    @FXML
    private TableView<articles> tarticles;
    private TextField recherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        articels_services as = new articels_services();
        
        nom.setCellValueFactory(new PropertyValueFactory<articles,String>("nom")) ;
        qte.setCellValueFactory(new PropertyValueFactory<articles,Integer>("qte")) ;
        description.setCellValueFactory(new PropertyValueFactory<articles,String>("description")) ;
        type.setCellValueFactory(new PropertyValueFactory<articles,String>("type")) ;
        a_qui_destiné.setCellValueFactory(new PropertyValueFactory<articles,String>("a_qui_destiné")) ;
             ObservableList<articles> listart = as.getallarticles();
        tarticles.setItems(listart) ;
// TODO
    }    

    @FXML
    private void Ajoutrarticle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajoutarticles.fxml"));
            Parent root =loader.load();
            //Accessing the destined controller
            //get the new scene
            tarticles.getScene().setRoot(root);
            
    	
        } catch (IOException ex) {
            Logger.getLogger(DetaillearticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updatearticles(ActionEvent articles) throws IOException {
     
           
            articles a = tarticles.getSelectionModel().getSelectedItem();
            //Change the scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/modifierarticles.fxml"));
            Parent root =loader.load();
            //Accessing the destined controller
            //get the new scene
            ModifierarticlesController dpc = loader.getController();

            tarticles.getScene().setRoot(root);
            //Initializer les donnees de formateur
            dpc.init(a);
       
       
            
        
    }
    private List recherche(ActionEvent event) throws SQLException {
                articels_services as = new articels_services();
                List<articles>  data =   as.recherche(recherche.getText());
        nom.setCellValueFactory(new PropertyValueFactory<articles,String>("nom")) ;
        qte.setCellValueFactory(new PropertyValueFactory<articles,Integer>("qte")) ;
        description.setCellValueFactory(new PropertyValueFactory<articles,String>("description")) ;
        type.setCellValueFactory(new PropertyValueFactory<articles,String>("type")) ;
        a_qui_destiné.setCellValueFactory(new PropertyValueFactory<articles,String>("a_qui_destiné")) ;
             ObservableList<articles> listart = as.getallarticles();
        tarticles.setItems(listart) ;
                return data;
                
        
    }

    @FXML
    private void Supprimerarticle(ActionEvent event) throws IOException {
    articles ar  = tarticles.getSelectionModel().getSelectedItem();
      articels_services as = new articels_services();
    as.Supprimerarticle(new articles(ar.getId_articles()));
       JOptionPane.showMessageDialog(null,"articels supprime");
       
       
   Parent root = FXMLLoader.load(getClass().getResource("../gui/detaillearticles.fxml")) ;
     Scene rcScene= new Scene(root);
    	
  	Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();     
       
  
           
    	
  	             
    }

    @FXML
    private void Ajoutercommande(ActionEvent event) {
     articles a = tarticles.getSelectionModel().getSelectedItem() ;
     try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajoutcommande2.fxml"));
            Parent root =loader.load();
            //Accessing the destined controller
            //get the new scene
            tarticles.getScene().setRoot(root);
            
    	
        } catch (IOException ex) {
            Logger.getLogger(DetaillearticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void retirerarticle(ActionEvent event) throws IOException {
               articles a = tarticles.getSelectionModel().getSelectedItem() ;//Avoir les donnes de formateur sélectionnée
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/retirerarticles.fxml"));
            Parent root =loader.load();
                  RetirerarticlesController dpc = loader.getController();
                 tarticles.getScene().setRoot(root);
                             dpc.init(a);




    }

  

 

  
    }

    
    

