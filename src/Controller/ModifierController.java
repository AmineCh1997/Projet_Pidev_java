/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import Entities.Reclamation;
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
import javafx.stage.Stage;
import Services.CRUD_Reclamation;

/**
 * FXML Controller class
 *
 * @author Yacine
 */
public class ModifierController implements Initializable {

    @FXML JFXTextField idupdate;
    @FXML JFXTextArea sujetupdate;
    @FXML JFXTextArea reclamupdate;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public void retour3(ActionEvent event ) throws SQLException, IOException 
  {
      FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/adminDashboard.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            AdminDashboardController Adminct3= fxmlloader.<AdminDashboardController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
  }
    
    public void modifier_reclamation (ActionEvent event ) throws SQLException,IOException
    {
        CRUD_Reclamation r = new CRUD_Reclamation();
        Reclamation rec = new Reclamation(sujetupdate.getText(), reclamupdate.getText());
            String text = idupdate.getText();
            int number = Integer.parseInt(text);
            r.modifierReclamation(rec, number);
            
            
            
            
         
    }

    
}
