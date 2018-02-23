/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;
// samih    

import Entities.Abonnement;
import Controller.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utiles.Basededonne;
import java.sql.PreparedStatement;

/**
 *
 * @author Yacine
 */
public class CRUD_Abonnement {
    
    Connection con = Basededonne.getInstance().getConnection();
    private Statement ste;
    
    
    
    
    
    public void ajouterAbonnement(int id_produit) throws SQLException {
      
       PreparedStatement st=(PreparedStatement) con.prepareStatement("INSERT INTO abonnement (id_user,id_produit) VALUES(?,?)");
       int b = InscriController.current_user.getId();
       
        st.setInt(1,b);
       st.setInt(2,id_produit);
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
    
    public List<Integer> afficheridprodAbonnement(int id_user)
        {
            List<Integer> listeAbon = new ArrayList<>();
         try {
             
             ste=con.createStatement();
              PreparedStatement ps=con.prepareStatement("select * from abonnement where id_user=?");
              ps.setInt(1, id_user);
             //ResultSet rs=ste.executeQuery("select * from produit INNER JOIN abonnement ON produit.id = abonnement.id_produit");
            ResultSet rs=ps.executeQuery();
            
             while ( rs.next())
             {
                 
                 listeAbon.add(rs.getInt("id_produit"));
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(CRUD_Abonnement.class.getName()).log(Level.SEVERE, null, ex);
         }
         return listeAbon;
        }

    public List<Abonnement> afficherAbonnement() {
         List<Abonnement> listeAbon = new ArrayList<>();
         try {
             
             ste=con.createStatement();
              PreparedStatement ps=con.prepareStatement("select * from abonnement");
              
             //ResultSet rs=ste.executeQuery("select * from produit INNER JOIN abonnement ON produit.id = abonnement.id_produit");
            ResultSet rs=ps.executeQuery();
            
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
    public List<Abonnement> afficherAbonnement(int id_user) {
         List<Abonnement> listeAbon = new ArrayList<>();
         try {
             
             ste=con.createStatement();
              PreparedStatement ps=con.prepareStatement("select * from abonnement where id_user=?");
              ps.setInt(1, id_user);
             //ResultSet rs=ste.executeQuery("select * from produit INNER JOIN abonnement ON produit.id = abonnement.id_produit");
            ResultSet rs=ps.executeQuery();
            
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
