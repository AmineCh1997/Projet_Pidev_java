/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import com.sun.prism.impl.Disposer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

/**
 *
 * @author samih
 */
public class ButtonCell extends TableCell<Disposer.Record, Boolean> {
Button cellButton = new Button(" Bannir ");
    public ButtonCell() {
       
     
        cellButton.setOnAction(new EventHandler<ActionEvent>(){
       
                @Override
                public void handle(ActionEvent t) {
                    updateItem(Boolean.TRUE, true);
                    // get Selected Item
                       
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
    

