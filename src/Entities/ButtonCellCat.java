/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import com.sun.prism.impl.Disposer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import Services.GestionCategorie;

/**
 *
 * @author Amine
 */
public class ButtonCellCat extends TableCell<Disposer.Record, Boolean> {

      Button cellButton = new Button("Delete");
      
    public ButtonCellCat() {
        
        cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    updateItem(Boolean.TRUE, true);
                    // get Selected Item
                        //Produit p = (Produit) ButtonCellCat.this.getTableView().getItems().get(ButtonCellCat.this.getIndex());
                	Categorie currentCat = (Categorie) ButtonCellCat.this.getTableView().getItems().get(ButtonCellCat.this.getIndex());
                        GestionCategorie Gc = new GestionCategorie();   
                    try {
                        Gc.supprimer_categorie(currentCat);
                    } catch (SQLException ex) {
                        Logger.getLogger(ButtonCellCat.class.getName()).log(Level.SEVERE, null, ex);
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
    

