/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author miled
 */
public class MainProg extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/detaillearticles.fxml"));
 //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/validercommande.fxml"));
   //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/detaillecommande.fxml"));

FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/home.fxml"));
      
       Parent root =loader.load();
       //Acteur
       Scene scene = new Scene(root);
       //stage
       primaryStage.setScene(scene);
       primaryStage.setTitle("PIDV");
       //rideau
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
