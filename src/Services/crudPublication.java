/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

//import static controller.AffichageController.current_publication;
import Controller.InscriController;
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
public class crudPublication {
     Connection con= Basededonne.getInstance().getConnection();
    private Statement ste;
    private ResultSet rs;
        public void ajouterPublication(Publication p) throws SQLException
        {
            //String req="insert into promotion (nom,date_debut,date_fin) values (?,?,?)";
            PreparedStatement pre = (PreparedStatement) con.prepareStatement("INSERT INTO `publication`(`contenu`,`photo`,`datepublication`,`id_produit`,`id_user`) VALUES (?,?,NOW(),?,?)");
            pre.setString(1, p.getContenu());
            pre.setString(2, p.getPhoto());
            pre.setInt(3, p.getIdproduit());
            pre.setInt(4, p.getIduser());
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
            PreparedStatement pre = (PreparedStatement) con.prepareStatement("delete from `publication` WHERE  id='"+idsupp+"' and id_user='"+InscriController.current_user.getId()+"'");
            pre.executeUpdate();
        }
        
        public List<String> afficher_produitParVille(String ville,int idCat) throws SQLException
    {
        String req="select produit.nom from produit inner join categorie on produit.id_categorie='"+idCat+"' and produit.ville='"+ville+"'";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        List<String> listecat = new ArrayList<>();
        while(rs.next())
        {
          listecat.add(rs.getString("produit.nom"));
            System.out.println("aaaaaaaa");
        }
        return listecat ;
        
    }
        
        public List<Integer> ajouter_pubParId(String nom) throws SQLException
    {
        String req="select produit.id from produit inner join publication on produit.nom='"+nom+"'";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        List<Integer> listecat = new ArrayList<>();
        while(rs.next())
        {
          listecat.add(rs.getInt("produit.id"));
            //System.out.println("aaaaaaaa");
        }
        return listecat ;
        
    }
        
        public List<Publication> afficherPublicationParId()
        {
            List<Publication> listePub = new ArrayList<>();
         try {
             //PreparedStatement pre = (PreparedStatement) con.prepareStatement("select * from `publication`");
             
             ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select * from publication where id_user='"+InscriController.current_user.getId()+"'");
             while ( rs.next())
             {
                 Publication current= new Publication(rs.getInt("id"),rs.getString("contenu"),rs.getString("photo"),rs.getDate("datepublication"),rs.getInt("id_produit"));
                 listePub.add(current);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(crudPublication.class.getName()).log(Level.SEVERE, null, ex);
         }
         return listePub;
        }
}
