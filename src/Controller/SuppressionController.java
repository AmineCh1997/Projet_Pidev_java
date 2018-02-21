/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
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
import services.crudPublication;

/**
 * FXML Controller class
 *
 * @author emirc
 */
public class SuppressionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Label msg; 
    @FXML JFXButton supprimer_publication,retour;
    @FXML JFXTextField idsupp;
    crudPublication crud=new crudPublication();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void supprimer_publication(ActionEvent event) throws SQLException
    {
        int i= Integer.parseInt(idsupp.getText());
        crud.supprimerPublication(i);
        msg.setVisible(true);

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
