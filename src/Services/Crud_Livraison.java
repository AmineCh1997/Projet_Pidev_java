/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Livraison;
import Entities.user;
import Utiles.Basededonne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samih
 */
public class Crud_Livraison {
      Connection cnx = Basededonne.getInstance().getConnection();
      ResultSet rs;
    public void insertST(Livraison l ) throws SQLException{
          
        PreparedStatement pt = cnx.prepareStatement("insert into livraison  (id_user,id_produit,adresse,nbr_produit,etat,nom_produit) values (?,?,?,?,?,?)");
        pt.setInt(1,l.getId_user());
        pt.setInt(2,l.getId_produit());
        pt.setString(3,l.getAdresse());
        pt.setInt(4,l.getNbr_produit());
         pt.setInt(5,l.getEtat());
         pt.setString(6,l.getNom_produit());
         pt.executeUpdate();
    }
    public List<Livraison>displayAllLivraison() throws SQLException
    {
       Statement ste=cnx.createStatement();
              ResultSet rs=ste.executeQuery("select * from livraison ");
        List<Livraison> list=new ArrayList<>();
       
        while(rs.next()){
            Livraison l=new Livraison(rs.getString("adresse"),rs.getInt("nbr_produit"), rs.getInt("etat"),rs.getString("nom_produit"));
            list.add(l);  
        }
        return list;
    }   
    }
    

