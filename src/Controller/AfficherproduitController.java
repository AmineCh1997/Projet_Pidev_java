/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Abonnement;
import Entities.Produit;
import Services.CRUD_Abonnement;
import Services.GestionCategorie;
import Services.GestionProduit;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class AfficherproduitController implements Initializable {

    String selectedC ="";
    String beforeselectedC="";
    List<Integer> listabn;
    CRUD_Abonnement ca;
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
        ca= new CRUD_Abonnement();
        listabn= ca.afficheridprodAbonnement(InscriController.current_user.getId());

        
        GestionProduit Gp = new GestionProduit();
         GestionCategorie Gc = new GestionCategorie();
         //CRUD_Abonnement cr = new CRUD_Abonnement();
        
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
    public void BasculeAb(ImageView N1,ImageView N2){
        if(N1.isVisible()) {
            N1.setVisible(false);
            N2.setVisible(true);
        }else {
            N1.setVisible(true);
            N2.setVisible(false);
        }
    }
    public void afficherproduits(List<Produit> produits)
    {
        int taille = produits.size();
        
       
            
        for(int i=0 ; i<taille ; i++)
        {
           
            Pane currentPane= new Pane();
            //Pane ABPane = new Pane();
            currentPane.getChildren().clear();
            Label nomproduit =new Label();
            Label Descriptionproduit = new Label();
            JFXButton button = new JFXButton();
            
            ImageView abonne = new ImageView(new Image("/Utiles/coeur2.png",50,50,true,true));
            ImageView desabonne = new ImageView(new Image("/Utiles/coeur.png",50,50,true,true));
            AnchorPane abonnePane = new AnchorPane();
//            AnchorPane desabonnePane = new AnchorPane();
            JFXButton boutonabonner = new JFXButton();

            
            

            
            EventHandler Clicked = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        System.out.println("click");
                        selectedP=produits.stream()
                                .filter(p->p.getId()==Integer.parseInt(currentPane.getId()))
                                .findFirst().get();
                        afficherproduitselec(selectedP);
                    }
                };
            
            
            
            EventHandler abonner;
              
            //boutton ta7t taswiraz
            abonner = new EventHandler() {
                @Override
                public void handle(Event event) {
                    //System.out.println("click");
                     selectedP=produits.stream()
                                .filter(p->p.getId()==Integer.parseInt(currentPane.getId()))
                                .findFirst().get();
                    if(desabonne.isVisible()==false)
                    {
                        
                            //System.out.println("false");
                            //abonne.setImage();
                            
                      
                            BasculeAb(abonne,desabonne);
                            CRUD_Abonnement cr = new CRUD_Abonnement();
                            Abonnement a = new Abonnement();

                        try {
                            cr.ajouterAbonnement(selectedP.getId());
                            //System.out.println(selectedP.getId());
                        } catch (SQLException ex) {
                            Logger.getLogger(AfficherproduitController.class.getName()).log(Level.SEVERE, null, ex);
                        }
 }
                    else 
                    {
                        //System.out.println("else");
                        //desabonne.setImage();
                        
                     
                        
                        BasculeAb(abonne,desabonne);
                        CRUD_Abonnement cr = new CRUD_Abonnement();
                        Abonnement a = new Abonnement();
                        cr.supprimerAbonnement(selectedP.getId());
                    }
                    
                    
                }
            };
             
          desabonne.setLayoutX(0);
          desabonne.setLayoutY(0);
            abonne.setLayoutX(0);
           abonne.setLayoutY(0);
              boutonabonner.setOnAction(abonner);
          
            abonne.setVisible(true);            
            desabonne.setVisible(false);
            
           
            if(listabn.contains(produits.get(i).getId()))
                BasculeAb(abonne, desabonne);
            //abonne.onMouseClickedProperty();
            
          
            boutonabonner.setPrefSize(50, 50);
         
           
            //abonne.onMouseClickedProperty().setValue(abonner);
            //desabonne.onMouseClickedProperty().setValue(desabonner);
            
           
            //CHAKALA
            
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
            abonnePane.getChildren().add(abonne);
            abonnePane.getChildren().add(desabonne);
            abonnePane.getChildren().add(boutonabonner);


            currentPane.getChildren().add(button);
            currentPane.getChildren().add(nomproduit);
            currentPane.getChildren().add(Descriptionproduit);
            currentPane.getChildren().add(abonnePane);
    
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
      @FXML
    public void back_menu(ActionEvent event) throws IOException
    {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    MenuController ncont = fxmlLoader.<MenuController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();   
    }
     @FXML
    public void modifier_produit(ActionEvent event) throws IOException
    {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/modifierproduit.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    ModifierproduitController ncont = fxmlLoader.<ModifierproduitController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();   
    }
    
    
}
