/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Categorie;
import entities.Commentaire;
import java.io.IOException;
import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.security.Security;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
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
    @FXML
    private Label tftop;
    @FXML
    private Label topcommenter;
   

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
        setTftop(Integer.toString(s.TotalComments()));
        setTopcommenter(Integer.toString(s.getTop()));
        
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
                Commentaire C = tvCommentaire.getSelectionModel().getSelectedItem();
                //Change the scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierCommentaire.fxml"));
                Parent root = loader.load();
                
                ModifierCommentaireController dpc = loader.getController();
                //get the new scene
                tvCommentaire.getScene().setRoot(root);
                
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
       Notifications.create().title("Alert")
                    .text("Commentaire supprimé")
                    .showInformation();
        Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailCommentaire.fxml"));
        Scene rcScene = new Scene(root);
        Stage window = (Stage) ((Node) commentaire.getSource()).getScene().getWindow();
        window.setScene(rcScene);
        window.show();
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("../gui/DetailPost.fxml")) ;
    	Scene rcScene= new Scene(root);
    	
    	Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    	window.setScene(rcScene);
    	window.show();
    }

    public void setTftop(String tftop) {
        this.tftop.setText(tftop);
    }

    public void setTopcommenter(String topcommenter) {
        this.topcommenter.setText(topcommenter);
    }
    @FXML
    private void sendmail(ActionEvent event) {
        CommentaireService s = new CommentaireService();
        int TopID = s.getTop();
        String username = "bacem.mallek999@gmail.com";
                                String password = "tpqcsexqslpycdxf";
                                Properties props = new Properties();
                                Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                                props.put("mail.smtp.port", "465");
                                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                props.put("mail.smtp.ssl.enable", true); 
                                props.put("mail.smtp.ssl.protocols", "TLSv1.2");
                                props.put("mail.smtp.socketFactory.port", "465");
                                props.put("mail.smtp.socketFactory.fallback", "false");
                                props.put("mail.smtp.host", "smtp.gmail.com");
                                props.put("mail.smtp.auth", "true");
                                props.setProperty("mail.debug", "true");
                                props.setProperty("mail.transport.protocol", "smtp");
                                props.put("mail.smtp.starttls.enable", "true"); 
                                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(username, password);
                                    }
                                });

                                try {
                                    Address a = new InternetAddress("bacem.mallek999@gmail.com");
      
                                    Message message = new MimeMessage(session);
                                    message.setFrom(new InternetAddress("bacem.mallek999@gmail.com"));
                                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("bacem.mallek@esprit.tn") );
                                    message.setSubject("Best commenter");
                                    String htmlcode =    "<h1> User "+TopID+" You have won a badge you are very responsive to comments! </h1>"
                                            + "<h2>  you will recieve your badge </h2>"
                                            + "<h1><img src=\"images/blogging.jpg\" alt=\"logo\" /> . </h1> "
                                            ;
                                    message.setContent(htmlcode, "text/html");                   
                                    Transport.send(message);
                                } catch (MessagingException mex) {
                                    System.out.println(" failed, exception: " + mex.getMessage());
                                }
        
        
        
        
        
        
        
    }
    
  
    
}
