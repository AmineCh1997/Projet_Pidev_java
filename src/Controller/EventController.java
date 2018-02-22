/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import entities.Evenement;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.Crud_Event;

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
            stage.setScene(new Scene(root));
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
        EventList.clear();
        EventList.addAll(Crud_Event.findAll());

        EventTab.setItems(EventList);
    }

    @FXML
    private void Edit(MouseEvent event) {

    }

	@FXML
	private void Delete(MouseEvent event) {
	}
}
