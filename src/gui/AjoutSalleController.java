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
public class AjoutSalleController implements Initializable {

    @FXML
    private TextField tfetage;
    @FXML
    private TextField tfappareil;
    @FXML
    private TextField blocs;
    private int ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        ServiceSalle s = new ServiceSalle();
        s.ajouter(new Salle(ID,Integer.parseInt(tfetage.getText()),blocs.getText(),tfappareil.getText()));
        JOptionPane.showMessageDialog(null,"Salle ajoutée");
        Parent root = null;
    
//    Scene rcScene= new Scene(root);
    	
    	/*Stage window;
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
*/
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
