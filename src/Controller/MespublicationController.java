/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entities.Publication;
import Services.crudPublication;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author emirc
 */
public class MespublicationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    List<Publication> listePub=new ArrayList<>();
    @FXML AnchorPane anchorpane;
    
    crudPublication crud=new crudPublication();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listePub=crud.afficherPublicationParId();
        //=crud.afficherPublication();
       for(int i=0;i<listePub.size();i++)
       {
//           System.out.println(listePub.size());
           Pane currentP=new Pane();
           currentP.setPrefSize(700, 350);
            currentP.setStyle("-fx-background-color : blue");
           currentP.setStyle("-fx-border-color : black");
           Label labelContenu = new Label(listePub.get(i).getContenu());
           labelContenu.setPrefSize(500,87);
           labelContenu.setLayoutX(5);
           labelContenu.setLayoutY(5);
           labelContenu.setFont(new Font(26));
           
           
           /*DatePicker datepicker=new DatePicker(listePub.get(i).getDatepublication().toLocalDate());
           datepicker.setLayoutX(13);
           datepicker.setLayoutY(128);
           datepicker.setDisable(true);*/
           
           Label labelDate = new Label(listePub.get(i).getDatepublication().toString());
           labelDate.setPrefSize(200,87);
           labelDate.setLayoutX(600);
           labelDate.setLayoutY(30);
           
           //System.out.println(listePub.get(i).getPhoto());
      ImageView img = new ImageView();
      //Image img1=new Image
           img.setImage(new Image(listePub.get(i).getPhoto(),380,280,true,true));
           img.setLayoutX(13);
           img.setLayoutY(80);
            currentP.getChildren().add(img);
             
           currentP.getChildren().add(labelContenu);
           currentP.getChildren().add(labelDate);
           currentP.setLayoutX(0);
           currentP.setLayoutY(i*350);
           anchorpane.getChildren().add(currentP);
//           System.out.println(listePub.get(i).getContenu());
           Button btn = new Button();
           btn.setText("Supprimer");
           EventHandler e=new EventHandler() {

               @Override
               public void handle(Event event) {
                   Publication p=new Publication();
                   crudPublication crud=new crudPublication();
                   p.setId(Integer.parseInt(currentP.getId()));
                   try {
                       crud.supprimerPublication(p.getId());
                   } catch (SQLException ex) {
                       Logger.getLogger(MespublicationController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           };
           btn.setOnAction(e);
               
            btn.setLayoutX(600);
           btn.setLayoutY(280);
           currentP.getChildren().add(btn);
           currentP.setId(String.valueOf(listePub.get(i).getId()));
         
       }
    }    
    public void retour(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/Profile.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
            ProfileController Ajct= fxmlloader.<ProfileController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
}
