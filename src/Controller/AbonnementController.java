/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entities.Abonnement;
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
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Services.CRUD_Abonnement;


/**
 * FXML Controller class
 *
 * @author Yacine
 */
public class AbonnementController implements Initializable {

   @FXML ImageView abonner ;
   @FXML ImageView desabonner ;
   @FXML Text message;
   @FXML Text message2;
   @FXML AnchorPane abonnePane ;
   @FXML AnchorPane desabonnePane;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void abonne () throws SQLException,IOException
    {
        CRUD_Abonnement cr = new CRUD_Abonnement();
        Abonnement a = new Abonnement();
        cr.ajouterAbonnement(a);
        abonnePane.setVisible(true);
        desabonnePane.setVisible(false);
//        message.setVisible(true);
//        abonner.setVisible(false);
//        desabonner.setVisible(true);
    }
    
    
    
     public void desabonne () throws SQLException,IOException
    {
        CRUD_Abonnement cr = new CRUD_Abonnement();
        //Abonnement a = new Abonnement();
        cr.supprimerAbonnement(1);
        abonnePane.setVisible(false);
        desabonnePane.setVisible(true);
        message2.setVisible(true);
//       message2.setVisible(true);
//       message.setVisible(false);
//       desabonner.setVisible(false);
//        abonner.setVisible(true);
     
//        message2.setVisible(true);
        
    }
     public void affichage (ActionEvent event) throws SQLException,IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/affichageAbonnement.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            AffichageAbonnementController Adminct7= fxmlloader.<AffichageAbonnementController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
     
    public void retour5 (ActionEvent event) throws SQLException,IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/Acceuil.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            AcceuilController Adminct4= fxmlloader.<AcceuilController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
}
