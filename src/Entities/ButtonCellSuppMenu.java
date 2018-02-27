/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import Services.GestionMenu;
import com.sun.prism.impl.Disposer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
/**
 *
 * @author samih
 */
public class ButtonCellSuppMenu extends TableCell<Disposer.Record, Boolean> {
Button cellButton = new Button("Supprimer");
      
    public ButtonCellSuppMenu() {
        
        cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    updateItem(Boolean.TRUE, true);
                    // get Selected Item
                       
                	Menu currentMenu = (Menu) ButtonCellSuppMenu.this.getTableView().getItems().get(ButtonCellSuppMenu.this.getIndex());
                        GestionMenu Gm = new GestionMenu();
                    try {
                        Gm.supprimer_menu(currentMenu);
                    } catch (SQLException ex) {
                        Logger.getLogger(ButtonCellSuppMenu.class.getName()).log(Level.SEVERE, null, ex);
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
    



