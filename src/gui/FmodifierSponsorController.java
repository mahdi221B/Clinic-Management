/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Evenement;
import entites.Sponsor;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import outils.TypeSponsoring;
import services.EvenementService;
import services.SponsorService;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class FmodifierSponsorController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfMail;
    @FXML
    private TextField tfNum;
    @FXML
    private TextField tfMontant;
   
    private TypeSponsoring ts = null;
    private int ID;
    private String TS;
    
    @FXML
    private ComboBox cboxdata;
    @FXML
    private Label warning;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections. observableArrayList(ts.Workshop.toString(), ts.Sportifs.toString(),ts.Compétence.toString());
        cboxdata.setItems(list);
    }    
    
    public void init(Sponsor E) {
        ID = E.getId_sponsor();
        tfNom.setText(E.getNom_societe());
        tfMail.setText(E.getEmail_societe());
        tfNum.setText(Integer.toString(E.getPhone_societe()));
        tfMontant.setText(Integer.toString(E.getMontant_donnee()));
    }  
   

    @FXML
    private void Modifiersponsor(ActionEvent event) throws IOException {
        if(tfNom.getText().isEmpty() || tfMail.getText().isEmpty() || tfNum.getText().isEmpty() || tfMontant.getText().isEmpty() || cboxdata.getSelectionModel().getSelectedIndex()==-1)
    {warning.setText("Remplissez tous les champs");
    }else{
        try {
            System.out.println(Integer.parseInt(tfMontant.getText()));
            try {
            System.out.println(Integer.parseInt(tfNum.getText()));
        SponsorService C = new SponsorService();
        C.update(new Sponsor(ID,Integer.parseInt(tfNum.getText()),Integer.parseInt(tfMontant.getText()),tfNom.getText(),tfMail.getText(),cboxdata.getValue().toString()));
        JOptionPane.showMessageDialog(null,"Sponsor modifié avec succès");
        Parent root = FXMLLoader.load(getClass().getResource("../gui/ListSponsor.fxml")) ;
        Scene rcScene= new Scene(root);
        Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
        window.setScene(rcScene);
        window.show();
        }catch(Exception e){
                 warning.setText("Doit étre de type entier");
                }
            }catch(Exception e){
         warning.setText("Doit étre de type entier");
        }
        }
    }

    @FXML
    private void Exit(MouseEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ListSponsor.fxml")) ;
    Scene rcScene= new Scene(root);
    Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    window.setScene(rcScene);
    window.show();
    }

    @FXML
    private void select(ActionEvent event) {
    }

}
