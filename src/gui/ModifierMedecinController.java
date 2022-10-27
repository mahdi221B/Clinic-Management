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
import servicesEx.ServiceMedecin;


/**
 * FXML Controller class
 *
 * @author acila
 */
public class ModifierMedecinController implements Initializable {

    @FXML
    private TextField tfnomprenomm;
    @FXML
    private TextField adrm;
    private int ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void init(Medecin e) {
       ID = e.getIdMedecinm();
       tfnomprenomm.setText(e.getNomprenomm());
       adrm.setText(e.getAdrm());
       
    }
    @FXML
    private void modifier(ActionEvent event) {
        
        
       ServiceMedecin s = new ServiceMedecin();
       s.modifier(new Medecin(ID,tfnomprenomm.getText(),adrm.getText()));
       JOptionPane.showMessageDialog(null,"Medecin modifié");
       
       
    
       
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
            Scene rcScene= new Scene(root);
            
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageMedecin.fxml")) ;
            Scene rcScene= new Scene(root);
            
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
        
    }
    
}
