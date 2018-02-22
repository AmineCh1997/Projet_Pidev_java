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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Entities.avis;
import Services.CrudAvis;

/**
 * FXML Controller class
 *
 * @author ESPRIT
 */
public class SupprimeravisController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML TextField id;
    @FXML Button supp;
    @FXML Button retour1;
    CrudAvis ca=new CrudAvis();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
     public void supprimer(ActionEvent event) throws SQLException
    {
         
         
        avis c=new avis();
        
        String b=id.getText();
        int a=Integer.parseInt(b);
        c.setId(a);
        
        ca.supprimeravis(c);
                    
                }
     @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Avis1.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    Avis1Controller ncont = fxmlLoader.<Avis1Controller>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }
}
