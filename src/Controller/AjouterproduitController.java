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
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Services.GestionCategorie;
import Services.GestionProduit;
import Entities.Produit;
import java.io.IOException;
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
    @FXML private JFXTextField adresseproduit ;
    @FXML private ImageView imageproduit ;
    String selectedC="" ;
    String path="file:///C:/Users/Amine/Pictures/erreur.png";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GestionCategorie Gc = new GestionCategorie();
        
        try {
            categoriecombo.getItems().addAll(Gc.afficher_categorieList());
        } catch (SQLException ex) {
            Logger.getLogger(AjouterproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
        p.setVille(villeproduit.getText());
        GestionCategorie Gc = new GestionCategorie();       
        p.setId_cat(Gc.getidbyname(selectedC ));
        p.setImg(path);
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
    
    
    
    
}
