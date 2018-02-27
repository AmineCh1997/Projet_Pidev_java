/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Categorie;
import Entities.Menu;
import Utiles.Basededonne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author samih
 */
public class GestionMenu {
     Connection con =Basededonne.getInstance().getConnection();
    
    private Statement ste ; private ResultSet rs; private PreparedStatement pst ;
    
    public void Ajouter_menu(Menu m) throws SQLException
    {
          
       String req = "insert into menu (plat,prix,id_produit) values ('"+m.getPlat()+"','"+m.getPrix()+"','"+m.getId_produit()+"')";
       ste=con.createStatement();
       ste.executeUpdate(req);
    }
    
   public void supprimer_menu(Menu m) throws SQLException
    {
       String req = "delete from menu where id='"+m.getId()+"'";
       ste=con.createStatement();
       ste.executeUpdate(req);
        
    }
    
     public ObservableList<Menu> afficher_MenuObList(int idprod) throws SQLException
    {
        ResultSet rs;
        String req="select * from menu where id_produit='"+idprod+"' ";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        //ObservableList<String> listecat = new FXCollections.observableArrayList
        ObservableList<Menu> listemen = FXCollections.observableArrayList();
       
        while(rs.next())
            
        {
             Menu m =new Menu();
             m.setId(rs.getInt("id"));
            m.setPlat(rs.getString("plat"));
            m.setPrix(rs.getFloat("prix"));
            listemen.add(m);
          
        }
        return listemen ;
        
    }
  public List<Menu> afficher_MenuList(int idprod) throws SQLException
    {
        ResultSet rs;
        String req="select * from menu where id_produit='"+idprod+"' ";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        //ObservableList<String> listecat = new FXCollections.observableArrayList
        List<Menu> listemen = new ArrayList<Menu>();
       
        while(rs.next())
            
        {
             Menu m =new Menu();
              m.setId(rs.getInt("id"));
              m.setPlat(rs.getString("plat"));
              m.setPrix(rs.getFloat("prix"));
              listemen.add(m);
          
        }
        return listemen ;
        
    }  
  public List<String> afficher_MenuListNom(int idprod) throws SQLException
    {
        ResultSet rs;
        String req="select * from menu where id_produit='"+idprod+"' ";
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        //ObservableList<String> listecat = new FXCollections.observableArrayList
        List<String> listemen = new ArrayList<String>();
       
        while(rs.next())
            
        {
            String a ="";
            
             a=rs.getString("plat");
             listemen.add(a);
              
          
        }
        return listemen ;
        
    }  
    
}
