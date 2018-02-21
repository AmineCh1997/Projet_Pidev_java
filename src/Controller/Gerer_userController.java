/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.ButtonCell;
import Entities.user;
import Services.CRUD_USER;
import com.sun.prism.impl.Disposer.Record;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author samih
 */
public class Gerer_userController implements Initializable {
    CRUD_USER cu;
   
    @FXML
    private TableView<user> tabview;
    @FXML
    private TableColumn<user, Integer> id_col;
    @FXML
    private TableColumn<user, String> nom_col;
    @FXML
    private TableColumn<user, String> prenom_col;
        @FXML
    private TableColumn<user, String> email_col;
    @FXML
    private TableColumn<user,String> numero_col;
       @FXML
    private TableColumn  bannir_col;
       @FXML
       private final Button ButtonCell = new Button("Bannir");



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            cu= new CRUD_USER();
            List<user> list=cu.displayAll();
            tabview.getItems().setAll(list);
            id_col.setCellValueFactory(new PropertyValueFactory<>("id")); 
            nom_col.setCellValueFactory(new PropertyValueFactory<>("nomuser"));
            prenom_col.setCellValueFactory(new PropertyValueFactory<>("prenomuser"));
            email_col.setCellValueFactory(new PropertyValueFactory<>("numerouser"));
            numero_col.setCellValueFactory(new PropertyValueFactory<>("emailuser"));
            bannir_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        bannir_col.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
            }
                
        });
        } catch (SQLException ex) {
            Logger.getLogger(Gerer_userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    @FXML
    private void go_back_Dashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/adminDashboard.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    AdminDashboardController ncont = fxmlLoader.<AdminDashboardController>getController();
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(scene);
        stage.show();
        
    }
    // HEllo 
}
