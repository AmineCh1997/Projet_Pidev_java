/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.ButtonCellSuppMenu;
import Entities.Menu;
import Entities.Produit;
import Services.GestionMenu;
import Services.GestionProduit;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author samih
 */
public class AjouterMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML JFXTextField nomplat ;
    @FXML JFXTextField prix ;
    @FXML JFXComboBox comboprod ;
//    @FXML TableView tablemenu ;
    @FXML 
    private TableView<Menu> tablemenu = new TableView();
    @FXML TableColumn<Menu,String> plat ;
    @FXML TableColumn<Menu,Float> prixcol ;
    @FXML TableColumn supp ;
    int idprodselect=0;
     List<String> nomdesproduits = new ArrayList<>();
     public String selectedP="";
     GestionProduit Gp = new GestionProduit();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        try {
            for(int i=0 ; i<Gp.getproduitbyuser(InscriController.current_user.getId()).size() ;i++)
            {
                nomdesproduits.add(Gp.getproduitbyuser(InscriController.current_user.getId()).get(i).getNom());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboprod.getItems().addAll(nomdesproduits);
        
        comboprod.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {         
        public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
            tablemenu.getItems().clear();
            selectedP=newValue ;
            List<Produit> t = new ArrayList<>();
        try {
            t=Gp.getproduitbyuser(InscriController.current_user.getId());
        } catch (SQLException ex) {
            Logger.getLogger(AjouterMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0 ; i<t.size()  ;i++)
        {
            if(t.get(i).getNom().equals(selectedP))
            {
                idprodselect=t.get(i).getId();
                System.out.println(idprodselect);
            }
            
        }
        setcoMenu();
        try {
            loadtableMenu();
        } catch (SQLException ex){
            Logger.getLogger(AjouterMenuController.class.getName()).log(Level.SEVERE,null,ex);
        }
        
            
            System.out.println("Value is: "+newValue);
        }
        });
        ////
         
        /////
        
        
        
        // TODO
    }    
    
    public void ajoutermenu(ActionEvent event) throws SQLException
    {
    
            Menu m = new Menu();
            GestionMenu Gm = new GestionMenu();
            m.setPlat(nomplat.getText());
            m.setPrix(Float.parseFloat(prix.getText()));
            List<Produit> t = new ArrayList<>();
            t=Gp.getproduitbyuser(InscriController.current_user.getId());
            for(int i=0 ; i<Gp.getproduitbyuser(InscriController.current_user.getId()).size() ;i++)
            {
                if(t.get(i).getNom().equals(selectedP))
                {
                    idprodselect=t.get(i).getId();
                    m.setId_produit(t.get(i).getId());
                }
                
                
            }
            
            Gm.Ajouter_menu(m);
        
    }
    
     private void setcoMenu()
    {
        System.out.println("setco1");       
        plat.setCellValueFactory(new PropertyValueFactory<>("plat"));
        prixcol.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
        supp.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        supp.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellSuppMenu();
            }
                
        });
       
    }
    private void loadtableMenu() throws SQLException
    {
       
        System.out.println("loadtable1");
        GestionMenu Gm = new GestionMenu(); 
        
        tablemenu.setItems(Gm.afficher_MenuObList(idprodselect));
        
        //tablemenu.getItems().addAll(Gm.afficher_MenuObList(idprodselect));
        System.out.println(idprodselect);
        

    }
    
}
