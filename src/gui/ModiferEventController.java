/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Evenement;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.EvenementService;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
/*import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
*/
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;



/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class ModiferEventController implements Initializable {

    @FXML
    private TableView<Evenement> TEvent;
    @FXML
    private TableColumn<Evenement, String> CTitre;
    @FXML
    private TableColumn<Evenement, String> CDesc;
    @FXML
    private TableColumn<Evenement, String> CLieu;
    @FXML
    private TableColumn<Evenement, String> COrga;
    @FXML
    private TableColumn<Evenement, String> CEmail;
    @FXML
    private TableColumn<Evenement, Integer> CNum;
    @FXML
    private TableColumn<Evenement, Integer> CMont;
    @FXML
    private TableColumn<Evenement, String> CDeb;
    @FXML
    private TableColumn<Evenement, String> CFin;
    @FXML
    private Label warning;
    @FXML
    private AnchorPane ap;
    @FXML
    private BorderPane bp;
    @FXML
    private TextField tfsearch;
    @FXML
    private Label lblsomme;
    @FXML
    private Label lblmontant;
    @FXML
    private Label lblhmontant;
    
    private String directory;
    private static final String DIR="Bureau";
    
    
    
    @FXML
    private TableColumn<Evenement, String> Categorie;
    private ImageView imgqrcode;
   
    
    String idrsto;


    

    
    public void setLblsomme(String lblsomme) {
        this.lblsomme.setText(lblsomme);
    }

    public void setLblmontant(String lblmontant) {
        this.lblmontant.setText(lblmontant);
    }
    
    public void setlblhmontant(String lblhmontant) {
        this.lblhmontant.setText(lblhmontant);
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EvenementService s = new EvenementService();
        CTitre.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Titre"));
        CDesc.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Description"));
        CLieu.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Lieu"));
        COrga.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Nom_organisateur"));
        CEmail.setCellValueFactory(new PropertyValueFactory<Evenement, String>("email_organisateu"));
        CMont.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("montant_recolte"));
        CNum.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("Phone_organisateur"));
        CDeb.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Date_debut"));
        CFin.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Date_fin"));
        Categorie.setCellValueFactory(new PropertyValueFactory<Evenement, String>("categorie"));
        ObservableList<Evenement> list = s.getAll();
        TEvent.setItems(list);
        
        
        
        
        
        setLblsomme(Integer.toString(s.Total()));
        setLblmontant(Integer.toString(s.MTotal()));
        setlblhmontant(s.HMontant());
       
        
        

                
        
        FilteredList<Evenement> filteredData = new FilteredList<>(list, b -> true);
        tfsearch.textProperty().addListener((observable, oldValue, newValue) -> {
          filteredData.setPredicate(cp-> {
              if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
              String lowerCaseFilter = newValue.toLowerCase();
              if (cp.getTitre().toLowerCase().contains(lowerCaseFilter) ) {
                    return true; // Filter matches first name.    
                } else if (cp.getLieu().toLowerCase().contains(lowerCaseFilter) ){
                    return true; // Filter matches date deb.
                } else if (cp.getLieu().toLowerCase().contains(lowerCaseFilter) ){
                    return true; // Filter matches date deb.
                } else if (cp.getCategorie().toLowerCase().contains(lowerCaseFilter) ){
                    return true; // Filter matches date deb.
                } else if (cp.getDate_debut().toLowerCase().contains(lowerCaseFilter) ){
                    return true; // Filter matches date deb.
                } else if (cp.getDate_fin().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                    } else if (cp.getDescription().toLowerCase().contains(lowerCaseFilter) ){
                             return true;
                    }
                return false;
       });
       });
        SortedList<Evenement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(TEvent.comparatorProperty());
        TEvent.setItems(sortedData);
        
        
        
     /*   directory= new File("").getAbsolutePath();
        directory+=File.separator+DIR;
        File file = new File(directory);
        if(!file.isDirectory()){
            file.mkdir();
        }*/
     
    /* ByteArrayOutputStream out = QRCode.from("LT Jerry0022").to(ImageType.PNG).withSize(200, 200).stream();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        // SHOW QR CODE
        Image image = new Image(in);
        QRimage.setImage(image);*/
    
    
    
    }   


     

    @FXML
    private void Modifier(ActionEvent event) throws IOException { 
        try {
        Evenement E = TEvent.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Fmodifier.fxml"));
        Parent root =loader.load();
        FmodifierController dpc = loader.getController();
        dpc.init(E);
        
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        }catch(Exception ex) {
	warning.setText("Selectionner un Evenement"); 
        
	}
    }

    @FXML
    private void Delete(ActionEvent event) throws IOException {
        try{
    Evenement E = TEvent.getSelectionModel().getSelectedItem();
    EvenementService s = new EvenementService();
    s.delete(new Evenement(E.getId_evenement()));
            Notifications.create().title("NOTIFICATIONS")
                    .text("Evenement supprimer avec succés")
                    .showInformation();
    
    Parent root = FXMLLoader.load(getClass().getResource("../gui/ModiferEvent.fxml")) ;
    Scene rcScene= new Scene(root);
    	
    Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    window.setScene(rcScene);
    window.show();
    }catch(Exception ex) {
	warning.setText("Selectionner un Evenement");
        }
    }

    @FXML
    private void Ajouter(ActionEvent event) {
     try {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/Fajouter.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
        
        }catch(Exception ex) {
	
	}   
    }

    @FXML
    private void categorie(MouseEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    private void evet(MouseEvent event) throws IOException {
        loadPage("ListCategorie");
    }

    @FXML
    private void donation(MouseEvent event) throws IOException {
        loadPage("ListSponsor");
    }

    private void loadPage (String page) throws IOException {
     Parent root = null;
     root = FXMLLoader.load(getClass().getResource(page+".fxml")) ;
     bp.setCenter(root);
    }

    
    
    @FXML
    private void OpenStat(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("../gui/chart.fxml")) ;
    Scene rcScene= new Scene(root);
    Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    window.setScene(rcScene);
    window.show();
    Notifications.create().title("NOTIFICATIONS")
                    .text("Statistiques qui montrent les revenus de chaque événement")
                    .showInformation();
    }


    @FXML
    private void Imprimer(ActionEvent event) {
        Printer printer = Printer.getDefaultPrinter();

    PrinterJob job = PrinterJob.createPrinterJob();
    if (job != null) {
        boolean success = job.printPage(TEvent);
        if (success) {
            job.endJob();
        }
        
        Notifications.create().title("NOTIFICATIONS")
                    .text("Tableau d'évenement en cours d'mpression...")
                    .showInformation();
    }
    }

    @FXML
    private void generateQR(ActionEvent event) throws FileNotFoundException, IOException {
       /* Evenement E = TEvent.getSelectionModel().getSelectedItem();
        String  contenu ="";
        contenu +="Titre :"+E.getTitre()+"\n";
        contenu +="Description :"+E.getDescription()+"\n";
        contenu +="Date de début :"+E.getDate_debut()+"\n";
        contenu +="Date fin :"+E.getDate_fin()+"\n";
        String Pathname="C:\\Users\\mahdi\\OneDrive\\Images\\Pellicule\\";

        FileOutputStream out = new FileOutputStream(new File (Pathname+(E.getTitre()+".PNG")));
     //   ByteArrayOutputStream bos =QRCode.from(contenu).withSize(125,125).to(ImageType.PNG).stream();
       // out.write(bos.toByteArray());
        
       // bos.close();
        //out.close();
        out.flush();
        System.out.println("sucess");
       /*Image image = new Image(new FileInputStream(DIR+File.separator +E.getTitre()+".png"));
        QRimage.setImage(image);*/
        
        Parent root = FXMLLoader.load(getClass().getResource("../gui/QRcode interface.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }
    

}


