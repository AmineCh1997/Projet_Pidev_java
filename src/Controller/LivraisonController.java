/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Livraison;
import Entities.Menu;


import Services.Crud_Livraison;
import Services.GestionMenu;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author samih
 */
public class LivraisonController implements Initializable {
@FXML JFXTextField nom_produit;
@FXML JFXTextField adresse_produit;
@FXML JFXTextField nombre_produit;
@FXML JFXButton btn_valider;
 @FXML Spinner spinner=new Spinner<Integer>();
    @FXML
    private TableView<Livraison> tabview;
    @FXML
    private JFXComboBox<String> combo_produit;
    @FXML
    private TableColumn<Livraison, Integer> nom_col;
    @FXML
    private TableColumn<Livraison, String> adresse_col;
    @FXML
    private TableColumn<Livraison, Integer> nbr_col;
        @FXML
    private TableColumn<Livraison, String> etat_col;
        String selectedPlat ="";
   
    Crud_Livraison cl = new Crud_Livraison();
    GestionMenu Gm = new GestionMenu();
            
            
            /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

    try {
        combo_produit.getItems().addAll(Gm.afficher_MenuListNom(AfficherproduitController.current_produit.getId()));
    } catch (SQLException ex) {
        Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
    }
    

        
        combo_produit.getSelectionModel().selectedItemProperty()
                    .addListener(new ChangeListener<String>() {
                        //private String newValue;
                        public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                            selectedPlat=newValue ;
                          
                            
                            System.out.println("Value is: "+newValue);
                            
                           
                            
                        }
                        
                    });
//             final Spinner<Integer> spinner = new Spinner<Integer>();
  
        
 
        // Value factory.
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100, 1);
       
        spinner.setValueFactory(valueFactory);
        try {
                Crud_Livraison cl = new Crud_Livraison();
        List<Livraison> list;
        list = cl.displayAllLivraison();
//        for(int i=0;i<list.size();i++)
//        {
//        if(list.get(i).getEtat()==0)
//        {
//            
//        }
//             System.out.println(spinner.getValue());   
tabview.getItems().setAll(list);
nom_col.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
adresse_col.setCellValueFactory(new PropertyValueFactory<>("adresse"));
nbr_col.setCellValueFactory(new PropertyValueFactory<>("nbr_produit"));
etat_col.setCellValueFactory(new PropertyValueFactory<>("etat"));
        } catch (SQLException ex) {
            Logger.getLogger(Gerer_userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
  
 @FXML 
 public void ajout_livraison(ActionEvent event) throws SQLException, IOException
 {   
      int a = 0 ;
          a=    (Integer) (spinner.getValue());
          System.out.println(a);
           System.out.println(selectedPlat);
       Livraison l = new Livraison(InscriController.current_user.getId(),AfficherproduitController.current_produit.getId(),AfficherproduitController.current_produit.getAdresse(),a,0,selectedPlat);
      cl.insertST(l); 
     
      tabview.refresh();
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Livraison.fxml"));
        Parent root = (Parent)fxmlLoader.load();
      
    LivraisonController ncont = fxmlLoader.<LivraisonController>getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(scene);
        stage.show();
        
 }
    
}
