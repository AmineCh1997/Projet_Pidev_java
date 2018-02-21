/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Entities.Promotion;
import Entities.Publication;
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
 * @author emirc
 */
public class crudPromotion {
    Connection con= Basededonne.getInstance().getConnection();
    private Statement ste;
    
    public void ajouterPromotion(Promotion p) throws SQLException
        {
            //String req="insert into promotion (nom,date_debut,date_fin) values (?,?,?)";
            PreparedStatement pre = (PreparedStatement) con.prepareStatement("INSERT INTO `promotion`(`contenu`,`photo` ,`datepromotion`) VALUES (?,?,NOW())");
            pre.setString(1, p.getContenu());
            pre.setString(2, p.getPhoto());
            pre.executeUpdate();
        }
    
     public List<Promotion> afficherPromotion()
        {
            List<Promotion> listePromo = new ArrayList<>();
         try {
             
             
             ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select * from promotion");
             while ( rs.next())
             {
                 Promotion current= new Promotion(rs.getString("contenu"),rs.getString("photo"),rs.getInt("id_user"),rs.getDate("datepromotion"));
                 listePromo.add(current);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(crudPublication.class.getName()).log(Level.SEVERE, null, ex);
         }
         return listePromo;
        }
     
     public void modifierPromotion(int idmod,String contenumod) throws SQLException
        {
            PreparedStatement pre = (PreparedStatement) con.prepareStatement("UPDATE `promotion` SET `contenu`='"+contenumod+"' WHERE  id='"+idmod+"'");
           /* pre.setString(1, p.getContenu());
            pre.setInt(2, p.getId());*/
            pre.executeUpdate();
        }
     
      public void supprimerPromotion(int idsupp) throws SQLException
        {
            PreparedStatement pre = (PreparedStatement) con.prepareStatement("delete from `promotion` WHERE  id='"+idsupp+"'");
            pre.executeUpdate();
        }
}
