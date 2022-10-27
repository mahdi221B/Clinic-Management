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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import servicesEx.ServiceMedecin;

/**
 * FXML Controller class
 *
 * @author acila
 */
public class AjoutMedecinController implements Initializable {

    //private TextField tfidmedecinm;
    @FXML
    private TextField tfnomprenomm;
    private TableView<Medecin> tmedecin;
    private TableColumn<Medecin, Integer> idMedecinn;
    private TableColumn<Medecin, String> nomprenomm;
    private int ID;
    @FXML
    private TextField adrm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        ServiceMedecin s = new ServiceMedecin();
        s.ajouter(new Medecin(ID,tfnomprenomm.getText(),adrm.getText()));
        JOptionPane.showMessageDialog(null,"Données Medecin ajoutées");
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AjoutMedecin.fxml")) ;
            Scene rcScene= new Scene(root);

            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
    }

    
    void init(Medecin m) {
        ID=m.getIdMedecinm();
       //tfidmedecinm.setText(Integer.toString( m.getIdMedecinm()));
       tfnomprenomm.setText(m.getNomprenomm());
    }
    
    @FXML
    private void modifier(ActionEvent event) throws IOException {
        Medecin m =  tmedecin.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjoutMedecin.fxml"));
        Parent root =loader.load();
        AjoutMedecinController dpc = loader.getController();
        dpc.init(m);
        ServiceMedecin s = new ServiceMedecin();
        s.modifier(new Medecin(ID,tfnomprenomm.getText()));
        JOptionPane.showMessageDialog(null,"Données Medecin modifiées");
         //Parent root = FXMLLoader.load(getClass().getResource("../gui/AjoutMedecin.fxml")) ;
    	Scene rcScene= new Scene(root);
        
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
       
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
         Medecin m =  tmedecin.getSelectionModel().getSelectedItem();
        ServiceMedecin s = new ServiceMedecin();
        s.supprimer(new Medecin(m.getIdMedecinm()));
        JOptionPane.showMessageDialog(null,"Données Medecin supprimées");
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AjoutMedecin.fxml")) ;
            Scene rcScene= new Scene(root);

            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
       
    }
    
    @FXML
    private void retour(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageMedecin.fxml")) ;
            Scene rcScene= new Scene(root);
            
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AjoutMedecinController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
