/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.stage.Stage;
import Services.crudPublication;

/**
 * FXML Controller class
 *
 * @author emirc
 */
public class ModificationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML JFXButton modifier,retour;
    @FXML JFXTextField idamodifier;
    @FXML JFXTextArea contenuamodifier;
    crudPublication crud = new crudPublication();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void modifier_publication(ActionEvent event) throws SQLException
    {
        int i= Integer.parseInt(idamodifier.getText());
        crud.modifierPublication(i, contenuamodifier.getText());
        
    }
    public void retour(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/ajout.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
            AjoutController Ajpct= fxmlloader.<AjoutController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
}
