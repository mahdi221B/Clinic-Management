/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.DossierPatient;
import VisiteEntities.RendezVous;
import VisiteServices.ServiceDossierpatient;
import VisiteServices.ServiceRendezvous;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DossierAffichageController implements Initializable {

    @FXML
    private TableView<DossierPatient> tvDosp;
    @FXML
    private TableColumn<DossierPatient, String> npa;
    @FXML
    private TableColumn<DossierPatient, String> mlda;
    @FXML
    private TableColumn<DossierPatient, String> medica;
    @FXML
    private TableColumn<DossierPatient, String> allrga;
    @FXML
    private TableColumn<DossierPatient, String> cslta;
    @FXML
    private TableColumn<DossierPatient, String> oprta;
    @FXML
    private Label warning;
    @FXML
    private TextField tfTitre;
private ObservableList<DossierPatient> data ;
    @FXML
    private TextField tf1;
    @FXML
    private Label labelNBR;
    @FXML
    private ImageView image;
    @FXML
    private TextField url;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceDossierpatient s = new  ServiceDossierpatient();
        npa.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("nomP"));
        mlda.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("maladies"));
        medica.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("Medicaments"));
        allrga.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("AllergieMedicaments"));
        cslta.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("Consultations"));
        oprta.setCellValueFactory(new PropertyValueFactory<DossierPatient, String>("detailsOperation"));
        ObservableList<DossierPatient> list = (ObservableList<DossierPatient>) s.afficher();
        tvDosp.setItems(list);
    }    

    @FXML
    private void ajouter(ActionEvent event) {
         try {
        //Change the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/DossierAjout.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        //get the new scene
        tfTitre.getScene().setRoot(root);
        
        }catch(IOException ex) {
	warning.setText("Selectionner un Dossier");
	}   
    }

    @FXML
    private void modifier(ActionEvent event) {
         try {
        DossierPatient r = tvDosp.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
        //Change the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gui/DossierModif.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        DossierModifController dpc = loader.getController();
        //get the new scene
        tfTitre.getScene().setRoot(root);
        //Initializer les donnees de formateur
        dpc.init(r);
        }catch(IOException ex) {
	warning.setText("Selectionner un Dossier");
        
        
	}
        
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
         DossierPatient R = tvDosp.getSelectionModel().getSelectedItem();
    ServiceDossierpatient s = new  ServiceDossierpatient();
    s.supprimer(new DossierPatient(R.getIdP()));
    JOptionPane.showMessageDialog(null,"Dossier supprimé");
    Parent root = FXMLLoader.load(getClass().getResource("../gui/DossierAffichage.fxml")) ;
    	Scene rcScene= new Scene(root);
        
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/acceuil.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void chercherDos(ActionEvent event) throws IOException {
          ServiceDossierpatient f = new  ServiceDossierpatient();
           Parent p1;   
   
         
        try {
            DossierPatient p = new DossierPatient();
           
           ArrayList<DossierPatient> ps = f.afficheDossier(tf1.getText());   
                   
            data = FXCollections.observableArrayList();
         
            
            
            
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
            a1.setTitle("Fiche trouvée");
            a1.setContentText(ps.toString());
            a1.show();
            p1 = FXMLLoader.load(getClass().getResource("../gui/DossierAffichage.fxml"));
            
            Scene test1 = new Scene(p1);
            
            Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            App1.setScene(test1);
            App1.show();
          
         
            
        }
     catch(IOException ex ){
  
         Alert alert = new Alert(Alert.AlertType.WARNING);
            
            alert.setTitle("No Name found");
            alert.setHeaderText("Nom du patient n'existe pas ");
            alert.setContentText("s'il vous plais cherchez avec un autre nom ou bien ecrivez un nouveau dossier avec ce nom ");

            alert.showAndWait();
        
        
    }
    
}

    @FXML
    private void importerimg(ActionEvent event) {
        
  String a=url.getText();
        System.out.println(a);

            Image image = new Image(a);
            if (image.isError()) {
                System.out.println("Error loading image from "+url);
                
                // image.getException().printStackTrace();
            } else {
                System.out.println("Successfully loaded image from " + url);
                image.setImage(image);
            }
               
    }
    }

