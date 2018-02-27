/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Abonnement;
import Services.CRUD_Abonnement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author samih
 */
public class Afficher_Detail_ProduitController implements Initializable {
@FXML JFXTextField nom_produit ; 
@FXML JFXTextField addresse_produit ; 
@FXML JFXTextField bonplanneur_nom; 
@FXML JFXTextArea description_produit ; 
//@FXML ImageView abonne;
//@FXML ImageView desabonne;
@FXML JFXButton boutonabonne;
List<Integer> listabn = new ArrayList<>();
   @FXML ImageView abonner ;
   @FXML ImageView desabonner ;
   @FXML Text message;
   @FXML Text message2;
   @FXML AnchorPane abonnePane ;
   @FXML AnchorPane desabonnePane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CRUD_Abonnement ca = new CRUD_Abonnement();
        listabn=ca.afficheridprodAbonnement(InscriController.current_user.getId());
        nom_produit.setText(AfficherproduitController.current_produit.getNom());
        addresse_produit.setText(AfficherproduitController.current_produit.getAdresse());
        description_produit.setText(AfficherproduitController.current_produit.getDescription());
      
        if (listabn.contains(AfficherproduitController.current_produit.getId()))
        {
            
            desabonnePane.setVisible(false);
            abonnePane.setVisible(true);
        }
        else 
        {
            desabonnePane.setVisible(true);
            abonnePane.setVisible(false);
        }
     
 
        
   
    }   
    @FXML 
            
            public void retour_affiche_produit (ActionEvent event ) throws IOException{ 
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/afficherproduit.fxml"));
        Parent root = (Parent)fxmlLoader.load();
      
    AfficherproduitController ncont = fxmlLoader.<AfficherproduitController>getController();
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(scene);
        stage.show();
            }
            @FXML 
            
            public void go_to_Livraison (ActionEvent event ) throws IOException{ 
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Livraison.fxml"));
        Parent root = (Parent)fxmlLoader.load();
      
    LivraisonController ncont = fxmlLoader.<LivraisonController>getController();
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(scene);
        stage.show();
            }
      
            public void BasculeAb(ImageView N1,ImageView N2){
        if(N1.isVisible()) {
            N1.setVisible(false);
            N2.setVisible(true);
        }else {
            N1.setVisible(true);
            N2.setVisible(false);
        }
    }
            
            
    
   
    
    
    public void abonne () throws SQLException,IOException
    {
        CRUD_Abonnement cr = new CRUD_Abonnement();
        Abonnement a = new Abonnement();
        cr.ajouterAbonnement(AfficherproduitController.current_produit.getId());
        abonnePane.setVisible(true);
        desabonnePane.setVisible(false);
    }
    
    
    public void desabonne () throws SQLException,IOException
    {
        CRUD_Abonnement cr = new CRUD_Abonnement();
        cr.supprimerAbonnement(AfficherproduitController.current_produit.getId());
        abonnePane.setVisible(false);
        desabonnePane.setVisible(true);
        message2.setVisible(true);

        
    }
     @FXML
    private void go_to_reclamation(ActionEvent event) throws  IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/FXMLAjout.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    FXMLAjoutController ncont = fxmlLoader.<FXMLAjoutController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
        
    }
    
                


}
            
             
          
          
            
            
           
           
            
            

