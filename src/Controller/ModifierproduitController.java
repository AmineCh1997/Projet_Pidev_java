/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Produit;
import Services.GestionProduit;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class ModifierproduitController implements Initializable {
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
    @FXML
    private ImageView photoproduit;
    @FXML
    private JFXTextField nomproduit;
    @FXML
    private JFXTextField adresseproduit;
    @FXML
    private JFXTextField villeproduit;
    @FXML
    private JFXTextArea descproduit;
    @FXML
    private ComboBox<String> comboproduits ;
    List<String> nomdesproduits = new ArrayList<>();
    String selectedV="";
    String selectedP="";
    String path="";
    String tas="";
    int idcurrentprod=0 ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_ville.getItems().addAll(options);
        // TODO
        
        GestionProduit Gp = new GestionProduit();
        
        try {
            for(int i=0 ; i<Gp.getproduitbyuser(1).size() ;i++)
            {
                nomdesproduits.add(Gp.getproduitbyuser(1).get(i).getNom());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboproduits.getItems().addAll(nomdesproduits);
        
        comboproduits.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {         
        public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
            selectedP=newValue ;
            try {
                setInfoprod();
            } catch (SQLException ex) {
                Logger.getLogger(ModifierproduitController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Value is: "+newValue);
        }
        });
        combo_ville.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {         
        public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
            selectedP=newValue ;
            try {
                setInfoprod();
            } catch (SQLException ex) {
                Logger.getLogger(ModifierproduitController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Value is: "+newValue);
            selectedV=newValue;
        }
        });
    
    }
    
    
     public void setInfoprod() throws SQLException
        {
            System.out.println(InscriController.current_user.getId());
            int iduser=InscriController.current_user.getId();
            GestionProduit Gp = new GestionProduit();
            for(int i =0 ; i<Gp.getproduitbyuser(iduser).size() ;i++)
            {
                if(selectedP.equals(Gp.getproduitbyuser(iduser).get(i).getNom()))
                {
                    nomproduit.setText(Gp.getproduitbyuser(iduser).get(i).getNom());
                    descproduit.setText(Gp.getproduitbyuser(iduser).get(i).getDescription());
                    adresseproduit.setText(Gp.getproduitbyuser(iduser).get(i).getAdresse());                   
                    photoproduit.setImage(new Image(Gp.getproduitbyuser(iduser).get(i).getImg(),300,150,true,true));
                    tas=Gp.getproduitbyuser(iduser).get(i).getImg();
                    idcurrentprod=Gp.getproduitbyuser(iduser).get(i).getId();
                }
                else
                {
                    System.out.println("PAS DE PRODUITS");
                }
                
            }
            
        }
     
     public void upload_img(ActionEvent event)
    {
        FileChooser filech = new FileChooser();
        Stage stage = new Stage();
        File file = filech.showOpenDialog(stage);
       if(file!=null)
       {
           String msg="file:\\\\\\"+file.getPath();
            msg=msg.replace("\\","/");
            photoproduit.setImage(new Image(msg,400,250,true,true));           
            path=msg ;
        System.out.println(path);
           
       }
       
    }
     public void changer_info(ActionEvent event) throws SQLException
     {
         Produit P = new Produit();
         P.setId_user(1);
         P.setId(idcurrentprod);
         P.setNom(nomproduit.getText());
         P.setVille(selectedV);
         P.setDescription(descproduit.getText());
         P.setAdresse(adresseproduit.getText());
         
         
         GestionProduit Gp = new GestionProduit();
         if(!nomproduit.getText().equals("") && !selectedV.equals("") && !descproduit.getText().equals("")
                 && !adresseproduit.getText().equals("") )
         {
             if(path.equals(""))
             {
                  P.setImg(tas);
             }
            
             else
             {
                P.setImg(path); 
             }
             
             
             Gp.modifier_produit(P);
         }
         
         else
             System.out.println("ferghin");
         
     }
      @FXML
        public void retour1 (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/afficherproduit.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    AfficherproduitController ncont = fxmlLoader.<AfficherproduitController>getController();
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }
}
