/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ce pc
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
     /*   Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);*/
     
     
     /*Parent root = FXMLLoader.load(getClass().getResource("/gui/ModifierabsenceFXML.fxml"));
        Scene scene = new Scene(root);*/
        
      /*  Parent root = FXMLLoader.load(getClass().getResource("/gui/PageabsenceFXML.fxml"));
        Scene scene = new Scene(root);*/
     /* Parent root = FXMLLoader.load(getClass().getResource("/gui/PageuserFXML.fxml"));
        Scene scene = new Scene(root);*/
        
                Parent root = FXMLLoader.load(getClass().getResource("/gui/AccueilFXML.fxml"));
        Scene scene = new Scene(root);
        
       // primaryStage.setTitle("Ajouter Absence!");
         primaryStage.setTitle(" Administrateur!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}