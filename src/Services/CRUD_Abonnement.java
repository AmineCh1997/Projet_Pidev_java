/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import com.mysql.jdbc.PreparedStatement;
import entities.Abonnement;
import entities.Reclamation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utile.Basededonne;

/**
 *
 * @author Yacine
 */
public class CRUD_Abonnement {
    
    Connection con = Basededonne.getInstance().getConnection();
    private Statement ste;
    
    
    
    
    
    public void ajouterAbonnement(Abonnement a) throws SQLException {
      
       PreparedStatement st=(PreparedStatement) con.prepareStatement("INSERT INTO abonnement () VALUES()");
//       st.setInt(1,0);
       //st.setInt(2,id_produit);
       st.execute();
       }
    
    
    
    
    public void supprimerAbonnement(Integer id_produit)
    {
        try {
        String req = "delete from abonnement where id_produit =?";
        PreparedStatement preparedStatement;
            preparedStatement = (PreparedStatement) con.prepareStatement(req);
            preparedStatement.setInt(1, id_produit);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public List<Abonnement> afficherAbonnement()
        {
            List<Abonnement> listeAbon = new ArrayList<>();
         try {
             
             ste=con.createStatement();
             //ResultSet rs=ste.executeQuery("select * from produit INNER JOIN abonnement ON produit.id = abonnement.id_produit");
            ResultSet rs=ste.executeQuery("select * from abonnement where id_produit=1");

             while ( rs.next())
             {
                 Abonnement current= new Abonnement(rs.getInt("id_user"),rs.getInt("id_produit"));
                 listeAbon.add(current);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(CRUD_Abonnement.class.getName()).log(Level.SEVERE, null, ex);
         }
         return listeAbon;
        }
    
    
    
}
