/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Services.crudPromotion;

/**
 * FXML Controller class
 *
 * @author emirc
 */


public class ModificationpromotionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML JFXButton modifier_promotion,retour;
    @FXML JFXTextField idmod;
    @FXML JFXTextArea contenumod;
    crudPromotion crud = new crudPromotion();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void modifier_promotion(ActionEvent event) throws SQLException
    {
        int i= Integer.parseInt(idmod.getText());
        crud.modifierPromotion(i, contenumod.getText());
        
    }
}
