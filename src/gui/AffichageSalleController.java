/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entitiesEx.Salle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import servicesEx.ServiceSalle;


/**
 * FXML Controller class
 *
 * @author acila
 */
public class AffichageSalleController implements Initializable {
    @FXML
    private TableView<Salle> tsalle;
    @FXML
    private TableColumn<Salle, Integer> idEtageSalle;
    @FXML
    private TableColumn<Salle, String> appareilUtilise;
   
    @FXML
    private Button BAjoutSalle;
    @FXML
    private Button BModifSalle;
    @FXML
    private Button BSuppSalle;
    ObservableList<Salle> newlist;
    @FXML
    private TableColumn<Salle, String> blocs;
    @FXML
    private TextField afftot;


     
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceSalle s = new ServiceSalle();
        idEtageSalle.setCellValueFactory(new PropertyValueFactory<Salle,Integer>("idEtageSalle"));
        blocs.setCellValueFactory(new PropertyValueFactory<Salle,String>("blocs"));
        appareilUtilise.setCellValueFactory(new PropertyValueFactory<Salle,String>("appareilUtilise"));
        ObservableList<Salle> list = s.getAll();
        tsalle.setItems(list);
        
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjoutSalle.fxml"));
        Parent root =loader.load();
        tsalle.getScene().setRoot(root);
        
    }

    @FXML
    private void modifier(ActionEvent event)throws IOException{
         try {
        Salle E =  tsalle.getSelectionModel().getSelectedItem();//Avoir les donnes de formateur sélectionnée
        //Change the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierSalle.fxml"));
        Parent root =loader.load();
        //Accessing the destined controller
        ModifierSalleController dpc = loader.getController();
        dpc.init(E);
        //get the new scene
        Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        }catch(IOException ex) {
            //warning.setText("Selectionner un salle");
        
        
	}
    }

    @FXML
     void supprimer(ActionEvent event) throws IOException {
        Salle E = tsalle.getSelectionModel().getSelectedItem();
        ServiceSalle s = new ServiceSalle();
        s.supprimer(new Salle(E.getIdSalle()));
        JOptionPane.showMessageDialog(null,"Salle supprimée");

        Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageSalle.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    
    
    
    }
     
    
    @FXML
    private void retourH(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/AffichageExamen.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    @FXML
    private void total(ActionEvent event) {
    }
}
/*
    @FXML
    private void filtrer(ActionEvent event) {
        
         
        
         
          ServiceSalle f = new  ServiceSalle();
           Parent p1;   
   
         
        try {
            Salle p = new Salle();
           
              Salle ps = f.filtrer(filtres.getText());   
                   
            newlist = FXCollections.observableArrayList();
         
            
            
            
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
            a1.setTitle("Fiche trouvée");
            a1.setContentText(ps.toString());
            a1.show();
            p1 = FXMLLoader.load(getClass().getResource("../gui/DossierAffichage.fxml"));
            
            Scene test1 = new Scene(p1);
            
            Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            App1.setScene(test1);
            App1.show();
          
         
            
        }
     catch(IOException ex ){
  
         Alert alert = new Alert(Alert.AlertType.WARNING);
            
            alert.setTitle("No Name found");
            alert.setHeaderText("Nom du patient n'existe pas ");
            alert.setContentText("s'il vous plais cherchez avec un autre nom ou bien ecrivez un nouveau dossier avec ce nom ");

            alert.showAndWait();
        
        
    }
        
    }

   /* @FXML
    private void total(ActionEvent event) {
        ServiceSalle s = new ServiceSalle();
        long x =1;
        afftot.setText(String.valueOf(s.getTotal(x)));
        
    }
}
    //@FXML
   /* private void search(ActionEvent event) {
        ServiceSalle f = new  ServiceSalle();
           Parent p1;   
   
         
        try {
            Salle p = new Salle();
           
           ArrayList<Salle> ps = f.afficher(filtres.getText());   
                   
            newlist = FXCollections.observableArrayList();
         
            
            
            
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
            a1.setTitle("Fiche trouvée");
            a1.setContentText(ps.toString());
            a1.show();
            p1 = FXMLLoader.load(getClass().getResource("../gui/AffichageSalle.fxml"));
            
            Scene test1 = new Scene(p1);
            
            Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            App1.setScene(test1);
            App1.show();
          
         
            
        }
     catch(IOException ex ){
  
         Alert alert = new Alert(Alert.AlertType.WARNING);
            
            alert.setTitle("No Name found");
            alert.setHeaderText("Nom du patient n'existe pas ");
            alert.setContentText("s'il vous plais cherchez avec un autre nom ou bien ecrivez un nouveau dossier avec ce nom ");

            alert.showAndWait();
    }
    }*/
    
    
   
    

