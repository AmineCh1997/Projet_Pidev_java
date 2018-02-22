/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import Entities.user;
import Services.CRUD_USER;
import Utiles.Basededonne;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
public class InscriController implements Initializable {
     Connection cnx = Basededonne.getInstance().getConnection();
 @FXML JFXTextField Pseudo ;
 @FXML JFXPasswordField Mot_passe ;
 @FXML Label LabelErreur ;
 @FXML Label labelBann;
 
 public static user current_user;
 CRUD_USER cr = new CRUD_USER();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      
     
    }   
   
      @FXML private void connection_user(ActionEvent event)throws SQLException, IOException
    {
        
       cr.authentification(Pseudo.getText(), Mot_passe.getText());
        if (current_user != null )
        {
        if(current_user.getRole()==0)
        {
           
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    MenuController ncont = fxmlLoader.<MenuController>getController();    
    Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();  
        }
        else if (current_user.getRole()==1){
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/adminDashboard.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    AdminDashboardController ncont = fxmlLoader.<AdminDashboardController>getController();    
    Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();  
        }
        else if (current_user.getRole()==2){
            labelBann.setVisible(true);
            Pseudo.clear();
            Mot_passe.clear();
        }
        }
        else 
        {
            
            LabelErreur.setVisible(true);
            Pseudo.clear();
            Mot_passe.clear();
        }

    }
        

    @FXML
    private void NewTest(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/FXMLDocument.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    FXMLDocumentController ncont = fxmlLoader.<FXMLDocumentController>getController();
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }
      @FXML
    private void go_mot_passe(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/EnvoieMotPasse.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    Enovie_mot_passeController ncont = fxmlLoader.<Enovie_mot_passeController>getController();
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }


    
}
