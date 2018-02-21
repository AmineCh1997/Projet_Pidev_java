/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import com.jfoenix.controls.JFXButton;
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
public class SuppressionpromotionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML JFXButton supprimer_promotion,retour;
    @FXML JFXTextField idsupp;
    crudPromotion crud = new crudPromotion();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void supprimer_promotion(ActionEvent event) throws SQLException
    {
        int i= Integer.parseInt(idsupp.getText());
        crud.supprimerPromotion(i);
        //msg.setVisible(true);

    }
    
}
