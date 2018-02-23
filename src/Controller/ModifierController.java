/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entities.ButtonCellModifierReclam;
import Entities.ButtonCellReclamation;
import Entities.Reclamation;
import Services.CRUD_Reclamation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Yacine
 */
public class ModifierController implements Initializable {

    @FXML JFXTextField idupdate;
    @FXML JFXTextArea sujetupdate;
    @FXML JFXTextArea reclamupdate;
    @FXML AnchorPane bg ;
    @FXML JFXButton boutonaff;
    @FXML JFXButton affichage;
    @FXML JFXButton retour;
 
    @FXML TableView<Reclamation> reclamTable;
    @FXML TableColumn<Reclamation, String> Sujet;
    @FXML TableColumn<Reclamation, Integer> ID;
    @FXML TableColumn<Reclamation, Date> Date;
    @FXML TableColumn<Reclamation, String> Reclamation;
    @FXML TableColumn BoutonSupp;
    @FXML TableColumn BoutonModif;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setrec();
        
        try {
            loadtable();
        } catch (SQLException ex){
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE,null,ex);
        }
        
//        sujetupdate.setText(reclamTable.getSelectionModel().getSelectedItem().getSujet());
//        reclamupdate.setText(reclamTable.getSelectionModel().getSelectedItem().getTextereclamation());
 
    
}
        
        
        
    
    
    
    
    
    
    
    
    private void setrec() 
    {
        //System.out.println("setrec");
//        ID.setEditable(true);
//        Sujet.setEditable(true);
//        reclamTable.setEditable(true);

        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        Reclamation.setCellValueFactory(new PropertyValueFactory<>("textereclamation"));
        
        BoutonSupp.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        
        BoutonSupp.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellReclamation();
                
            }
        
        });
        
        BoutonModif.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        
        BoutonModif.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellModifierReclam();
                
            }
        
        });
        
        
        

        
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        
    }
    private void loadtable() throws SQLException
    {
     
        CRUD_Reclamation rec = new CRUD_Reclamation();
        reclamTable.setItems(rec.afficherReclamOB());
        
        
        
        
    }
    
    
    
    
    public void retour3(ActionEvent event ) throws SQLException, IOException 
  {
      FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/adminDashboard.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            AdminDashboardController Adminct3= fxmlloader.<AdminDashboardController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
  }
    @FXML
    public void modifier_reclamation (ActionEvent event ) throws SQLException,IOException
    {
        CRUD_Reclamation r = new CRUD_Reclamation();
        Reclamation rec = new Reclamation(sujetupdate.getText(), reclamupdate.getText());
//            String text = idupdate.getText();
//            int number = Integer.parseInt(text);
            r.modifierReclamation(rec);
    }
    
    @FXML
    private void Reclam_Modif(javafx.scene.input.MouseEvent event) throws SQLException {
        
        if (reclamTable.getSelectionModel().getSelectedItem() != null) {
        Reclamation selectedReclam = reclamTable.getSelectionModel().getSelectedItem();
        sujetupdate.setText(selectedReclam.getSujet());
        reclamupdate.setText(selectedReclam.getTextereclamation());
    }
        
    }
    
}
