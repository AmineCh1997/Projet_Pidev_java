/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Controller.Gerer_userController;
import Services.CRUD_USER;
import com.sun.prism.impl.Disposer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;

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
                    try {
                        updateItem(Boolean.TRUE, true);
                        // get Selected Item
                        user u = (user) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());   
                        CRUD_USER cr = new CRUD_USER();
                        cr.update_role(u.getId());
                     
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Gerer_user.fxml"));
        Parent root = (Parent)fxmlLoader.load();
      
    Gerer_userController ncont = fxmlLoader.<Gerer_userController>getController();
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) t.getSource()).getScene().getWindow() ;
        stage.setScene(scene);
        stage.show();
                    } catch (SQLException ex) {
                        Logger.getLogger(ButtonCell.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonCell.class.getName()).log(Level.SEVERE, null, ex);
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
    

