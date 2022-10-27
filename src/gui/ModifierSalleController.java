/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entitiesEx.Salle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import servicesEx.ServiceSalle;

/**
 * FXML Controller class
 *
 * @author acila
 */
public class ModifierSalleController implements Initializable {

    @FXML
    private TextField tfetage;
    @FXML
    private TextField tfappareil;
    private int ID;
    @FXML
    private TextField blocs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  void init(Salle e) {
       ID = e.getIdSalle();
       blocs.setText(e.getBlocs());
       tfetage.setText(Integer.toString( e.getIdEtageSalle()));
       tfappareil.setText(e.getAppareilUtilise());
    }
    
    @FXML
    private void modifier(ActionEvent event) {
       ServiceSalle s = new ServiceSalle();
       s.modifier(new Salle(ID,Integer.parseInt(tfetage.getText()),blocs.getText(),tfappareil.getText()));
       JOptionPane.showMessageDialog(null,"Salle modifiée");
       
       
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
    @FXML
    private void retourSalle(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageSalle.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
  
}
