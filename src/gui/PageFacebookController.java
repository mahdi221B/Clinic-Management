/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acila
 */
public class PageFacebookController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private WebView webview;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final WebEngine web=webview.getEngine();
        String urlweb;
        urlweb = "https://www.facebook.com/acil.zaidi.9/";
        web.load(urlweb);
    }

    @FXML
    private void ret(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
    	Scene rcScene= new Scene(root);
        
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    }    
    

