/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utiles.Basededonne;
/**
 *
 * @author win7
 */
public class Crud_Event {
Connection con = Basededonne.getInstance().getConnection();
	public  void insererEvent(Evenement E) {
		
		String query = "INSERT INTO `evenement`( `description`, `adresse`, `date_debut`, `date_fin` , `photo` , `nbr_participant`,`totalparticipants`)"
				+ " VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ste = con.prepareStatement(query);
			ste.setString(1, E.getDescription());
			ste.setString(2, E.getAdresse());
			ste.setDate(3, E.getDate_debut());
			ste.setDate(4, E.getDate_fin());
			ste.setString(5, E.getPhoto());
			ste.setInt(6, E.getNbr_participant());
			ste.setInt(7, E.getTotalparticipants());
			//ste.setInt(8, E.getId_produit());

			ste.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(Crud_Event.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public  void UpEvent(Evenement E, int id) {
		
		//int usr = E.getId();
		String query = "UPDATE `evenement` SET  description=? , adresse=? , date_debut=? , date_fin=? , photo=? , nbr_participant=? ,totalparticipants=? WHERE id='" + id + "'  ";
		try {
			PreparedStatement ste = con.prepareStatement(query);
			ste.setString(1, E.getDescription());
			ste.setString(2, E.getAdresse());
			ste.setDate(3, E.getDate_debut());
			ste.setDate(4, E.getDate_fin());
			ste.setString(5, E.getPhoto());
			ste.setInt(6, E.getNbr_participant());
			ste.setInt(7, E.getTotalparticipants());
			//ste.setInt(8, E.getId_produit());

			ste.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(Crud_Event.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public  List<Evenement> findAll() {
		
		List result = new ArrayList<Evenement>();
		String query = "select * from evenement";
		try {
			Statement ste = con.createStatement();
			ResultSet set = ste.executeQuery(query);
			while (set.next()) {
				Evenement E = new Evenement(set.getString("Description"), set.getString("Adresse"), set.getDate("date_debut"), set.getDate("date_fin"), set.getString("photo"), set.getInt("nbr_participant"),set.getInt("totalparticipants"), set.getInt("id_user"));
				// int usr = E.getId();
				E.setId(set.getInt("id"));
				result.add(E);
			}
			return result;
		} catch (SQLException ex) {
			Logger.getLogger(Crud_Event.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public  Evenement getEvenementById(int id) {
		
		Evenement E = null;
		String query = "select * from evenement where id = " + id;
		try {
			Statement ste = con.createStatement();
			ResultSet set = ste.executeQuery(query);
			while (set.next()) {
				E = new Evenement(set.getString("Description"), set.getString("Adresse"), set.getDate("date_debut"), set.getDate("date_fin"), set.getString("photo"), set.getInt("nbr_participant"),set.getInt("totalparticipants"), set.getInt("id_user"));
				// int usr = E.getId();
				E.setId(set.getInt("id"));
				return E;
			}
		} catch (SQLException ex) {
			Logger.getLogger(Crud_Event.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public  void Delete(int id) {
		
		//int usr = E.getId();
		String query = "DELETE FROM `evenement` WHERE id = "+id;
		try {
			PreparedStatement ste = con.prepareStatement(query);
			ste.executeUpdate(query);
			ste.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Crud_Event.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
/*public ObservableList<Produit> afficher_produitBycategorie(int idcategorie) throws SQLException
    {
        String req="select * from produit where id_categorie='"+idcategorie+"' ";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        //ObservableList<String> listecat = new FXCollections.observableArrayList
        ObservableList<Produit> listeprod = FXCollections.observableArrayList();
       
        while(rs.next())
            
        {
             Produit p = new Produit();
            p.setId(rs.getInt("id"));
            p.setNom(rs.getString("nom"));
            listeprod.add(p);
          
        }
        return listeprod ;
        
    }*/

}
