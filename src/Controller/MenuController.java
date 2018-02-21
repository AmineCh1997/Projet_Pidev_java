/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.InscriController.current_user;
import Services.CRUD_USER;
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
 * @author samih
 */
public class MenuController implements Initializable {
    CRUD_USER cr = new CRUD_USER();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
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
}
