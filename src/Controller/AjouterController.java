/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Entities.commentaire;
import Services.CrudCommentaire;

/**
 * FXML Controller class
 *
 * @author ESPRIT
 */
public class AjouterController implements Initializable {

    
    
    @FXML JFXTextArea cin_personne;
    @FXML JFXTextArea id_prduit;
    @FXML JFXTextArea commentaire;
    @FXML Button ajouter;
    @FXML AnchorPane bg;
    
    CrudCommentaire cr=new CrudCommentaire();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
   public void ajouter_commentaire(ActionEvent event) throws SQLException
    {
        
        commentaire p = new commentaire(cin_personne.getText(),id_prduit.getText(),commentaire.getText());
        try{
        cr.insertST(p);
        }catch(SQLException ex)
                {
                    System.out.println(ex);
                    
                }
    } 
   @FXML
    private void NewTest(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/FXMLafficher1.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    FXMLafficher1Controller ncont = fxmlLoader.<FXMLafficher1Controller>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }
    @FXML
   private void modifier (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/FXMLmodifier.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    FXMLmodifierController ncont = fxmlLoader.<FXMLmodifierController>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
}

@FXML
    private void supprimer(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/FXMLsupprimer.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    FXMLsupprimerController ncont = fxmlLoader.<FXMLsupprimerController>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
}}
    

