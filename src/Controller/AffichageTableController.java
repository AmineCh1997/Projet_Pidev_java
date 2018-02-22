/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.ButtonCellProd;
import Entities.commentaire;
import Services.CrudCommentaire;
import com.sun.prism.impl.Disposer.Record;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
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
 * @author ESPRIT
 */
public class AffichageTableController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private TableView<commentaire> table=new TableView();
    @FXML private TableColumn<commentaire,Integer> id;
    @FXML private TableColumn<commentaire,Integer> idp;
    @FXML private TableColumn<commentaire,Integer> idu;
    @FXML private TableColumn<commentaire,String> texte;
    @FXML private TableColumn supp;
    int idchoisi=-1;
    @FXML Button retour;
     private final Button ButtonCellCat = new Button("Delete");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
        try {
            loadtable();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<commentaire>(){
         @Override
                 public void changed (ObservableValue<? extends commentaire>observable,commentaire oldValue,commentaire newValue) {
                     
                     
                     if (newValue!=null){
                         System.out.println(newValue.getId_commentaire());
                         idchoisi=newValue.getId_commentaire();
                        
                             afficher();
                        
                         
                         
                   
                     }
                 }
        });      
    }
    
        
    
        private void afficher() 
        {
            id.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
            idp.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
            idu.setCellValueFactory(new PropertyValueFactory<>("iduser"));
            texte.setCellValueFactory(new PropertyValueFactory<>("texte"));
            
            supp.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        supp.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCellProd();
            }
                
        });
            
        }
        
        private void loadtable() throws SQLException
        {
            System.out.println("a");
            CrudCommentaire cc=new CrudCommentaire();
            table.setItems(cc.afficherlescommentaire1());
            
            
        }
        
        public void retour1 (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/ajouter.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    AjouterController ncont = fxmlLoader.<AjouterController>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }
        
     
    
}
