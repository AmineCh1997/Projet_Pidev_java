/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utiles.Config;
import Entities.Produit;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Amine
 */
public class GestionProduit {
    Connection con =Config.getInstance().getConnection();
    
    private Statement ste ; private ResultSet rs; private PreparedStatement pst ;
    
    
    public void ajouter_produit(Produit c) throws SQLException
    {
       /*String req = "insert into produit (nom,description,id_cat) values (?,?,?)";
       pst = (PreparedStatement) con.prepareStatement(req);
       pst.setString(1,c.getNom());
       pst.setString(2,c.getDescription());
       pst.setInt(3, c.getId_cat());   
       ste.executeUpdate(req);*/
        
       String req = "insert into produit (nom,description,adresse,photo,ville,id_categorie) values ('"+c.getNom()+"','"+c.getDescription()+"','"+c.getAdresse()+"','"+c.getImg()+"','"+c.getVille()+"','"+c.getId_cat()+"')";
       ste=con.createStatement();
       ste.executeUpdate(req);
        
    }
     public void supprimer_produit(Produit p) throws SQLException
    {
       String req = "delete from produit where id='"+p.getId()+"'";
       ste=con.createStatement();
       ste.executeUpdate(req);
        
    }
    public ObservableList<Produit> afficher_produitBycategorie(int idcategorie) throws SQLException
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
        
    }
    public List<Produit> afficher_produitBycategorie1(int idcategorie) throws SQLException
    {
        String req="select * from produit where id_categorie='"+idcategorie+"' ";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        //ObservableList<String> listecat = new FXCollections.observableArrayList
        List<Produit> listeprod = new ArrayList<>();
       
        while(rs.next())
            
        {
             Produit p = new Produit();
             p.setDescription(rs.getString("description"));
            p.setId(rs.getInt("id"));
            p.setNom(rs.getString("nom"));
           p.setImg(rs.getString("photo"));
           p.setVille(rs.getString("ville"));
            listeprod.add(p);
          
        }
        return listeprod ;
        
    }
    
    
    
    
}
