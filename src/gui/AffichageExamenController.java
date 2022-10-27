/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entitiesEx.Examen;
import entitiesEx.Medecin;
import entitiesEx.Patient;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import servicesEx.ServiceExamen;
import servicesEx.ServiceMedecin;

/**
 * FXML Controller class
 *
 * @author acila
 */
public class AffichageExamenController implements Initializable {

    @FXML
    private TableView<Examen> texamen;
    @FXML
    private TableColumn<Examen, Integer> idMedecin;
    @FXML
    private TableColumn<Examen, Integer> idSalle;
    @FXML
    private TableColumn<Examen, Integer> idPatient;
    @FXML
    private TableColumn<Examen, String> typeEx;
    @FXML
    private TableColumn<Examen, String> dateEx;
    
    
    @FXML
    private TableColumn<Examen, String> resEx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ServiceExamen s = new ServiceExamen();
            
            idMedecin.setCellValueFactory(new PropertyValueFactory<Examen,Integer>("idMedecin"));
            idSalle.setCellValueFactory(new PropertyValueFactory<Examen,Integer>("idSalle"));
            idPatient.setCellValueFactory(new PropertyValueFactory<Examen,Integer>("idPatient"));
            typeEx.setCellValueFactory(new PropertyValueFactory<Examen,String>("typeEx"));
            dateEx.setCellValueFactory(new PropertyValueFactory<Examen,String>("dateEx"));
            resEx.setCellValueFactory(new PropertyValueFactory<Examen,String>("resEx"));
            ObservableList<Examen> list =s.getAll();
            
            list = s.getAll();
            
            texamen.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(AffichageExamenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    

    @FXML
    public void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjoutExamen.fxml"));
        Parent root =loader.load();
        texamen.getScene().setRoot(root);

    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        Examen E =  texamen.getSelectionModel().getSelectedItem();
        //Change the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierExamen.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        ModifierExamenController dpc = loader.getController();
        dpc.init(E);
        //get the new scene
        
        Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        Examen E = texamen.getSelectionModel().getSelectedItem();
        ServiceExamen s = new ServiceExamen();
        s.supprimer(new Examen(E.getIdEx()));
        JOptionPane.showMessageDialog(null,"Examen supprimé");

        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
    	Scene rcScene= new Scene(root);
        
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    	
    }
    
    @FXML
    private void exitP(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichagePatient.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void exitM(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageMedecin.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void exitS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageSalle.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void loadf(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/PageFacebook.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
//***********************à faire**************************************
    @FXML
    private void resultEx(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
    	Scene rcScene= new Scene(root);
        
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
}
