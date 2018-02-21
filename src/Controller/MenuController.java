/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.InscriController.current_user;
import Entities.Publication;
import Services.CRUD_USER;
import Services.crudPublication;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
 * @author samih
 */
public class MenuController implements Initializable {
    CRUD_USER cr = new CRUD_USER();
     Label affichage;
    @FXML JFXButton retour;
    @FXML
    private AnchorPane anchorpane;
    crudPublication crud=new crudPublication();
    List<Publication> listePub = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
     listePub=crud.afficherPublication();
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
            btn.setLayoutX(600);
           btn.setLayoutY(280);
           currentP.getChildren().add(btn);
         
       }
        // TODO
    }    
      @FXML
    private void go_Profile(ActionEvent event) throws IOException, SQLException {
     
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Profile.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    ProfileController ncont = fxmlLoader.<ProfileController>getController();
        Scene scene = new Scene(root,1200, 800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        }
    
    

       @FXML
    private void go_Back_inscri(ActionEvent event) throws IOException {
        current_user=null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Inscri.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    InscriController ncont = fxmlLoader.<InscriController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }
    @FXML
    private void go_to_catalogue(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/afficherproduit.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    AfficherproduitController ncont = fxmlLoader.<AfficherproduitController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }
    
}
