/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.Consultation;
import VisiteEntities.DossierPatient;
import VisiteServices.ServiceConsultation;
import VisiteServices.ServiceDossierpatient;
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

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DossierModifController implements Initializable {

    @FXML
    private TextField nomPatMdf;
    @FXML
    private TextField medicmodif;
    @FXML
    private TextField consmodif;
    @FXML
    private TextField allergmodif;
    @FXML
    private TextField maldmodif;
    @FXML
    private TextField opertmdf;
private int ID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     public void init(DossierPatient r) {
        ID = r.getIdP();
        nomPatMdf.setText(r.getNomP());
        medicmodif.setText(r.getMedicaments());
        consmodif.setText(r.getConsultations());
        allergmodif.setText(r.getAllergieMedicaments());
        maldmodif.setText(r.getMaladies());
        opertmdf.setText(r.getDetailsOperation());
    }  

    @FXML
    private void Modifier_Dossier(ActionEvent event) {
         ServiceDossierpatient C = new ServiceDossierpatient();
        C.modifier(new DossierPatient(nomPatMdf.getText(), medicmodif.getText(), consmodif.getText(), allergmodif.getText(), maldmodif.getText(), opertmdf.getText()));
        JOptionPane.showMessageDialog(null,"DossierPatient modifié");
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/DossierAffichage.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
    }
    

