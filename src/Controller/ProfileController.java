/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Entities.Produit;
import Entities.Reclamation;
import Services.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author samih
 */
public class ProfileController implements Initializable {
    CRUD_USER CU;
    public String pseudo;
 @FXML Label NomLabel;
 @FXML Label PrenomLabel;
 @FXML Label EmailLabel;
 @FXML Label NumLabel;
 @FXML ImageView ImageUser;
    @FXML
    private ScrollPane SP;
    @FXML
    private AnchorPane AP;
    @FXML TableView<Reclamation> mesreclamations;
    @FXML TableColumn<Reclamation, String> sujet;
    @FXML TableColumn<Reclamation, String> etat;
    @FXML TableColumn<Reclamation, String> reclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        etat.setCellValueFactory(new PropertyValueFactory<>("etatString"));
        sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        reclamation.setCellValueFactory(new PropertyValueFactory<>("textereclamation"));
        CRUD_Reclamation rec = new CRUD_Reclamation();
        try {
            mesreclamations.setItems(rec.afficherMesReclams(InscriController.current_user.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        String PathImage = InscriController.current_user.getPhoto_profile();
        System.out.println("file:\\\\\\C:\\wamp64\\www\\Images\\"+PathImage);
       // System.out.println(PathImage);
  NomLabel.setText(InscriController.current_user.getNomuser());
  PrenomLabel.setText(InscriController.current_user.getPrenomuser());
  EmailLabel.setText(InscriController.current_user.getEmailuser());
  NumLabel.setText(InscriController.current_user.getNumerouser());
  if(PathImage!=null)
  ImageUser.setImage(new Image("file:\\\\\\C:\\wamp64\\www\\Images\\"+PathImage, 350,272, true, true));
       
  GestionProduit gp= new GestionProduit();
  List<Produit> produits=null;
        try {
            produits = gp.afficher_produit();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
   int taille = produits.size();
        
       
            
        for(int i=0 ; i<taille ; i++)
        {
           
            Pane currentPane= new Pane();
            //Pane ABPane = new Pane();
            currentPane.getChildren().clear();
            Label nomproduit =new Label();
            Label Descriptionproduit = new Label();
  
            
             
            //label
            nomproduit.setLayoutX(49);
            nomproduit.setLayoutY(130);
            nomproduit.setPrefSize(90, 18);
            nomproduit.setText("Nom :"+((Produit)produits.get(i)).getNom());
            Descriptionproduit.setLayoutX(49);
            Descriptionproduit.setLayoutY(149);
            Descriptionproduit.setPrefSize(90, 18);
            Descriptionproduit.setText("Description :"+((Produit)produits.get(i)).getDescription());

           
            //pane
            
            currentPane.setLayoutX((i%2)*195+20); 
            currentPane.setLayoutY((i/2)*195+50);
            currentPane.setPrefSize(175, 175);
            currentPane.setStyle("-fx-background-color:white");   
            currentPane.setVisible(true);
            currentPane.setId(String.valueOf(((Produit)produits.get(i)).getId()));
    
    //add components to pane
          


          
            currentPane.getChildren().add(nomproduit);
            currentPane.getChildren().add(Descriptionproduit);
           
    
     //add pane to Anchorpane       
             AP.getChildren().add(currentPane);
            
       
        } 
    }
 
      @FXML
    private void go_Back_Menu(ActionEvent event) throws IOException {
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    MenuController ncont = fxmlLoader.<MenuController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }

     @FXML
    private void upload_action(ActionEvent event) throws SQLException, FileNotFoundException, IOException {
        FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("Open Resource File");
Stage stage=new Stage();
File file = fileChooser.showOpenDialog(stage);
   
        



if(file!=null){
    Upload u=new Upload();
  u.upload(file);
    String Fileurl="file:\\\\\\"+file.getPath();
    Fileurl=Fileurl.replace("\\", "/");
    ImageUser.setImage(new Image(Fileurl, 350,272, true, true));
    CRUD_USER crud = new CRUD_USER();
    crud.insertPhoto(file.getName(),InscriController.current_user);
    InscriController.current_user.setPhoto_profile(file.getName());
 
    }
     
    }
    
   @FXML
    private void go_to_pub(ActionEvent event) throws IOException {
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/mespublication.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
    MespublicationController ncont = fxmlLoader.<MespublicationController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }
    
}
