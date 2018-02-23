/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entities.Publication;
import Services.CRUD_USER;
import Services.GestionCategorie;
import Services.crudPublication;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author emirc
 */
public class AjoutController implements Initializable {
    
    @FXML
    JFXTextArea contenu;
    @FXML 
    ImageView imagepublication;
    @FXML JFXButton ajouter_publication,afficher,modifier_publication,supprimer_publication,selectionner_photo;
    String chakala="";
    @FXML private JFXComboBox categoriecombo ;
    @FXML private JFXComboBox<String> comboproduit ;
    String selectedC="";
    String selectedV="";
    String selectedVchanged="";
    String selectedP="";
    List<Integer> listeIdProd=new ArrayList<>();
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
    @FXML private JFXComboBox<String> comboville ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GestionCategorie Gc = new GestionCategorie();
        CRUD_USER cr = new CRUD_USER();
        
     
        try {
            categoriecombo.getItems().addAll(Gc.afficher_categorieList());
        } catch (SQLException ex) {
            Logger.getLogger(AjouterproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //combo box categorie
        categoriecombo.getSelectionModel().selectedItemProperty()
    .addListener(new ChangeListener<String>() {
            //private String newValue;
        public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
            selectedC=newValue ;
            //System.out.println("catego: "+selectedC);
            System.out.println("Value is: "+newValue);                       
        }            
        });
        
        //Combo box ville
        comboville.getItems().addAll(options);
        comboville.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
                selectedV=newValue;
                crudPublication pub=new crudPublication();
        GestionCategorie Gc=new GestionCategorie();
        
         try {
                comboproduit.getItems().addAll(pub.afficher_produitParVille(selectedV,Gc.getidbyname(selectedC)));
            } catch (SQLException ex) {
                Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
                //System.out.println("Changed mta3 rab om l ville: "+selectedV);
                System.out.println("Value is: "+newValue);
                
            }
            
        });
        
        //combo box produit
        crudPublication pub=new crudPublication();
        //System.out.println("lbara: "+selectedV);
        //System.out.println("ville: "+selectedV);
        //System.out.println("catego: "+selectedC);
            
        
      // selectedV=selectedVchanged;
        //test();
        comboproduit.getSelectionModel().selectedItemProperty()
    .addListener(new ChangeListener<String>() {
            //private String newValue;
        
        public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
            selectedP=newValue ;
            
            System.out.println("Value is: "+newValue);   
            
        }            
        });
        
       //System.out.println("ville: "+selectedV);
    }    
    
    public void ajouter_publication(ActionEvent event) throws SQLException, IOException
    {
        //fileur1=uploadImage(event);
        crudPublication crud=new crudPublication();
        System.out.println(selectedP);
         listeIdProd=crud.ajouter_pubParId(selectedP);
         System.out.println("id curre :"+InscriController.current_user.getId());
         System.out.println(listeIdProd);
       for(int i=0;i<listeIdProd.size();i++)
       {
            
        
            Publication p=new Publication(contenu.getText(),chakala,InscriController.current_user.getId(),listeIdProd.get(i));
            
           crud.ajouterPublication(p);
            
       }
       
            //System.out.println(selectedP);
          
        /* crudPublication p = new crudPublication();
        Publication pub = new Publication(contenu.getText());
        try{
        p.ajouterPublication(pub,fileur1);
        }catch(SQLException ex)
                {
                    System.out.println(ex);
                    
                }
        */
    }
    
    public void afficher_publication(ActionEvent event) throws IOException
   {
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/affichage.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            AffichageController Affct= fxmlloader.<AffichageController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
   }
    
    public void modifier_publication(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/modification.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
     
            ModificationController Modct= fxmlloader.<ModificationController>getController();
            Scene scene = new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
    public void supprimer_publication(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/Views/suppression.fxml"));
            Parent root = ( Parent ) fxmlloader.load();
            SuppressionController Suppct= fxmlloader.<SuppressionController>getController();
            Scene scene =new Scene(root,1200,800);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
    @FXML
    
   public String uploadImage(ActionEvent event) throws SQLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage=new Stage();
        File file= fileChooser.showOpenDialog(stage);
        String fileur1="";
        if(file!=null)
        {
            fileur1="file:\\\\\\"+file.getPath();
            fileur1=fileur1.replace("\\", "/");
            Publication p=new Publication();
            imagepublication.setImage(new Image(fileur1,350,272,true,true));
            //return fileur1;
        }
        chakala=fileur1;
       return fileur1; 
   }
   
   public void test()
   {    crudPublication pub=new crudPublication();
        GestionCategorie Gc=new GestionCategorie();
        
         try {
                comboproduit.getItems().addAll(pub.afficher_produitParVille(selectedV,Gc.getidbyname(selectedC)));
            } catch (SQLException ex) {
                Logger.getLogger(AjoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
   }
   
    @FXML
    public void back(ActionEvent event) throws IOException
    {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    MenuController ncont = fxmlLoader.<MenuController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();   
    }
}
