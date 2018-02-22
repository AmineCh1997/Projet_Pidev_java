package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.prism.impl.Disposer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import service.CRUD_Reclamation;

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
                    updateItem(Boolean.TRUE, true);
                    // get Selected Item
                       
                	Reclamation currentRec = (Reclamation) ButtonCellReclamation.this.getTableView().getItems().get(ButtonCellReclamation.this.getIndex());
                        CRUD_Reclamation cr = new CRUD_Reclamation();   
                        cr.supprimerReclamation(currentRec);
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
    

