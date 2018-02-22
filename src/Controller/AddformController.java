/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import Entities.Evenement;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import Services.Crud_Event;

/**
 * FXML Controller class
 *
 * @author win7
 */
public class AddformController implements Initializable {
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
    private void add(MouseEvent event) {
        Crud_Event ce = new Crud_Event();
        ce.insererEvent(new Evenement(Description.getText(),Adresse.getText(),Date.valueOf(Datedebut.getValue()),Date.valueOf(Datefin.getValue())
				,Image.getText(),Integer.parseInt(nbr.getText()),Integer.parseInt(total.getText()),IDP.getVisibleRowCount()));
    }

  
}
