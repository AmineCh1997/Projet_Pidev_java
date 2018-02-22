package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JTextField;
import Controller.AjouterController;
import Controller.MoyenneController;
import Entities.avis;
import Entities.avis;
import Entities.commentaire;
import Services.CrudAvis;

/**
 * FXML Controller class
 *
 * @author ESPRIT
 */
public class Avis1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML TextField id_produit;
    @FXML RadioButton a;
    @FXML RadioButton b;
    @FXML RadioButton c;
    @FXML RadioButton d;
    @FXML RadioButton e;
    @FXML Button btn;
     ActionEvent event;
     @FXML Button affiche;
    @FXML
    private ToggleGroup MYgroup;
    @FXML Button supp;
    @FXML
    CrudAvis ca=new CrudAvis();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        System.err.println(radioSelect(event));
              
    }    
    @FXML
    public String radioSelect(ActionEvent event){
        String selected ="";
        if (a.isSelected())
        {
            selected=""+1;
        }
        if (b.isSelected())
        {
            selected=""+2;
        }
        if (c.isSelected())
        {
            selected=""+3;
        }
        if (d.isSelected())
        {
            selected=""+4;
        }
        if (e.isSelected())
        {
            selected=""+5;
        }
        System.out.println(selected); 
      return selected;
        
    }
    

/*String st=radioSelect(event);
    int num=Integer.parseInt(st);*/
    @FXML
    public void ajouter_avis(ActionEvent event) throws SQLException
    {
        String st=radioSelect(event);
    int num=Integer.parseInt(st);

        avis p = new avis(id_produit.getText(), num);
        try{
        ca.insertST(p);
        }catch(SQLException ex)
                {
                    System.out.println(ex);
                    
                }
    } 
    @FXML
     public void consulter (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/moyenne.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
         MoyenneController ncont = fxmlLoader.<MoyenneController>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
}
     public void supprimer  (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/supprimeravis.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
         SupprimeravisController ncont = fxmlLoader.<SupprimeravisController>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
}
}
