package Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controller.Gerer_userController;
import Controller.ModifierController;
import com.sun.prism.impl.Disposer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import Services.CRUD_Reclamation;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Yacine
 */
public class ButtonCellReclamation extends TableCell<Disposer.Record, Boolean> {

      Button cellButton = new Button("Supprimer");
      
    public ButtonCellReclamation() {
        
        cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        updateItem(Boolean.TRUE, true);
                        // get Selected Item
                        
                        Reclamation currentRec = (Reclamation) ButtonCellReclamation.this.getTableView().getItems().get(ButtonCellReclamation.this.getIndex());   
                        CRUD_Reclamation cr = new CRUD_Reclamation();
                        cr.supprimerReclamation(currentRec);
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Modifier.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                        
                        ModifierController ncont = fxmlLoader.<ModifierController>getController();
                        Scene scene = new Scene(root,1200,800);
                        Stage stage = (Stage) ( (Node) t.getSource()).getScene().getWindow() ;
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonCellReclamation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        }
                     
            });
        }
      protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
            
      }
        
        
    }
    

