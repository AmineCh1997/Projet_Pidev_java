/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.Crud_Event;
import controllers.UpformController;

/**
 *
 * @author win7
 */
public class Evenement {

	public int id;
	private String description;
	private String adresse;
	private Date date_debut;
	private Date date_fin;
	private String photo;
	private int nbr_participant;
	private int totalparticipants;
	private int id_produit;

	public Evenement(String description, String adresse, Date date_debut, Date date_fin, String photo, int nbr_participant,int totalparticipants, int id_produit) {
		this.description = description;
		this.adresse = adresse;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.photo = photo;
		this.nbr_participant = nbr_participant;
		this.totalparticipants=totalparticipants;
		this.id_produit = id_produit;
	}

	public Evenement() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getNbr_participant() {
		return nbr_participant;
	}

	public void setNbr_participant(int nbr_participant) {
		this.nbr_participant = nbr_participant;
	}

	public int getTotalparticipants() {
		return totalparticipants;
	}

	public void setTotalparticipants(int totalparticipants) {
		this.totalparticipants = totalparticipants;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public Button getEditLink() {
		Button edit = new Button("");
		edit.setStyle("-fx-graphic: url('/views/edit.png');");
		edit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/UpForm.fxml"));
					Parent root = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.show();
					UpformController.idToEdit = id;

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		return edit;
	}
	
	public Button getRemoveLink() {
		Button delete = new Button("");
		delete.setStyle("-fx-graphic: url('/views/Delete.png');");
		delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Crud_Event.Delete(id);
			}
		});
		return delete;
	}

}
