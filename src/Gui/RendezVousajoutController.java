/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.RendezVous;
import VisiteServices.ServiceRendezvous;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class RendezVousajoutController implements Initializable {

    @FXML
    private TextField tfNomed;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfNompat;
    @FXML
    private TextArea taCause;
    @FXML
    private TextField tfHeure;
    @FXML
    private Label warn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void ajouterRDV(ActionEvent event) throws IOException {
       if(tfNomed.getText().isEmpty() || tfDate.getText().isEmpty() || tfHeure.getText().isEmpty() || tfNompat.getText().isEmpty() || taCause.getText().isEmpty())
    {warn.setText("Remplissez tous les champs");
    }else{
           ServiceRendezvous s = new ServiceRendezvous ();
           RendezVous r = new RendezVous(tfNompat.getText(), tfDate.getText(), tfHeure.getText(), tfNomed.getText(), taCause.getText());
           System.out.println(r);
           s.ajouter(r);
           JOptionPane.showMessageDialog(null,"Rendez-vous  ajouté");
                 

   
       
       Parent root = FXMLLoader.load(getClass().getResource("../gui/RendezVousaffichage.fxml")) ;
            Scene rcScene= new Scene(root);	
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
               }
    }}