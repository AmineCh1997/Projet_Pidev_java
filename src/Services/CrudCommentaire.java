/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.commentaire;
import Utiles.DataSource;
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
 * @author ESPRIT
 */
public class CrudCommentaire {
    Connection con=DataSource.getInstance().getConnection();
        Statement ste;
        ResultSet rs;
PreparedStatement ps;
    
    public void insertST(commentaire a) throws SQLException{
          
        PreparedStatement pt = con.prepareStatement("insert into commentaire (iduser,id_produit,texte) values (?,?,?)");
              

        pt.setInt(1,a.getCin_personne());
        pt.setInt(2,a.getId_produit());
        pt.setString(3,a.getTexte());
       try{
         pt.executeUpdate();}
       catch (SQLException ex)
       {
           System.out.println(ex);
       }
       
    }
    public ObservableList<commentaire> afficherlescommentaire1() throws SQLException 
   {
       String req = "select * from commentaire";
       ste=con.createStatement();
       rs=ste.executeQuery(req);
        ObservableList<commentaire> list = FXCollections.observableArrayList();
        while (rs.next()){
            commentaire a = new commentaire(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
            list.add(a);                            
   } 
    return list;
}
    
    public void supprimercommentaire(commentaire c) throws SQLException
        {
        
            
            String req=" DELETE FROM commentaire WHERE id_commentaire='"+c.getId_commentaire()+"' ";
            ste=con.createStatement();
            ste.executeUpdate(req);
        }
    public void modifiercommentaire(commentaire c) throws SQLException
        {
        
            
            String req="UPDATE `commentaire` SET `id_commentaire`=?,`iduser`=?,`id_produit`=?,`texte`=? WHERE `id_commentaire`=?" ;
           
            ps=(PreparedStatement) con.prepareStatement(req);
            ps.setInt(1, c.getId_commentaire());
            ps.setInt(2, c.getCin_personne());
            ps.setInt(3, c.getId_produit());
            ps.setString(4, c.getTexte());
            ps.setInt(5, c.getId_commentaire());
            
            ps.executeUpdate();
            //ste.executeUpdate(req);
        }
    public List<String> afficherlescommentaire() throws SQLException 
   {
       String req = "select * from commentaire";
       ste=con.createStatement();
       rs=ste.executeQuery(req);
        List<String> list = new ArrayList<>();
        while (rs.next()){
            String a = "'"+rs.getInt(1)+"'"+rs.getInt(2)+"'"+rs.getInt(3)+"'"+rs.getString(4)+"'";
            list.add(a);
             
            
       
   }
return list;
   }
}