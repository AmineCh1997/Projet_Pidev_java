/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entities.Promotion;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import services.crudPromotion;

/**
 * FXML Controller class
 *
 * @author emirc
 */
public class AffichagepromotionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Label affichage;
    @FXML
    private AnchorPane anchorpane;
    crudPromotion crud=new crudPromotion();
    List<Promotion> listePromo = new ArrayList<>();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        listePromo=crud.afficherPromotion();
       for(int i=0;i<listePromo.size();i++)
       {
           Pane currentP=new Pane();
           currentP.setPrefSize(400, 400);
            currentP.setStyle("-fx-background-color : blue");
           currentP.setStyle("-fx-border-color : black");
           Label labelContenu = new Label(listePromo.get(i).getContenu());
           labelContenu.setPrefSize(166, 87);
           labelContenu.setLayoutX(13);
           labelContenu.setLayoutY(28);
           
           /*DatePicker datepicker=new DatePicker(listePub.get(i).getDatepublication().toLocalDate());
           datepicker.setLayoutX(13);
           datepicker.setLayoutY(128);
           datepicker.setDisable(true);*/
           
           
           
           Label labelDate = new Label(listePromo.get(i).getDatepromotion().toString());
           labelDate.setPrefSize(200, 87);
           labelDate.setLayoutX(13);
           labelDate.setLayoutY(128);
           
           ImageView img = new ImageView();
      //Image img1=new Image
           img.setImage(new Image(listePromo.get(i).getPhoto(),200,150,true,true));
           img.setLayoutX(0);
           img.setLayoutY(200);
            currentP.getChildren().add(img);
           
           currentP.getChildren().add(labelContenu);
           currentP.getChildren().add(labelDate);
           //currentP.getChildren().add()
           currentP.setLayoutX((i%2)*400);
           currentP.setLayoutY((i/2)*400);
           anchorpane.getChildren().add(currentP);
       }
        
    }    
    
}
