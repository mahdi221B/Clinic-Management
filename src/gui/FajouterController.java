/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Evenement;
import entites.Categorie;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import services.CategorieService;
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


    @FXML
    private Label warning;
    @FXML
    private ComboBox<String> cbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieService cs = new CategorieService();
        ObservableList<String> list = FXCollections. observableArrayList(cs.getTitleAll());
        cbox.setItems(list); 

        
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
        CategorieService cs = new CategorieService();
        if(tfTitre.getText().isEmpty() || tfDesc.getText().isEmpty() || tfLieu.getText().isEmpty() || tfOrga.getText().isEmpty() || tfEmail.getText().isEmpty()|| tfNum.getText().isEmpty()|| tfMont.getText().isEmpty()  )
    {warning.setText("Remplissez tous les champs");
    }else{
       try {
            System.out.println(Integer.parseInt(tfMont.getText()));
            try {
            System.out.println(Integer.parseInt(tfNum.getText()));
                EvenementService s = new EvenementService();

                s.add(new Evenement(Integer.parseInt(tfNum.getText()),Integer.parseInt(tfMont.getText()),tfTitre.getText(),tfDesc.getText(),tfLieu.getText(),tfOrga.getText(),tfEmail.getText(),DatePickerDebut.getValue().toString(),DatePickerFin.getValue().toString(),cs.getMdp(cbox.getValue())));
                Notifications.create().title("NOTIFICATIONS")
                    .text("Evenement ajoutée avec succés")
                    .showInformation();

                Parent root = FXMLLoader.load(getClass().getResource("../gui/ModiferEvent.fxml")) ;
                Scene rcScene= new Scene(root);

                Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
                window.setScene(rcScene);
                window.show();
            }catch(Exception e){
                 warning.setText("Numéro doit étre de type entier");
                }
            }catch(Exception e){
         warning.setText("Montant doit étre de type entier");
        }
        }
    }

   
    
}
