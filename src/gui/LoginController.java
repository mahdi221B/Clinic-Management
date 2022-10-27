/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import sun.net.www.protocol.jar.URLJarFileCallBack;

/**
 * FXML Controller class
 *
 * @author acila
 */
public class LoginController implements Initializable {

    @FXML
    private BorderPane parent;
    @FXML
    private Button btnMode;
    @FXML
    private ImageView imgmode;
    private boolean isLightMode = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changeMode(ActionEvent event) {
        isLightMode=!isLightMode;
        if(isLightMode){
            setLightMode();
        }
    }
    private void setLightMode(){
        parent.getStylesheets().remove("outilsEx/darkMode.css");
        parent.getStylesheets().add("outilsEx/lightMode.css");
        Image image= new Image(getClass().getResourceAsStream("../outilsEx/darkm.png"));
        imgmode.setImage(image);        
        
    }
    private void setDarktMode(){
        parent.getStylesheets().remove("../outilsEx/lightMode.css");
        parent.getStylesheets().add("../outilsEx/darkMode.css");
        Image image= new Image(getClass().getResourceAsStream("../outilsEx/lightm.png"));
        imgmode.setImage(image);
        
        
    }
    
}
