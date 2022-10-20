/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ThinkPad
 */
public class MainC extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/DetailCommentaire.fxml"));
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
