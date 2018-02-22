/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

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

/**
 * FXML Controller class
 *
 * @author Yacine
 */
public class AcceuilController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void reclamation (ActionEvent event ) throws SQLException,IOException
    {
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/FXMLAjout.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            FXMLAjoutController Adminct4= fxmlloader.<FXMLAjoutController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
  }
    
    public void abonnement (ActionEvent event ) throws SQLException,IOException
    {
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/Abonnement.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            AbonnementController Adminct6= fxmlloader.<AbonnementController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
  }
    
}
