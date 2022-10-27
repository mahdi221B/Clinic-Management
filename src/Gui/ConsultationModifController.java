/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.Consultation;
import VisiteEntities.RendezVous;
import VisiteServices.ServiceConsultation;
import VisiteServices.ServiceRendezvous;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ConsultationModifController implements Initializable {

    @FXML
    private TextArea lexmodif;
    @FXML
    private TextArea lmedicmodif;
    @FXML
    private TextField traicomodif;
    @FXML
    private TextField nomedmodif;
    @FXML
    private TextField datcomodif;
    @FXML
    private TextField nptcomodif;
private int ID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

     public void init(Consultation r) {
        ID = r.getIdCon();
        lexmodif.setText(r.getListExamens());
        lmedicmodif.setText(r.getListMedicament());
        traicomodif.setText(r.getTraitement());
        nomedmodif.setText(r.getNomMedecin());
        datcomodif.setText(r.getDateConsultation());
        nptcomodif.setText(r.getNomPatient());
    }  
    
    @FXML
    private void modifier_cons(ActionEvent event) throws IOException{
         ServiceConsultation C = new ServiceConsultation();
        C.modifier(new Consultation( datcomodif.getText(),nptcomodif.getText(), nomedmodif.getText(), lmedicmodif.getText() ,lexmodif.getText(), traicomodif.getText()));
        JOptionPane.showMessageDialog(null,"Consultation modifié");
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/ConsultationAffichage.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }


    
}
