/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Evenement;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import outils.TypeSponsoring;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class FajouterController implements Initializable {

    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfDesc;
    @FXML
    private TextField tfLieu;
    @FXML
    private TextField tfOrga;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfNum;
    @FXML
    private TextField tfMont;
    @FXML
    private DatePicker DatePickerDebut;
    @FXML
    private DatePicker DatePickerFin;


    private TypeSponsoring ts = null;
    @FXML
    private Label warning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*ObservableList<String> list = FXCollections. observableArrayList(ts.A.toString(), ts.B.toString(),ts.C.toString());
        comb.setItems(list);*/
    }    
    
     @FXML
    private void Exit(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/ModiferEvent.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void Ajouterevent(ActionEvent event) throws IOException  {
        if(tfTitre.getText().isEmpty() || tfDesc.getText().isEmpty() || tfLieu.getText().isEmpty() || tfOrga.getText().isEmpty() || tfEmail.getText().isEmpty()|| tfNum.getText().isEmpty()|| tfMont.getText().isEmpty()  )
    {warning.setText("Remplissez tous les champs");
    }else{
       try {
            System.out.println(Integer.parseInt(tfMont.getText()));
            try {
            System.out.println(Integer.parseInt(tfNum.getText()));
                EvenementService s = new EvenementService();

                s.add(new Evenement(Integer.parseInt(tfNum.getText()),Integer.parseInt(tfMont.getText()),tfTitre.getText(),tfDesc.getText(),tfLieu.getText(),tfOrga.getText(),tfEmail.getText(),DatePickerDebut.getValue().toString(),DatePickerFin.getValue().toString()));
                JOptionPane.showMessageDialog(null,"Event ajouter avec succés");

                Parent root = FXMLLoader.load(getClass().getResource("../gui/ModiferEvent.fxml")) ;
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

   
    
}
