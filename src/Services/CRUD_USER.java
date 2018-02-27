/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import static Controller.InscriController.current_user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities.user;
import Utiles.Basededonne;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author samih
 */
public class CRUD_USER {
      Connection cnx = Basededonne.getInstance().getConnection();
      ResultSet rs;
    public void insertST(user U) throws SQLException{
          
        PreparedStatement pt = cnx.prepareStatement("insert into utilisateur (nomuser,prenomuser,pseudouser,emailuser,password,numerouser,role) values (?,?,?,?,?,?,?)");
        pt.setString(1,U.getNomuser());
        pt.setString(2,U.getPrenomuser());
        pt.setString(3,U.getPseudouser());
        pt.setString(4,U.getEmailuser());
        pt.setString(5,U.getPassword());     
        pt.setString(6,U.getNumerouser());
        pt.setInt(7,U.getRole());
         pt.executeUpdate();
    }
    public List<String> get_Pseudo() {
   
          try {
              Statement ste=cnx.createStatement();
              ResultSet rs=ste.executeQuery("select * from utilisateur");
              
              List<String> pseudos= new ArrayList<>();
              while(rs.next()){
                  
                  pseudos.add(rs.getString("pseudouser"));
              }
              return pseudos;
          } catch (SQLException ex) {
              Logger.getLogger(CRUD_USER.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
      public List<String> get_Email() {
   
          try {
              Statement ste=cnx.createStatement();
              ResultSet rs=ste.executeQuery("select * from utilisateur");
              
              List<String> Emails= new ArrayList<>();
              while(rs.next()){
                  
                  Emails.add(rs.getString("emailuser"));
              }
              return Emails;
          } catch (SQLException ex) {
              Logger.getLogger(CRUD_USER.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
      //public user
      public List<String> get_Mp() {
   
          try {
              Statement ste=cnx.createStatement();
              ResultSet rs=ste.executeQuery("select * from utilisateur");
              
              List<String> Mp= new ArrayList<>();
              while(rs.next()){
                  
                  Mp.add(rs.getString("password"));
              }
              return Mp;
          } catch (SQLException ex) {
              Logger.getLogger(CRUD_USER.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
   
//       public user get_User(String pseudo) throws SQLException {
//
//        user u=null;
//           PreparedStatement pst=cnx.prepareStatement("select * from user where pseudouser='"+pseudo+"'");
//             ResultSet rs=pst.executeQuery();
//             
//              while(rs.next()){
//                  u = new user(rs.getString("nomuser"), rs.getString("prenomuser"), rs.getString("emailuser"), rs.getString("numerouser"));
//          }
//            
//       return u;
//    }
public user authentification (String pseudo , String mp ) throws SQLException
{
     Statement ste=cnx.createStatement();
              ResultSet rs=ste.executeQuery("select * from utilisateur where pseudouser ='"+pseudo+"' and (password ='"+mp+"')");
              while ( rs.next())
              {
   current_user=new user(rs.getInt("iduser"),rs.getString("nomuser"),rs.getString("prenomuser"),rs.getString("pseudouser"),rs.getString("emailuser"),rs.getString("password"),rs.getString("numerouser"),rs.getString("photo_Profile"),rs.getInt("role")) ; 
         
              }
              return current_user;
}
public void insertPhoto(String s, user u  ) throws SQLException{
          
        PreparedStatement pt = cnx.prepareStatement("update  utilisateur set photo_profile= '"+s+"' where pseudouser ='"+u.getPseudouser()+"'");
        pt.executeUpdate();
    }


    public List<user>displayAll() throws SQLException{
     Statement ste=cnx.createStatement();
              ResultSet rs=ste.executeQuery("select * from utilisateur where role = 0");
        List<user> list=new ArrayList<>();
       
        while(rs.next()){
            user U=new user(rs.getInt("iduser"),rs.getString("nomuser"), rs.getString("prenomuser"),rs.getString("numerouser"),rs.getString("emailuser"));
            list.add(U);  
        }
        return list;
    }
    
    public String get_Mp_Oublie(String Email ) {
   
          try {
              Statement ste=cnx.createStatement();
              ResultSet rs=ste.executeQuery("select * from utilisateur where emailuser = '"+Email+"'");
              
              String Mp= "";
              while(rs.next()){
                  
                  Mp=rs.getString("password");
              }
              return Mp;
          } catch (SQLException ex) {
              Logger.getLogger(CRUD_USER.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    public void update_role(int id) throws SQLException{
          
        PreparedStatement pt = cnx.prepareStatement("update  utilisateur set role='2' where iduser ="+id);
        pt.executeUpdate();
    }

    
}
    

