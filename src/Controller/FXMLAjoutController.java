    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import Entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import Services.CRUD_Reclamation;

/**
 *
 * @author Yacine
 */
public class FXMLAjoutController implements Initializable {

    @FXML JFXTextArea sujet ;
    @FXML JFXTextArea reclamation ;
    @FXML JFXButton envoyer ; 
    @FXML Label alerte;
    @FXML Label spam;
    //@FXML JFXDatePicker date ;
   
        
    
   
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
}
@FXML 
public void ajouter_reclamation(ActionEvent event ) throws SQLException,IOException
 {
     CRUD_Reclamation r = new CRUD_Reclamation();
            if(sujet.getText().equals(""))
            {
                alerte.setVisible(true);
            }
            if(r.ListeSujet().contains(sujet.getText()))
            {
                spam.setVisible(true);
            }
            
    else{
            
            Reclamation rec = new Reclamation(sujet.getText(), reclamation.getText() );
            r.ajouterReclamation(rec);
  
}
 }



public void retour4 (ActionEvent event ) throws SQLException,IOException
{
    FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            MenuController Adminct5= fxmlloader.<MenuController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    
}







}
