/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Categorie;
import entities.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.CategorieService;
import service.CommentaireService;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class DetailCommentaireController implements Initializable {

    @FXML
    private TableColumn<Commentaire,String> collText_Comm;
    @FXML
    private TableColumn<Commentaire,Integer> collUser_Comm;
    @FXML
    private TableColumn<Commentaire,Integer> collId_Comm;
    @FXML
    private TableView<Commentaire> tvCommentaire;
    @FXML
    private Label controlecomm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CommentaireService s = new CommentaireService();
        collText_Comm.setCellValueFactory(new PropertyValueFactory<Commentaire, String>("Text_Commentaire"));
        collUser_Comm.setCellValueFactory(new PropertyValueFactory<Commentaire,Integer>("User_Id_Commentaire"));
        collId_Comm.setCellValueFactory(new PropertyValueFactory<Commentaire, Integer>("Id_Post_Commentaire"));
        
        
        ObservableList<Commentaire> list = s.getAll();
        tvCommentaire.setItems(list);
    }    

    @FXML
    private void AjouterCom(ActionEvent commentaire) throws IOException {
       try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjoutCommentaire.fxml"));
            Parent root = loader.load();
            //Accessing the destined controller
            //get the new scene
            tvCommentaire.getScene().setRoot(root);

       } catch (IOException ex) {
            controlecomm.setText("Selectionner un commentaire");
        }

    }
    @FXML
    private void ModifierComm(ActionEvent commentaire) throws IOException {
        
       try {
           if (tvCommentaire.getSelectionModel().getSelectedItem() != null) 
           {
                Commentaire C = tvCommentaire.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
                //Change the scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierCommentaire.fxml"));
                Parent root = loader.load();
                //Accessing the destined controller
                ModifierCommentaireController dpc = loader.getController();
                //get the new scene
                tvCommentaire.getScene().setRoot(root);
                //Initializer les donnees de formateur
                dpc.init(C);
            }
         
         } catch (IOException ex) {
        
}
    }
    @FXML
    private void SupprimerComm(ActionEvent commentaire) throws IOException {
        Commentaire C = tvCommentaire.getSelectionModel().getSelectedItem();
        CommentaireService s = new CommentaireService();
        s.delete(new Commentaire(C.getId_Commentaire()));
        JOptionPane.showMessageDialog(null, "Commentaire supprimé");
        Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCommentaire.fxml"));
        Scene rcScene = new Scene(root);
        Stage window = (Stage) ((Node) commentaire.getSource()).getScene().getWindow();
        window.setScene(rcScene);
        window.show();
    }
    
}
