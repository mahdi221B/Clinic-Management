/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.articles;
import entities.commande;
import java.io.File;
import java.io.FileInputStream;
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
import java.io.InputStream ;
import java.io.InputStreamReader;
import java.sql.SQLException;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    @FXML
    private TableColumn<commande, Integer> QteC;
    

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
        QteC.setCellValueFactory(new PropertyValueFactory<commande,Integer>("QteC")) ;
     
        ObservableList<commande> listcmd = cs.getallcommandes();
        detaillecommande.setItems(listcmd) ;
    }    

    @FXML
    private void Ajoutercommande(ActionEvent event) throws IOException {
 FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajoutcommande2.fxml"));
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
    
    
    /////////////////////////////
    


    @FXML
    private void export(ActionEvent event) throws SQLException, IOException {
    
    commande_services cs = new commande_services();
   }
    }
