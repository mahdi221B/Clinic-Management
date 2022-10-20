/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Blog;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.Button;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.BlogService;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class DetailPostController implements Initializable {

    @FXML
    private TableColumn<Blog, String> collSujet;
    @FXML
    private TableColumn<Blog, String> collDescription;
    @FXML
    private TableColumn<Blog, String> collDate;
    @FXML
    private TableColumn<Blog, String> collReview;
    @FXML
    private TableColumn<Blog, Integer> collUser;
    @FXML
    private TableView<Blog> tvPost;
    private Label warning;
    @FXML
    private TextField tfpass;
    @FXML
    private Label controle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BlogService s = new BlogService();
        collSujet.setCellValueFactory(new PropertyValueFactory<Blog, String>("Sujet_Post"));
        collDescription.setCellValueFactory(new PropertyValueFactory<Blog, String>("Description_Post"));
        collDate.setCellValueFactory(new PropertyValueFactory<Blog, String>("Date_Post"));
        collReview.setCellValueFactory(new PropertyValueFactory<Blog, String>("Review_Post"));
        collUser.setCellValueFactory(new PropertyValueFactory<Blog, Integer>("User_Id_Post"));
        ObservableList<Blog> list = s.getAll();
        tvPost.setItems(list);
    }

    @FXML
    private void Modifier(ActionEvent post) throws IOException {
        try {
            if (tvPost.getSelectionModel().getSelectedItem() != null) 
                 {
                Blog E = tvPost.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
                //Change the scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierPost.fxml"));
                Parent root = loader.load();
                //Accessing the destined controller
                ModifierPostController dpc = loader.getController();
                //get the new scene
                tfpass.getScene().setRoot(root);
                //Initializer les donnees de formateur
                dpc.init(E);
            }
        } catch (IOException ex) {
            controle.setText("Selectionner un post");

        }
    }

    @FXML
    private void Supprimer(ActionEvent post) throws IOException {
        
        Blog E = tvPost.getSelectionModel().getSelectedItem();
        BlogService s = new BlogService();
        s.delete(new Blog(E.getId_Post()));
        JOptionPane.showMessageDialog(null, "Post supprimé");
        Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailPost.fxml"));

        Scene rcScene = new Scene(root);

        Stage window = (Stage) ((Node) post.getSource()).getScene().getWindow();
        window.setScene(rcScene);
        window.show();
    }

    @FXML
    private void Ajouter(ActionEvent post) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjouterPost.fxml"));
            Parent root = loader.load();
            //Accessing the destined controller
            //get the new scene
            tvPost.getScene().setRoot(root);

        } catch (IOException ex) {
            warning.setText("Selectionner un Post");
        }

    }

}
