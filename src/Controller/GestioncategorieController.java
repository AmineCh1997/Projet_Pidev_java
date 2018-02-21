/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXTextArea;
import com.sun.prism.impl.Disposer.Record;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import Entities.ButtonCell;
import Entities.ButtonCellProd;
import Entities.Categorie;
import Services.GestionCategorie;
import Services.GestionProduit;
import Entities.Produit;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class GestioncategorieController implements Initializable {
    @FXML
    private TextField categorie;
    @FXML
    private Label LabelErreur ;
    @FXML 
    private TableView<Categorie> tablecategories = new TableView();
    
    @FXML
    private TableColumn<Categorie,String> namecat ;
    @FXML
    private TableColumn<Categorie,Integer> id ;
    @FXML 
    private TableColumn catasupprimer ;
    
    
    @FXML 
    private TableView<Produit> tableproduits = new TableView();
    @FXML
    private TableColumn<Produit,String> nameprod ;
    @FXML
    private TableColumn<Produit,Integer> idprod ;
    @FXML 
    private TableColumn prodasupprimer ;
    //TableColumn idcat = new TableColumn("ID");
    //TableColumn namecat = new TableColumn("Name");
    
    //private ObservableList<Categorie> CategorieData =FXCollections.observableArrayList();
    //GestionCategorie Gc = new GestionCategorie();
    @FXML
    private Button ajouter;
    @FXML
    private final Button ButtonCell = new Button("Delete");
    
    int idchoisi=-1 ; ;
   
   
    
    
    
    //tablecategories.setEditable(true);
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
    
        GestionCategorie Gc = new GestionCategorie();
       
    
        categorie.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(checkcategorie(categorie.getText()))
                {
                    LabelErreur.setVisible(true);
                    System.out.println("true");
                }
                else
                {
                    LabelErreur.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GestioncategorieController.class.getName()).log(Level.SEVERE, null, ex);            
            }
            //LabelErreur.setVisible(false);
            //System.out.println("false");
        });
        //tablecategories.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        setcoCategorie(); 
        try {
            loadtableCategorie();
        } catch (SQLException ex) {
            Logger.getLogger(GestioncategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
       tablecategories.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Categorie>() {
              @Override
              public void changed(ObservableValue<? extends Categorie> observable,Categorie oldValue, Categorie newValue){
                  if(newValue!=null){
                        System.out.println(newValue.getId());
                        idchoisi=newValue.getId();
                        setcoProduit();
        try {
            loadtableProduit();
        } catch (SQLException ex) {
            Logger.getLogger(GestioncategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
                  }
              //you can add any other value from Student class via getter(getAdr,getMail,...)

              }
          });

       
        
        
        
    }
    
        // TODO 

    @FXML
    public void ajoutercategorie(ActionEvent event) throws SQLException {
        
            GestionCategorie Gc = new GestionCategorie();
            Categorie c = new Categorie(categorie.getText());
             Gc.ajouter_categorie(c);
    }
    public boolean checkcategorie(String s) throws SQLException
    {
        GestionCategorie Gc = new GestionCategorie();
        return Gc.check_categorie().contains(s);
        
    }
    /*public void affichercategorie(ActionEvent event) throws SQLException {
        GestionCategorie Gc = new GestionCategorie();
        String listString = String.join("\n", Gc.afficher_categorieList());
        categoriearea.setText(listString);                        
    }*/
    private void setcoCategorie()
    {
        System.out.println("setco");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        namecat.setCellValueFactory(new PropertyValueFactory<>("nom"));
         catasupprimer.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        catasupprimer.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
                
            }
        
        });
      
        

       
    }
    private void loadtableCategorie() throws SQLException
    {
        System.out.println("loadtable");
        GestionCategorie Gc = new GestionCategorie();                          
        tablecategories.setItems(Gc.afficher_categorieObList());
        //tablecategories.getItems().addAll(Gc.afficher_categorie1());
    }
    
    
    
    
    private void setcoProduit()
    {
        System.out.println("setco1");       
        nameprod.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idprod.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        prodasupprimer.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        prodasupprimer.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCellProd();
            }
                
        });
       
    }
    private void loadtableProduit() throws SQLException
    {
        System.out.println("loadtable1");
        GestionProduit Gp = new GestionProduit(); 
        System.out.println(idchoisi);
        tableproduits.setItems(Gp.afficher_produitBycategorie(idchoisi));
        //tablecategories.getItems().addAll(Gc.afficher_categorie1());
    }
    
    
    
    
}
