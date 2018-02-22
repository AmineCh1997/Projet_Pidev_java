/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Mail;
import Services.CRUD_USER;
import com.jfoenix.controls.JFXTextField;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author samih
 */
public class ConfirmationController implements Initializable {
@FXML JFXTextField conf_code ;
@FXML Label labelError;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    
    @FXML
    public void check_code ( ActionEvent event ) throws IOException, SQLException
    {
      if (conf_code.getText().equals(FXMLDocumentController.message))
      {
          labelError.setVisible(false);
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Inscri.fxml"));
        Parent root = (Parent)fxmlLoader.load();
       InscriController ncont = fxmlLoader.<InscriController>getController();
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(scene);
        stage.show();
         CRUD_USER crud=new CRUD_USER();
             crud.insertST(InscriController.current_user);
             Mail email = new Mail();
            
      email.Send_validiation(InscriController.current_user.getPseudouser(),InscriController.current_user.getPassword(),InscriController.current_user.getEmailuser());
      }
      else 
      {
          labelError.setVisible(true);
      }
    }
    
}
