/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JTextField;
import Entities.commentaire;
import Services.CrudCommentaire;

/**
 * FXML Controller class
 *
 * @author ESPRIT
 */
public class FXMLsupprimerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Button supprimer;
    @FXML JFXTextArea id;
    CrudCommentaire cr=new CrudCommentaire();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
     public void supprimer(ActionEvent event) throws SQLException
    {
         
         
        commentaire c=new commentaire();
        
        String b=id.getText();
        int a=Integer.parseInt(b);
        c.setId_commentaire(a);
        
        cr.supprimercommentaire(c);
                    
                }
     @FXML
   private void retour (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/ajouter.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
         AjouterController ncont = fxmlLoader.<AjouterController>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
}
      
}
