/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Moyenne;
import Entities.avis;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utiles.Basededonne;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ESPRIT
 */
public class CrudAvis {
    Connection con=Basededonne.getInstance().getConnection();
        Statement ste;
        ResultSet rs;
    public void afficherlesavis() throws SQLException 
   { 
       
       String req = "select * from avis";
       ste=con.createStatement();
       rs=ste.executeQuery(req);
        List<String> list = new ArrayList<>();
        while (rs.next()){
            String a = "'"+rs.getInt(1)+"'"+rs.getInt(2)+"'"+rs.getString(3)+"'";
            list.add(a);
             
            
       
   }
        for(String b : list)
            System.out.println(b);
        
    
}
   public void insertST(avis a) throws SQLException{
          
        PreparedStatement pt = con.prepareStatement("insert into avis (id_produit,note) values (?,?)");
              

        pt.setInt(1,a.getId_produit());
         pt.setInt(2,a.getnote());
       try{
         pt.executeUpdate();}
       catch (SQLException ex)
       {
           System.out.println(ex);
       }
       
    }
   public List<String> afficherlamoyenne(Moyenne moyenne,avis z) throws SQLException 
   {
        moyenne.setMoyenne_produit(0);
       String req = "select * from avis WHERE id_produit="+z.getId_produit();
            float nmbre=0;   float notes=0;
       ste=con.createStatement();
       rs=ste.executeQuery(req);
        List<String> list = new ArrayList<>();
        while (rs.next()){
            String a = "'"+rs.getInt(1)+"'"+rs.getInt(2)+"'"+rs.getInt(3)+"'";
            list.add(a);
             
            nmbre++;
       notes=notes+rs.getInt(3);
   }
        float m=notes/nmbre;
        moyenne.setMoyenne_produit(m);
        System.out.println("la moyenne du produit dont l id est "+z.getId_produit()+ "est" +m);
        return list;
}
   public void supprimeravis(avis c) throws SQLException
        {
        
            
            String req=" DELETE FROM `avis` WHERE id='"+c.getId()+"' ";
            ste=con.createStatement();
            ste.executeUpdate(req);
        }
}
