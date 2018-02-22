/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entities.Reservation;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Utiles.Basededonne;

/**
 *
 */
public class Crud_Reservation {
     Connection con = Basededonne.getInstance().getConnection();
    public  void insererReservation(Reservation R){
       
        String query = "INSERT INTO reservation VALUES(?,?)";
        try {
            PreparedStatement ste = con.prepareStatement(query);
            ste.setInt(1, R.getId_user());
            ste.setInt(2, R.getId_produit());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Crud_Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public  void Delete(int id) {
		
		//int usr = E.getId();
		String query = "DELETE FROM `reservation` WHERE id = "+id;
		try {
			PreparedStatement ste = con.prepareStatement(query);
			ste.executeUpdate(query);
			ste.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Crud_Reservation.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
public  List<Reservation> findAll() {
		
		List result = new ArrayList<Reservation>();
		String query = "select * from reservation";
		try {
			Statement ste = con.createStatement();
			ResultSet set = ste.executeQuery(query);
			while (set.next()) {
				Reservation R = new Reservation(set.getInt("id"), set.getInt("id_user"), set.getInt("id_produit"));
				// int usr = E.getId();
				R.setId(set.getInt("id"));
				result.add(R);
			}
			return result;
		} catch (SQLException ex) {
			Logger.getLogger(Crud_Reservation.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
