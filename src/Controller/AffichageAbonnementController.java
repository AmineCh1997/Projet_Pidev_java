/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entities.Abonnement;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import Services.CRUD_Abonnement;

/**
 * FXML Controller class
 *
 * @author Yacine
 */
public class AffichageAbonnementController implements Initializable {
    @FXML
    private AnchorPane anchorpane;
    Label affichage;
    CRUD_Abonnement crud = new CRUD_Abonnement();
    List<Abonnement> ListeAbo = new ArrayList<>();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ListeAbo=crud.afficherAbonnement();
       for(int i=0;i<ListeAbo.size();i++)
       {
           Pane currentP = new Pane();
           currentP.setPrefSize(400, 400);
           currentP.setStyle("-fx-background-color : blue");
           currentP.setStyle("-fx-border-color : black");
           String text =String.valueOf(ListeAbo.get(i).getId_produit()) ;
           //int number = Integer.parseInt(text);
           Label labelContenu = new Label(text);
           labelContenu.setPrefSize(166, 87);
           labelContenu.setLayoutX(13);
           labelContenu.setLayoutY(28);
          
           currentP.getChildren().add(labelContenu);

           anchorpane.getChildren().add(currentP);
       }
    }    
    
}
