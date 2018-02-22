/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import Entities.Evenement;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Services.Crud_Event;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author win7
 */
public class EventController implements Initializable {

   @FXML
    private JFXButton id2;
    @FXML
    private TableView<Evenement> EventTab;
    private ObservableList<Evenement> EventList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Evenement,Integer> ID;
    @FXML
    private TableColumn<?, ?> Description;
    @FXML
    private TableColumn<?, ?> Adresse;
    @FXML
    private TableColumn<?, ?> Image;
    @FXML
    private TableColumn<Evenement, LocalDate> DateDebut;
    @FXML
    private TableColumn<Evenement, LocalDate> DateFin;
    @FXML
    private TableColumn<?, ?> NombreParticipants;
    @FXML
    private TableColumn<?, ?> IDProduit;
    @FXML
    private TableColumn<Evenement, Boolean> Edit;
    @FXML
    private JFXButton btnEdit;
	@FXML
	private JFXButton btnDelete;
	@FXML
	private TableColumn<Evenement, Boolean> Delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        EventTab.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        setColumnProperties();

        // Add all users into table
        loadDetails();
    }

    @FXML
    private void afficher2(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Addform.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root,1200,800));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setColumnProperties() {
        System.out.println("bnj");

        /* Override date format in table
         * colDOB.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
         String pattern = "dd/MM/yyyy";
         DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
         @Override 
         public String toString(LocalDate date) {
         if (date != null) {
         return dateFormatter.format(date);
         } else {
         return "";
         }
         }

         @Override 
         public LocalDate fromString(String string) {
         if (string != null && !string.isEmpty()) {
         return LocalDate.parse(string, dateFormatter);
         } else {
         return null;
         }
         }
         }));*/
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        DateDebut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        DateFin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        Image.setCellValueFactory(new PropertyValueFactory<>("photo"));
        NombreParticipants.setCellValueFactory(new PropertyValueFactory<>("nbr_participant"));
        IDProduit.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
		Edit.setCellValueFactory(new PropertyValueFactory<>("editLink"));
		Delete.setCellValueFactory(new PropertyValueFactory<>("removeLink"));

    }
    

    private void loadDetails() {
        Crud_Event ce = new Crud_Event();
        EventList.clear();
        EventList.addAll(ce.findAll());

        EventTab.setItems(EventList);
    }

    @FXML
    private void Edit(MouseEvent event) {

    }

	@FXML
	private void Delete(MouseEvent event) {
	}
        @FXML
    private void back_dash(ActionEvent event) throws  IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/adminDashboard.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        
         AdminDashboardController ncont = fxmlLoader.<AdminDashboardController>getController();
    
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
        
}
}
