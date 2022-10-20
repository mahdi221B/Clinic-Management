/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Evenement;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.EvenementService;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class ModiferEventController implements Initializable {

    @FXML
    private TableView<Evenement> TEvent;
    @FXML
    private TableColumn<Evenement, String> CTitre;
    @FXML
    private TableColumn<Evenement, String> CDesc;
    @FXML
    private TableColumn<Evenement, String> CLieu;
    @FXML
    private TableColumn<Evenement, String> COrga;
    @FXML
    private TableColumn<Evenement, String> CEmail;
    @FXML
    private TableColumn<Evenement, Integer> CNum;
    @FXML
    private TableColumn<Evenement, Integer> CMont;
    @FXML
    private TableColumn<Evenement, String> CDeb;
    @FXML
    private TableColumn<Evenement, String> CFin;
    @FXML
    private Label warning;
    @FXML
    private AnchorPane ap;
    @FXML
    private BorderPane bp;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EvenementService s = new EvenementService();
        CTitre.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Titre"));
        CDesc.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Description"));
        CLieu.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Lieu"));
        COrga.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Nom_organisateur"));
        CEmail.setCellValueFactory(new PropertyValueFactory<Evenement, String>("email_organisateu"));
        CMont.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("montant_recolte"));
        CNum.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("Phone_organisateur"));
        CDeb.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Date_debut"));
        CFin.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Date_fin"));
        ObservableList<Evenement> list = s.getAll();
        TEvent.setItems(list);
    }    

    @FXML
    private void Modifier(ActionEvent event) throws IOException { 
        try {
        Evenement E = TEvent.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
        //Change the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Fmodifier.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        FmodifierController dpc = loader.getController();
        dpc.init(E);
        //get the new scene
        //tfTitre.getScene().setRoot(root);
        //Initializer les donnees de formateur
        
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        }catch(Exception ex) {
	warning.setText("Selectionner un Evenement");
        
        
	}
    }

    @FXML
    private void Delete(ActionEvent event) throws IOException {
        try{
    Evenement E = TEvent.getSelectionModel().getSelectedItem();
    EvenementService s = new EvenementService();
    s.delete(new Evenement(E.getId_evenement()));
    JOptionPane.showMessageDialog(null,"Evenement supprimer");
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ModiferEvent.fxml")) ;
    Scene rcScene= new Scene(root);
    	
    Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    window.setScene(rcScene);
    window.show();
    }catch(Exception ex) {
	warning.setText("Selectionner un Evenement");
        }
    }

    @FXML
    private void Ajouter(ActionEvent event) {
     try {
        //Change the scene
        Parent root = FXMLLoader.load(getClass().getResource("../gui/Fajouter.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        
        }catch(Exception ex) {
	
	}   
    }

    @FXML
    private void categorie(MouseEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    private void evet(MouseEvent event) throws IOException {
        loadPage("ListCategorie");
    }

    @FXML
    private void donation(MouseEvent event) throws IOException {
        loadPage("ListSponsor");
    }

    private void loadPage (String page) throws IOException {
     Parent root = null;
     root = FXMLLoader.load(getClass().getResource(page+".fxml")) ;
     bp.setCenter(root);
    }
    
}


