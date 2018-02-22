/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import entities.Evenement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.Crud_Event;

/**
 *
 * @author win7
 */
public class ReservationController {
	  @FXML
    private TableView<Evenement> EventTab;
    private ObservableList<Evenement> EventList = FXCollections.observableArrayList();
	@FXML
	private JFXButton id2;
	@FXML
	private TableColumn<?, ?> ID;
	@FXML
	private TableColumn<?, ?> IDuser;
	@FXML
	private TableColumn<?, ?> IDProduit;
	@FXML
	private TableColumn<?, ?> Edit;
	@FXML
	private JFXButton btnEdit;
	@FXML
	private TableColumn<?, ?> Delete;
	@FXML
	private JFXButton btnDelete;
	
    public void initialize(URL location, ResourceBundle resources) {

        EventTab.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        setColumnProperties();

        // Add all users into table
        loadDetails();
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
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        IDuser.setCellValueFactory(new PropertyValueFactory<>("IDUser"));
        IDProduit.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
		Delete.setCellValueFactory(new PropertyValueFactory<>("removeLink"));

    }
    

    private void loadDetails() {
        EventList.clear();
        EventList.addAll(Crud_Event.findAll());

        EventTab.setItems(EventList);
    }

	@FXML
	private void afficher2(MouseEvent event) {
	}

	@FXML
	private void Edit(MouseEvent event) {
	}

	@FXML
	private void Delete(MouseEvent event) {
	}
	
}
