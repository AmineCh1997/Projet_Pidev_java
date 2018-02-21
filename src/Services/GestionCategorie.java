/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utiles.Config;
import Entities.Categorie;
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
public class GestionCategorie {
    Connection con =Config.getInstance().getConnection();
    
    private Statement ste ; private ResultSet rs;
    
    
    public void ajouter_categorie(Categorie c) throws SQLException
    {
       String req = "insert into categorie (nom) values ('"+c.getNom()+"')";
       ste=con.createStatement();
       ste.executeUpdate(req);
        
    }
    public void supprimer_categorie(Categorie c) throws SQLException
    {
          String req = "delete from produit where id_categorie='"+c.getId()+"'";
       ste=con.createStatement();
       ste.executeUpdate(req);
       String req2 = "delete from categorie where id='"+c.getId()+"'";
       ste=con.createStatement();
       ste.executeUpdate(req2);
        
    }
    
    public List<String> check_categorie() throws SQLException
    {
        String req="select nom from categorie ";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        List<String> nomscat = new ArrayList<>();
        while(rs.next())
        {
          nomscat.add(rs.getString("nom"));
        }
        return nomscat ;
    }
    public List<String> afficher_categorieList() throws SQLException
    {
        String req="select * from categorie ";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        List<String> listecat = new ArrayList<>();
        while(rs.next())
        {
          listecat.add(rs.getString("nom"));
        }
        return listecat ;
        
    }
     public ObservableList<Categorie> afficher_categorieObList() throws SQLException
    {
        String req="select * from categorie ";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        //ObservableList<String> listecat = new FXCollections.observableArrayList
        ObservableList<Categorie> listecat = FXCollections.observableArrayList();
       
        while(rs.next())
            
        {
             Categorie c = new Categorie();
            c.setId(rs.getInt("id"));
            c.setNom(rs.getString("nom"));
            listecat.add(c);
          
        }
        return listecat ;
        
    }
    public int getidbyname(String name) throws SQLException
    {
        int a =0;
        String req="select id from categorie where nom='"+name+"' ";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        while(rs.next()){
        
           a = rs.getInt("id");
        }
        return a ;
        
        
    }
    
    
    
    
    
}
