/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXTextField;
import entities.user;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import outils.MyDB;
import outils.SendMail;
import services.userservice;

/**
 * FXML Controller class
 *
 * @author ce pc
 */
public class ForgetpassFXMLController implements Initializable {
    
    

    @FXML
    private JFXTextField txt_mail;
    @FXML
    private Button validmail;
    @FXML
    private Button quit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
  //

   
    @FXML
    private void validermail(ActionEvent event) throws IOException {
        userservice us = new userservice();
        user u = new user();
        String mail = txt_mail.getText();
        String mdp = us.getMdp(txt_mail.getText());
                u = us.getByMail(mail);
        
       /* if (u == null) {
            JOptionPane.showMessageDialog(null, "Email does not exist");
            txt_mail.setText("");*/
        {

            SendMail x = new SendMail();
            String subject = "Reset Password";
            String body = "Votre mot de passe est: " + mdp;
            x.send(subject, body, txt_mail.getText());
            Stage stage;
            Parent root = FXMLLoader.load(getClass().getResource("../gui/loginFXML.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        }
    }

    @FXML
    private void quit(ActionEvent event) throws IOException {
        
        
        
       FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/LoginFXML.fxml"));
            
            Parent root =loader.load();
            validmail.getScene().setRoot(root);

    }

}
