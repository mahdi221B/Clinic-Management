/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entitiesEx.Medecin;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import servicesEx.ServiceMedecin;

/**
 * FXML Controller class
 *
 * @author acila
 */
public class AffichageMedecinController implements Initializable {

    
    @FXML
    private TableColumn<Medecin, String> colnomprenomm;
    @FXML
    private TableColumn<Medecin, String> coladrm;
    @FXML
    private TableView<Medecin> tablemedecin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceMedecin s = new ServiceMedecin();
        colnomprenomm.setCellValueFactory(new PropertyValueFactory<Medecin, String>("nomprenomm"));
        coladrm.setCellValueFactory(new PropertyValueFactory<Medecin, String>("adrm"));
        ObservableList<Medecin> list = s.getAll();
        tablemedecin.setItems(list);
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjoutMedecin.fxml"));
        Parent root =loader.load();
        tablemedecin.getScene().setRoot(root);
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierMedecin.fxml"));
        Parent root =loader.load();
        tablemedecin.getScene().setRoot(root);
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        Medecin E = tablemedecin.getSelectionModel().getSelectedItem();
        ServiceMedecin s = new ServiceMedecin();
        s.supprimer(new Medecin(E.getIdMedecinm()));
        JOptionPane.showMessageDialog(null,"Medecin supprimée");

        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageMedecin.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void exitH(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
}
