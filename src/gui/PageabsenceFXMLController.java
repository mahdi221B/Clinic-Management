/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.absence;
import java.io.IOException;
import static java.lang.Math.abs;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.absenceservice;

/**
 * FXML Controller class
 *
 * @author ce pc
 */
public class PageabsenceFXMLController implements Initializable {

    @FXML
    private Button button_ajouterab;
    @FXML
    private Button button_modifierab;
    @FXML
    private Button button_suppab;
    @FXML
    private TableColumn<absence, String> tf_nomab;
    @FXML
    private TableColumn<absence, String> tf_prenomab;
    @FXML
    private TableColumn<absence, String> tf_dateab;
    @FXML
    private TableColumn<absence, String> tf_dureab;
    @FXML
    private TableColumn<absence, String> tf_justtifab;
    
    
    //private absenceservice as; 
    @FXML
    private TableView<absence> treevab;
    @FXML
    private Button exit_acuiab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         absenceservice s = new absenceservice();
        tf_nomab.setCellValueFactory(new PropertyValueFactory<absence, String>("nom"));
        tf_prenomab.setCellValueFactory(new PropertyValueFactory<absence, String>("prenom") );
        tf_dateab.setCellValueFactory(new PropertyValueFactory<absence, String>("date_absence") );
        tf_dureab.setCellValueFactory(new PropertyValueFactory<absence, String>("duré_absence") );
        tf_justtifab.setCellValueFactory(new PropertyValueFactory<absence, String>("justification") );
        ObservableList<absence> list = s.getAll();
        treevab.setItems(list);
        
        
        // TODO
    }    

    @FXML
    private void passer_pageajoutab(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjouterFXML.fxml"));
            Parent root =loader.load();
            treevab.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(PageabsenceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        
        
        }
        
        
    }

    @FXML
    private void passer_pagemodifab(ActionEvent abs) throws IOException{
        
        absence E = treevab.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
        
        //Change the scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierabsenceFXML.fxml"));
        
        Parent root =loader.load();
        //Accessing the destined controller
            ModifierabsenceFXMLController dpc = loader.getController();
        
        
        //get the new scene
            treevab.getScene().setRoot(root);
        
        //Initializer les donnees de formateur
            dpc.init(E);
        
        
        
    }

    @FXML
    private void passer_pagesupprab(ActionEvent abs) throws IOException {
        
        
       absence  E = treevab.getSelectionModel().getSelectedItem();
    absenceservice s = new absenceservice();
    s.Supprimerabsence(new absence(E.getId_absence()));
    JOptionPane.showMessageDialog(null,"absence supprimé");
    
    
    
    
Parent root = FXMLLoader.load(getClass().getResource("../gui/PageabsenceFXML.fxml"));
Scene rcScene = new Scene(root);
Stage window=(Stage)((Node)abs.getSource()).getScene().getWindow();
window.setScene(rcScene);
window.show();

    }

    @FXML
    private void exit_acuiab(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AccueilFXML.fxml"));
            Parent root =loader.load();
            treevab.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(PageabsenceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
}
