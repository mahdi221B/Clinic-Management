/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.articles;
import entites.commande;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.articels_services;
import services.commande_services;

/**
 * FXML Controller class
 *
 * @author miled
 */
public class DetaillecommandeController implements Initializable {

    @FXML
    private TableView<commande> detaillecommande;
    @FXML
    private TableColumn<commande,String> status;
    @FXML
    private TableColumn<commande,Date> date_ajout;
    @FXML
    private TableColumn<commande,Date> date_cloture;
    @FXML
    private TableColumn<commande, String> motif_cloture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           commande_services cs = new commande_services();
        
        status.setCellValueFactory(new PropertyValueFactory<commande,String>("status")) ;
        date_ajout.setCellValueFactory(new PropertyValueFactory<commande,Date>("date_ajout")) ;
        date_cloture.setCellValueFactory(new PropertyValueFactory<commande,Date>("date_cloture")) ;
        motif_cloture.setCellValueFactory(new PropertyValueFactory<commande,String>("motif_cloture")) ;
             ObservableList<commande> listcmd = cs.getallcommandes();
        detaillecommande.setItems(listcmd) ;
    }    

    @FXML
    private void Ajoutercommande(ActionEvent event) throws IOException {
 FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajoutcommande.fxml"));
            Parent root =loader.load();
            //Accessing the destined controller
            //get the new scene
            detaillecommande.getScene().setRoot(root);
    }

    @FXML
    private void updatecoamande(ActionEvent event) {
    }

    @FXML
    private void Supprimercommande(ActionEvent event) throws IOException {
        commande c  = detaillecommande.getSelectionModel().getSelectedItem();
        commande_services cs = new commande_services();
    cs.Supprimercommande(new commande (c.getId_commande() ));
       JOptionPane.showMessageDialog(null,"articels supprime");
       
       
         Parent root = FXMLLoader.load(getClass().getResource("../gui/detaillecommande.fxml")) ;
     Scene rcScene= new Scene(root);
    	
  	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
        
    }
    
}
