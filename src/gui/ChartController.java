/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class ChartController implements Initializable {

    @FXML
    private Pane chartpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EvenementService es = new EvenementService();
        List<Integer> MONTANT = es.getAllEvMont();
        List<String> EVENEMENT = es.getAllEvTitle();
        //chartpane.getChildren().clear();

        ObservableList<PieChart.Data> List=FXCollections.observableArrayList();
       
        
        for (int i = 0; i < MONTANT.size(); i++) {
           List.add (new PieChart.Data (EVENEMENT.get(i), MONTANT.get(i)));
        }
        
        PieChart pCharte= new PieChart (List);
        chartpane.getChildren().add(pCharte) ;

    }    

    @FXML
    private void Exit(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/ModiferEvent.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    
}
