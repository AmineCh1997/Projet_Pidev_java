package Entities;

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
import Services.CRUD_Reclamation;

/**
 *
 * @author Yacine
 */
public class ButtonCellModifierReclam extends TableCell<Disposer.Record, Boolean> {

      Button cellButton = new Button("Modifier");
      
    public ButtonCellModifierReclam() {
        
        cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    updateItem(Boolean.TRUE, true);
                    // get Selected Item
                       
                    
//                	Reclamation currentRec = (Reclamation) ButtonCellModifierReclam.this.getTableView().getItems().get(ButtonCellModifierReclam.this.getIndex());
//                        CRUD_Reclamation cr = new CRUD_Reclamation();   
//                        cr.modifierReclamation(currentRec);
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
    
