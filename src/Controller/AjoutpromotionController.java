/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import entities.Promotion;
import entities.Publication;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.crudPromotion;

/**
 * FXML Controller class
 *
 * @author emirc
 */
public class AjoutpromotionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML JFXTextArea contenu;
    @FXML JFXButton ajouter_promotion,selectionner_photo;
    @FXML 
    ImageView imagepromotion;
    String chakala="";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void ajouter_promotion(ActionEvent event) throws SQLException, IOException
    {
        crudPromotion p = new crudPromotion();
        Promotion promo = new Promotion(contenu.getText(),chakala);
        try{
        p.ajouterPromotion(promo);
        }catch(SQLException ex)
                {
                    System.out.println(ex);
                    
                }
        
    }
    
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
            Promotion p=new Promotion();
            imagepromotion.setImage(new Image(fileur1,350,272,true,true));
            //return fileur1;
        }
        chakala=fileur1;
       return fileur1; 
   }
}
