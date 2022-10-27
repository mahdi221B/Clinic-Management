/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class WebController implements Initializable {

    @FXML
    private WebView webview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       final WebEngine web=webview.getEngine();
       String urlweb;
        urlweb = "http://google.com";
        web.load(urlweb);
    }    

    @FXML
    private void google(ActionEvent event) {
         final WebEngine web=webview.getEngine();
       String urlweb;
        urlweb = "http://google.com";
        web.load(urlweb);
    }

    @FXML
    private void linkedin(ActionEvent event) {
         final WebEngine web=webview.getEngine();
       String urlweb;
        urlweb = "https://fr.linkedin.com/";
        web.load(urlweb);
    }

    @FXML
    private void gmail(ActionEvent event) {
         final WebEngine web=webview.getEngine();
       String urlweb;
        urlweb = "https://myaccount.google.com/";
        web.load(urlweb);
    }
    
}
