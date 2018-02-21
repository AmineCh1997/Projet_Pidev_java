/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

//import static controller.AffichageController.current_publication;
import entities.Publication;
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
public class crudPublication {
     Connection con= Basededonne.getInstance().getConnection();
    private Statement ste;
    
        public void ajouterPublication(Publication p) throws SQLException
        {
            //String req="insert into promotion (nom,date_debut,date_fin) values (?,?,?)";
            PreparedStatement pre = (PreparedStatement) con.prepareStatement("INSERT INTO `publication`(`contenu`,`photo`,`datepublication`) VALUES (?,?,NOW())");
            pre.setString(1, p.getContenu());
            pre.setString(2, p.getPhoto());
            //System.out.println(p.getContenu());
            pre.executeUpdate();
        }
        
        public List<Publication> afficherPublication()
        {
            List<Publication> listePub = new ArrayList<>();
         try {
             //PreparedStatement pre = (PreparedStatement) con.prepareStatement("select * from `publication`");
             
             ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select * from publication");
             while ( rs.next())
             {
                 Publication current= new Publication(rs.getString("contenu"),rs.getString("photo"),rs.getInt("id_user"),rs.getDate("datepublication"));
                 listePub.add(current);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(crudPublication.class.getName()).log(Level.SEVERE, null, ex);
         }
         return listePub;
        }
       
        public void modifierPublication(int idmod,String contenumod) throws SQLException
        {
            PreparedStatement pre = (PreparedStatement) con.prepareStatement("UPDATE `publication` SET `contenu`='"+contenumod+"' WHERE  id='"+idmod+"'");
           /* pre.setString(1, p.getContenu());
            pre.setInt(2, p.getId());*/
            pre.executeUpdate();
        }
        
        public void supprimerPublication(int idsupp) throws SQLException
        {
            PreparedStatement pre = (PreparedStatement) con.prepareStatement("delete from `publication` WHERE  id='"+idsupp+"'");
            pre.executeUpdate();
        }
        

}
