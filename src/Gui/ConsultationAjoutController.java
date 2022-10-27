/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import VisiteEntities.Consultation;
import VisiteEntities.RendezVous;
import VisiteServices.ServiceConsultation;
import VisiteServices.ServiceRendezvous;
import com.itextpdf.text.BaseColor;
import static com.itextpdf.text.BaseColor.BLUE;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ConsultationAjoutController implements Initializable {

    @FXML
    private TextField nomedco;
    @FXML
    private TextField nompatco;
    @FXML
    private TextField dateco;
    @FXML
    private TextArea listexam;
    @FXML
    private TextArea listmedic;
    @FXML
    private TextField trait;
    @FXML
    private Label warn;

    /**
     * Initializes the controller class.
     */
   
    @FXML
    private void ajouter_consult(ActionEvent event) throws IOException {
    
    
        
  if(nomedco.getText().isEmpty() || nompatco.getText().isEmpty() || dateco.getText().isEmpty() || listexam.getText().isEmpty() || listmedic.getText().isEmpty()|| trait.getText().isEmpty())
    {warn.setText("Remplissez tous les champs");
    }else{
           ServiceConsultation s = new ServiceConsultation ();
           Consultation r = new Consultation(dateco.getText() , nompatco.getText(),nomedco.getText(), listmedic.getText(), listexam.getText(), trait.getText());
           System.out.println(r);
           s.ajouter(r);
           JOptionPane.showMessageDialog(null,"Consultation  ajouté");
                 
       
       Parent root = FXMLLoader.load(getClass().getResource("../gui/ConsultationAffichage.fxml")) ;
            Scene rcScene= new Scene(root);	
            Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
            window.setScene(rcScene);
            window.show();
               }
    }

    @FXML
    private void ExporterPDF(ActionEvent event) throws FileNotFoundException, DocumentException {
        Document doc =new Document();
        try{
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\pdfJava\\Ordonnance"));
        doc.open();
        Image img=Image.getInstance("C:\\Users\\USER\\Desktop\\gl\\Capturefin.PNG");
       
        img.scaleAbsoluteWidth(80);
        img.scaleAbsoluteHeight(60);
        
         doc.add(img);
        doc.add(new Paragraph ("Ordonnance",FontFactory.getFont("Arial",16)));
        doc.add(new Paragraph("------------"));
         doc.add(new Paragraph (new Phrase("Nom medecin :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(nomedco.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("Date consultation :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(dateco.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("Nom patient :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(nompatco.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("Liste examens  :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(listexam.getText(),FontFactory.getFont("Arial",10))));
         doc.add(new Paragraph (new Phrase("Liste medicaments :",FontFactory.getFont("Arial",12))));
         doc.add(new Paragraph(new Phrase(listmedic.getText(),FontFactory.getFont("Arial",10))));
          doc.add(new Paragraph (new Phrase("traitement :",FontFactory.getFont("Arial",12))));
          doc.add(new Paragraph(new Phrase(trait.getText(),FontFactory.getFont("Arial",10))));
        doc.add(new Paragraph("------------"));
         doc.add(new Paragraph (new Phrase("Clinique l'espoir ",FontFactory.getFont("Arial",9,BLUE))));
          
         
        doc.close();
        Desktop.getDesktop().open(new File ("C:\\pdfJava\\Ordonnance"));
        
        
        
        
    }catch(FileNotFoundException e){e.printStackTrace();} catch (IOException ex) {
            Logger.getLogger(ConsultationAjoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
    }
}