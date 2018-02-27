    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entities.Mail;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import Entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import Services.CRUD_Reclamation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author Yacine
 */
public class FXMLAjoutController implements Initializable {

    @FXML JFXTextArea sujet ;
    @FXML JFXTextArea email ;
    @FXML JFXTextArea reclamation ;
    @FXML JFXButton envoyer ; 
    @FXML Label alerte;
    @FXML Label spam;
    @FXML Label alertemail;
    @FXML Text alertereclam;
    //@FXML JFXDatePicker date ;
    @FXML
    private AnchorPane date;
    CRUD_Reclamation r = new CRUD_Reclamation();
        
    
   
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            int k = 0 ;
            k = AfficherproduitController.current_produit.getId_user();
            System.out.println(r.get_email(k));
            System.out.println(AfficherproduitController.current_produit.getId_user());
            email.setText(r.get_email(k));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAjoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
@FXML 
public void ajouter_reclamation(ActionEvent event ) throws SQLException,IOException
 {
     
     
     int i = 0;
    
     
    
            if(sujet.getText().equals(""))
            {
                alerte.setVisible(true);
                i++;
            }
            if(reclamation.getText().equals(""))
            {
                alertereclam.setVisible(true);
                i++;
            }
//            if(r.ListeSujet().contains(sujet.getText()))
//            {
//                spam.setVisible(true);
//                i++;
//            }
            if(email.getText().equals(""))
            {
                alerte.setVisible(true);
                i++;
            }
            else if (i==0){
            
            Reclamation rec = new Reclamation(sujet.getText(), reclamation.getText() );
            //Mail mail_reclamation = new Mail();
          
            r.ajouterReclamation(rec);
               
            //mail_reclamation.Send_Reclamation(sujet.getText(),email.getText(), reclamation.getText());
          
}
 }



    @FXML
    public void retour4 (ActionEvent event ) throws SQLException,IOException
{
    FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/Afficher_Detail_Produit.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            Afficher_Detail_ProduitController Adminct5= fxmlloader.<Afficher_Detail_ProduitController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    
}







}
