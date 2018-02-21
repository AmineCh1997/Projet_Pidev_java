/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import entities.Publication;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.crudPublication;


/**
 * FXML Controller class
 *
 * @author emirc
 */

public class AffichageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Label affichage;
    @FXML JFXButton retour;
    @FXML
    private AnchorPane anchorpane;
    crudPublication crud=new crudPublication();
    List<Publication> listePub = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       listePub=crud.afficherPublication();
       for(int i=0;i<listePub.size();i++)
       {
           Pane currentP=new Pane();
           currentP.setPrefSize(400, 400);
            currentP.setStyle("-fx-background-color : blue");
           currentP.setStyle("-fx-border-color : black");
           Label labelContenu = new Label(listePub.get(i).getContenu());
           labelContenu.setPrefSize(166, 87);
           labelContenu.setLayoutX(13);
           labelContenu.setLayoutY(28);
           
           /*DatePicker datepicker=new DatePicker(listePub.get(i).getDatepublication().toLocalDate());
           datepicker.setLayoutX(13);
           datepicker.setLayoutY(128);
           datepicker.setDisable(true);*/
           
           Label labelDate = new Label(listePub.get(i).getDatepublication().toString());
           labelDate.setPrefSize(200, 87);
           labelDate.setLayoutX(13);
           labelDate.setLayoutY(128);
           //System.out.println(listePub.get(i).getPhoto());
      ImageView img = new ImageView();
      //Image img1=new Image
           img.setImage(new Image(listePub.get(i).getPhoto(),200,150,true,true));
           img.setLayoutX(0);
           img.setLayoutY(200);
            currentP.getChildren().add(img);
             
           currentP.getChildren().add(labelContenu);
           currentP.getChildren().add(labelDate);
           currentP.setLayoutX((i%2)*400);
           currentP.setLayoutY((i/2)*400);
           anchorpane.getChildren().add(currentP);
       }
    }    
    
    
    public void retour(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/view/ajout.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
            AjoutController Ajct= fxmlloader.<AjoutController>getController();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
}
