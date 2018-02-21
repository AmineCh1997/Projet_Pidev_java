/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Entities.Mail;
import Entities.user;
import Services.CRUD_USER;
import java.awt.Desktop;
import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author samih
 */
public class ProfileController implements Initializable {
    CRUD_USER CU;
    public String pseudo;
 @FXML Label NomLabel;
 @FXML Label PrenomLabel;
 @FXML Label EmailLabel;
 @FXML Label NumLabel;
 @FXML ImageView ImageUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String PathImage = InscriController.current_user.getPhoto_profile();
       // System.out.println(PathImage);
  NomLabel.setText(InscriController.current_user.getNomuser());
  PrenomLabel.setText(InscriController.current_user.getPrenomuser());
  EmailLabel.setText(InscriController.current_user.getEmailuser());
  NumLabel.setText(InscriController.current_user.getNumerouser());
  if(PathImage!=null)
  ImageUser.setImage(new Image(PathImage, 350,272, true, true));
 }
      @FXML
    private void go_Back_Menu(ActionEvent event) throws IOException {
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    MenuController ncont = fxmlLoader.<MenuController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void upload_action(ActionEvent event) throws SQLException {
        FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("Open Resource File");
Stage stage=new Stage();

File file = fileChooser.showOpenDialog(stage);
if(file!=null){
    String Fileurl="file:\\\\\\"+file.getPath();
    Fileurl=Fileurl.replace("\\", "/");
    ImageUser.setImage(new Image(Fileurl, 350,272, true, true));
    CRUD_USER crud = new CRUD_USER();
    crud.insertPhoto(Fileurl,InscriController.current_user);
    InscriController.current_user.setPhoto_profile(Fileurl);
 
    }
     
    }
    
   
    
}
