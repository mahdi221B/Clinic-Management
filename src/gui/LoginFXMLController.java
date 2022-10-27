/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import entities.user;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ce pc
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private JFXTextField txtusername;

    @FXML
    private JFXPasswordField txtpass;

    @FXML
    private JFXButton login;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Stage stage;
    @FXML
    private AnchorPane forgetpass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        user u = new user();
        String username = txtusername.getText();
        String pass = txtpass.getText();

        // String role ="";
        if (username.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "username or password is not exist ");
        } else {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pi2022", "root", "");
            pst = con.prepareStatement("select * from user where adresse =? and mot_passe=?   ");

            pst.setString(1, username);
            pst.setString(2, pass);

            rs = pst.executeQuery();

            if (rs.next() && rs.getString("role").equals("admin")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AccueilFXML.fxml"));
                Parent root = loader.load();
                txtusername.getScene().setRoot(root);
            } else {
                JOptionPane.showMessageDialog(null, "login Failed ");
                txtusername.setText("");
                txtpass.setText("");
                txtusername.requestFocus();

            }

        }

    }

    @FXML
    private void forgetPassword(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/forgetpassFXML.fxml"));
        Scene rcScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(rcScene);
        window.show();
    }

}
