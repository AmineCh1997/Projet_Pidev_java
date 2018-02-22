/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTreeTableView;
import com.sun.prism.impl.Disposer.Record;
import entities.Reclamation;
import entities.ButtonCell;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import service.CRUD_Reclamation;

/**
 * FXML Controller class
 *
 * @author Yacine
 */
public class FXMLAdminReclamController implements Initializable {

    @FXML AnchorPane bg ;
    @FXML JFXButton boutonaff;
    @FXML JFXButton affichage;
    @FXML JFXButton retour;
 
    @FXML TableView<Reclamation> reclamTable;
    @FXML TableColumn<Reclamation, String> Sujet;
    @FXML TableColumn<Reclamation, Integer> ID;
    @FXML TableColumn<Reclamation, Date> Date;
    @FXML TableColumn BoutonSupp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setrec();
        try {
            loadtable();
        } catch (SQLException ex){
            Logger.getLogger(FXMLAdminReclamController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    /*public void afficher_reclamation(ActionEvent event ) throws SQLException
 {
     CRUD_Reclamation r = new CRUD_Reclamation();
            Reclamation rec = new Reclamation();
           //r.afficherReclamation();
        String listString = String.join("\n", r.afficherReclamation());
        blasa.setText(listString);
            
    
            
}*/
    private void setrec() 
    {
        //System.out.println("setrec");
        ID.setEditable(true);
        Sujet.setEditable(true);
        reclamTable.setEditable(true);

        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        
        BoutonSupp.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        
        BoutonSupp.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
                
            }
        
        });
        
        
        

        
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
    private void loadtable() throws SQLException
    {
     
        CRUD_Reclamation rec = new CRUD_Reclamation();
        reclamTable.setItems(rec.afficherReclamOB());
        
        
        
        
    }
    
    public void retour(ActionEvent event ) throws SQLException, IOException 
  {
      FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Projet_Pidev/FXMLAjout.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            FXMLAjoutController Adminct2= fxmlloader.<FXMLAjoutController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
  }
    
    
    
  
    
    
 
    
    
}


 /*public void retour(ActionEvent event ) throws SQLException, IOException 
  {
      FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("FXMLAjout.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            FXMLAjoutController Adminct2= fxmlloader.<FXMLAjoutController>getController();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
  }*/


    