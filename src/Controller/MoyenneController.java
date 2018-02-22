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
import Entities.Moyenne;
import Entities.avis;
import Services.CrudAvis;

/**
 * FXML Controller class
 *
 * @author ESPRIT
 */
public class MoyenneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Button retour;
    @FXML Button affiche;
    @FXML TextField idp;
    @FXML TextField aff;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
     public void consulter (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Avis1.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
         Avis1Controller ncont = fxmlLoader.<Avis1Controller>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
}
     public void afficher(ActionEvent event) throws SQLException
    {
         String q=idp.getText();
        avis c=new avis(q);
        CrudAvis cr = new CrudAvis();
        
        
        
        String listString;
        Moyenne moyenne=new Moyenne(0);
        
         listString = String.join("\n ",cr.afficherlamoyenne(moyenne, c));
         //float amount=100.00f;
//String strAmount=String.valueOf(amount);
String moy=String.valueOf(moyenne.getMoyenne_produit());
        aff.setText(moy);
                
                
                }
}
