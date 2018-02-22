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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.swing.JTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JTextArea;
import Entities.commentaire;
import Services.CrudCommentaire;

/**
 * FXML Controller class
 *
 * @author ESPRIT
 */
public class FXMLmodifierController implements Initializable {

    /**
     * Initializes the  class.
     */
    @FXML TextField id_commentaire;
    @FXML TextField produit;
    @FXML TextField cin;
    @FXML TextField commentaire;
    /*
    @FXML JTextArea id_commentaires;
    @FXML JTextArea id_produits;
    @FXML JTextArea cin_personnes;
    @FXML JTextArea textes;*/
    @FXML Button modifier;
    CrudCommentaire cr=new CrudCommentaire();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }   
    @FXML
    public void modifier(ActionEvent event) throws SQLException
    {
        
         commentaire p=new commentaire();
        String b=id_commentaire.getText();
         int a=Integer.parseInt(b);
          p.setId_commentaire(a);
        p.setCin_personne(Integer.parseInt(cin.getText()));
        p.setId_produit(Integer.parseInt(produit.getText()));
        p.setTexte(commentaire.getText());
       
        cr.modifiercommentaire(p);
        
    
}
     public void retour1 (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/ajouter.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
         AjouterController ncont = fxmlLoader.<AjouterController>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
}
}