/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import entities.Publication;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.crudPublication;

/**
 *
 * @author emirc
 */
public class AjoutController implements Initializable {
    
    @FXML
    JFXTextArea contenu;
    @FXML 
    ImageView imagepublication;
    @FXML JFXButton ajouter_publication,afficher,modifier_publication,supprimer_publication,selectionner_photo;
    String chakala="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void ajouter_publication(ActionEvent event) throws SQLException, IOException
    {
        //fileur1=uploadImage(event);
            Publication p=new Publication(contenu.getText(),chakala);
            crudPublication crud=new crudPublication();
            crud.ajouterPublication(p);
          
        /* crudPublication p = new crudPublication();
        Publication pub = new Publication(contenu.getText());
        try{
        p.ajouterPublication(pub,fileur1);
        }catch(SQLException ex)
                {
                    System.out.println(ex);
                    
                }
        */
    }
    
    public void afficher_publication(ActionEvent event) throws IOException
   {
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/view/affichage.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            AffichageController Affct= fxmlloader.<AffichageController>getController();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
   }
    
    public void modifier_publication(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/view/modification.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            ModificationController Modct= fxmlloader.<ModificationController>getController();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
    public void supprimer_publication(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/view/suppression.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
            SuppressionController Suppct= fxmlloader.<SuppressionController>getController();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
    @FXML
    
   public String uploadImage(ActionEvent event) throws SQLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage=new Stage();
        File file= fileChooser.showOpenDialog(stage);
        String fileur1="";
        if(file!=null)
        {
            fileur1="file:\\\\\\"+file.getPath();
            fileur1=fileur1.replace("\\", "/");
            Publication p=new Publication();
            imagepublication.setImage(new Image(fileur1,350,272,true,true));
            //return fileur1;
        }
        chakala=fileur1;
       return fileur1; 
   }
}
