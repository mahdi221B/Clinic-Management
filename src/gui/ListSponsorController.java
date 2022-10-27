/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Sponsor;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import services.SponsorService;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class ListSponsorController implements Initializable {

    @FXML
    private AnchorPane ListSponsor;
    @FXML
    private TableView<Sponsor> TSponsor;
    @FXML
    private TableColumn<Sponsor, String> CNom;
    @FXML
    private TableColumn<Sponsor, String> CMail;
    @FXML
    private TableColumn<Sponsor, Integer> CNumero;
    @FXML
    private TableColumn<Sponsor, Integer> CMontant;
    @FXML
    private TableColumn<Sponsor, String> CType;
    @FXML
    private Label warning;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SponsorService ss = new SponsorService();
        CNom.setCellValueFactory(new PropertyValueFactory<Sponsor, String>("nom_societe"));
        CMail.setCellValueFactory(new PropertyValueFactory<Sponsor, String>("email_societe"));
        CType.setCellValueFactory(new PropertyValueFactory<Sponsor, String>("type_sponsoring"));
        CNumero.setCellValueFactory(new PropertyValueFactory<Sponsor, Integer>("phone_societe"));
        CMontant.setCellValueFactory(new PropertyValueFactory<Sponsor, Integer>("montant_donnee"));
        ObservableList<Sponsor> list = ss.getAll();
        TSponsor.setItems(list);
    }    


    @FXML
    private void Modifier(ActionEvent event) throws IOException {
     try {
        Sponsor S = TSponsor.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/FmodifierSponsor.fxml"));
        Parent root =loader.load();
        FmodifierSponsorController dpc = loader.getController();
        dpc.init(S);
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
        try {
        Sponsor S = TSponsor.getSelectionModel().getSelectedItem();
        SponsorService ss = new SponsorService();
        ss.delete(new Sponsor(S.getId_sponsor()));
        Notifications.create().title("NOTIFICATIONS")
                    .text("Sponsor supprimer avec succès")
                    .showInformation();

        Parent root = FXMLLoader.load(getClass().getResource("../gui/ListSponsor.fxml")) ;
        Scene rcScene= new Scene(root);

        Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
        window.setScene(rcScene);
        window.show();
        }catch(Exception ex) {
            warning.setText("Selectionner un Sponsor");
        }  
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        try {
            //Change the scene
            Parent root = FXMLLoader.load(getClass().getResource("../gui/FajouterSponsor.fxml")) ;
            Scene rcScene= new Scene(root);
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
            }catch(IOException ex) {
            }  
    }
    

    
    @FXML
    private void Exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/ModiferEvent.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
    
    
}
