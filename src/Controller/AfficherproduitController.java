/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import Services.GestionCategorie;
import Services.GestionProduit;
import Entities.Produit;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class AfficherproduitController implements Initializable {

    String selectedC ="";
    String beforeselectedC="";
    @FXML
    private ComboBox<String> categoriecombo1 ;
    @FXML
    private AnchorPane AP ;
    private Object Gc;
    @FXML 
    private ScrollPane SP ;
    @FXML 
    private TextArea nomproduit ;
    @FXML
    private TextArea informationsproduit ;
    @FXML 
    private TextArea villeproduit ;
    @FXML
    private ImageView imageproduit ;
    
    Produit selectedP  ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectedP = new Produit();
        
        GestionProduit Gp = new GestionProduit();
         GestionCategorie Gc = new GestionCategorie();
        
        try {
            categoriecombo1.getItems().addAll(Gc.afficher_categorieList());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        categoriecombo1.getSelectionModel().selectedItemProperty()
    .addListener(new ChangeListener<String>() {
            //private String newValue;
        public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
            selectedC=newValue ;
            beforeselectedC = oldValue ;
            
            System.out.println("Value is: "+newValue);
           AP.getChildren().clear();
           try{
               
                afficherproduits(prodsbycat());
            } catch (SQLException ex) {
                Logger.getLogger(AfficherproduitController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }
        
        });
        // TODO
    }   
    public List<Produit> prodsbycat() throws SQLException
    {
        GestionCategorie Gc = new GestionCategorie();
        GestionProduit Gp = new GestionProduit();
         int a =Gc.getidbyname(selectedC);
        return Gp.afficher_produitBycategorie1(a);
    }
    public void afficherproduits(List<Produit> produits)
    {
        int taille = produits.size();
        
       
            
        for(int i=0 ; i<taille ; i++)
        {
           
            Pane currentPane= new Pane();
            currentPane.getChildren().clear();
            Label nomproduit =new Label();
            Label Descriptionproduit = new Label();
            JFXButton button = new JFXButton();
            EventHandler Clicked = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        
                        selectedP=produits.stream()
                                .filter(p->p.getId()==Integer.parseInt(currentPane.getId()))
                                .findFirst().get();
                        afficherproduitselec(selectedP);
                    }
                };
             button.setLayoutX(0);
             button.setLayoutY(0);
             button.setPrefSize(175, 175);
             button.setStyle("-fx-border-color:#F43955");
             button.setOnAction(Clicked);
            //label
            nomproduit.setLayoutX(49);
            nomproduit.setLayoutY(130);
            nomproduit.setPrefSize(90, 18);
            nomproduit.setText("Nom :"+((Produit)produits.get(i)).getNom());
            Descriptionproduit.setLayoutX(49);
            Descriptionproduit.setLayoutY(149);
            Descriptionproduit.setPrefSize(90, 18);  
            Descriptionproduit.setText("Description : "+((Produit)produits.get(i)).getDescription());
            //pane
            currentPane.setLayoutX((i%2)*195+20); 
            currentPane.setLayoutY((i/2)*195+50);
            currentPane.setPrefSize(175, 175);
            currentPane.setStyle("-fx-background-color:white");   
            currentPane.setVisible(true);
            currentPane.setId(String.valueOf(((Produit)produits.get(i)).getId()));
    
    //add components to pane
            currentPane.getChildren().add(button);
            currentPane.getChildren().add(nomproduit);
            currentPane.getChildren().add(Descriptionproduit);
    
     //add pane to Anchorpane       
             AP.getChildren().add(currentPane); 
       
        } 
    }
    public void afficherproduitselec(Produit P)
    {
        nomproduit.setText(P.getNom());
        System.out.println(P.getImg());
        informationsproduit.setText(P.getDescription());
        villeproduit.setText(P.getVille());
        
        if((P.getImg())!=null)
        imageproduit.setImage(new Image(P.getImg(),400,250,true,true));
        
        
        
    }
    @FXML
    public void ajout(ActionEvent event) throws IOException
    {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/ajouterproduit.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    AjouterproduitController ncont = fxmlLoader.<AjouterproduitController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();   
    }
    
    
    
    
}
