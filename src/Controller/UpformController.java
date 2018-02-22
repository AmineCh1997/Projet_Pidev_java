/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateDV;
import entities.Evenement;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import services.Crud_Event;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author win7
 */
public class UpformController implements Initializable {
    @FXML
    private JFXTextField Description;
    @FXML
    private JFXTextField Adresse;
    @FXML
    private JFXTextField Image;
    @FXML
    private DatePicker Datedebut;
    @FXML
    private DatePicker Datefin;
    @FXML
    private JFXTextField nbr;
    @FXML
    private JFXComboBox<?> IDP;
    @FXML
    private JFXButton submit;
	
	public static int idToEdit;
	@FXML
	private JFXTextField total;

    /**
     * Initializes the controller class.
     */
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Update(MouseEvent event) {
       // EventController.ID.getCellValueFactory();
        Crud_Event.UpEvent(new Evenement(Description.getText(),Adresse.getText(),Date.valueOf(Datedebut.getValue()),Date.valueOf(Datefin.getValue()),Image.getText(),Integer.parseInt(nbr.getText()),Integer.parseInt(total.getText()),5),idToEdit);
 
    }
    
}
