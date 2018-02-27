/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Services.GestionCategorie;
import Services.GestionProduit;
import Entities.Produit;
import Services.CRUD_USER;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 * FXML Controller class
 *
 * @author Amine
 */
public class AjouterproduitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private JFXComboBox categoriecombo ; 
    @FXML private JFXTextField nomproduit ;
    @FXML private JFXTextField descriptionproduit ;
    @FXML private JFXTextField villeproduit ;
    ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Tunis",
        "Manouba",
        "Ariana",
        "Béja",
        "Ben Arous",
        "Bizerte",
        "Gabes",
        "Gafsa",
        "Jendouba",
        "Kairouan",
        "Kasserine",
        "Kebili",
        "Kef",
        "Mahdia",
        "Medenine",
        "Monastir",
        "Nabeul",
        "Sfax",
        "Sidi Bouzid",
        "Siliana",
        "Sousse",
        "Tataouine",
        "Tozeur",
        "Zaghouen"
    );
    @FXML private JFXComboBox<String> combo_ville ;
    @FXML private JFXTextField adresseproduit ;
    @FXML private ImageView imageproduit ;
    String selectedVille="";
    String selectedC="" ;
    String path=" file:///C:\\\\Users\\\\samih\\\\OneDrive\\\\Bureau\\\\samih.jpg";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GestionCategorie Gc = new GestionCategorie();
        CRUD_USER cr = new CRUD_USER();
        combo_ville.getItems().addAll(options);
        
     
        try {
            categoriecombo.getItems().addAll(Gc.afficher_categorieList());
        } catch (SQLException ex) {
            Logger.getLogger(AjouterproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        combo_ville.getSelectionModel().selectedItemProperty()
    .addListener(new ChangeListener<String>() {
            //private String newValue;
        public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
            selectedVille=newValue ;
            
            
            System.out.println("Value is: "+newValue);
        }
           
        });
        
        categoriecombo.getSelectionModel().selectedItemProperty()
    .addListener(new ChangeListener<String>() {
            //private String newValue;
        public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
            selectedC=newValue ;
            System.out.println("Value is: "+newValue);                       
        }            
        });
        
        
        
        
    } 
    @FXML
    public void upload_img(ActionEvent event)
    {
        FileChooser filech = new FileChooser();
        Stage stage = new Stage();
        File file = filech.showOpenDialog(stage);
       if(file!=null)
       {
           String msg="file:\\\\\\"+file.getPath();
            msg=msg.replace("\\","/");
            imageproduit.setImage(new Image(msg,400,250,true,true));           
            path=msg ;
        System.out.println(path);
          
       }
       
    }
    
    public void ajouterproduit(ActionEvent event) throws SQLException
    {
        
        Produit p = new Produit();
        p.setNom(nomproduit.getText());
        p.setDescription(descriptionproduit.getText());
        p.setAdresse(adresseproduit.getText());
        p.setVille(selectedVille);
        GestionCategorie Gc = new GestionCategorie();       
        p.setId_cat(Gc.getidbyname(selectedC ));
        p.setImg(path);
       p.setId_user(InscriController.current_user.getId());
        GestionProduit Gp = new GestionProduit();
        Gp.ajouter_produit(p);
    }
    @FXML
    public void back(ActionEvent event) throws IOException
    {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/afficherproduit.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    AfficherproduitController ncont = fxmlLoader.<AfficherproduitController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();   
    }
    
            public void go_to_menu(ActionEvent event) throws IOException
    {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/AjouterMenu.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    AjouterMenuController ncont = fxmlLoader.<AjouterMenuController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();   
    }
    
    
    
    
}
