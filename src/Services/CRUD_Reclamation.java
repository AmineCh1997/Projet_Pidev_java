/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;


import Controller.*;
import Entities.Reclamation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utiles.Basededonne;
import java.sql.PreparedStatement;

/**
 *
 * @author Yacine
 */
public class CRUD_Reclamation {
    
    Connection con = Basededonne.getInstance().getConnection();
    private Statement ste;
    
    
    
        public void ajouterReclamation(Reclamation r ) throws SQLException {
      
       PreparedStatement st=(PreparedStatement) con.prepareStatement("INSERT INTO reclamation(sujet,textereclamation,date,id_user,idemetteur) VALUES(?,?,NOW(),?,?)");
       st.setString(1,r.getSujet());
       st.setString(2,r.getTextereclamation());
       int c = AfficherproduitController.current_produit.getId_user();
       st.setInt(3,c);
       int b = InscriController.current_user.getId();
       st.setInt(4,b);
       st.execute();
           
               
     
                }
        
        
        
        public void modifierReclamation(Reclamation r) throws SQLException{
        
//        java.util.Date date_util = new java.util.Date();
//        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        
            String req = " update reclamation set sujet=?,textereclamation=? where id ='"+r.getId()+"'";
            PreparedStatement preparedStatement;
            preparedStatement = (PreparedStatement) con.prepareStatement(req);
            preparedStatement.setString(1, r.getSujet());
            preparedStatement.setString(2, r.getTextereclamation());
            preparedStatement.executeUpdate();     
 
    }
        
        
        
        
        public void supprimerReclamation(Reclamation r)
    {
        try {
        String req = "delete from reclamation where id ='"+r.getId()+"'";
        PreparedStatement preparedStatement;
            preparedStatement = (PreparedStatement) con.prepareStatement(req);
            //preparedStatement.setInt(1,r.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
        
        
        /*public List<String> afficherReclamation() throws SQLException 
   {
        Statement req = con.createStatement(); 
	ResultSet r = req.executeQuery("select * from reclamation");
        List<String> list = new ArrayList<>();
        while (r.next()){
	String a = "'"+r.getInt(1)+"'"+r.getString(2)+"'"+r.getString(3)+"'"+r.getDate(4);
            list.add(a);             
        }
        //list.stream().forEach((b) -> {System.out.println(b);});
            
     return list ;   
    }*/
        public ObservableList<Reclamation> afficherReclamOB() throws SQLException
        {
            ResultSet rs;
            String req = "select * from reclamation";
            ste=con.createStatement();
            rs=ste.executeQuery(req);
            ObservableList<Reclamation> listereclam = FXCollections.observableArrayList();
            while(rs.next())
            {
                Reclamation r = new Reclamation();
                r.setId(rs.getInt("id"));
                r.setSujet(rs.getString("sujet"));
                r.setTexte_reclamation(rs.getString("textereclamation"));
                r.setDate(rs.getDate("date"));
                r.setEtat(rs.getInt("etat"));
                r.setEtatString(r.getEtatString2());
                listereclam.add(r);
            }
            return listereclam;
        }
        
        public List<String> ListeSujet() throws SQLException
        {
            Statement req = con.createStatement(); 
	ResultSet r = req.executeQuery("select * from reclamation");
            List<String> sujet = new ArrayList<>();
        while (r.next()){
	//String a = r.getString(2);
        sujet.add(r.getString("sujet"));
        }
        return sujet;

        }
 public String get_email(int i) throws SQLException
        {
            String a ="";
            Statement req = con.createStatement(); 
	ResultSet r = req.executeQuery("select emailuser from utilisateur where iduser='"+i+"'");
            //List<String> sujet = new ArrayList<>();
        while (r.next()){
	//String a = r.getString(2);
        a=r.getString("emailuser");
        }
        return a;
        }
 
 
 public ObservableList<Reclamation> afficherMesReclams(int id_user) throws SQLException
        {
            ResultSet rs;
            String req = "select * from reclamation where idemetteur='"+id_user+"'";
            ste=con.createStatement();
            rs=ste.executeQuery(req);
            ObservableList<Reclamation> listereclam = FXCollections.observableArrayList();
            while(rs.next())
            {
                Reclamation r = new Reclamation();
                
                //r.setId(rs.getInt("id"));
                r.setSujet(rs.getString("sujet"));
                r.setTexte_reclamation(rs.getString("textereclamation"));
                r.setEtat(rs.getInt("etat"));
                r.setEtatString(r.getEtatString2());
                //r.setDate(rs.getDate("date"));
                listereclam.add(r);
            }
            return listereclam;
        }
 
        public void updateEtat(int id_reclam) throws SQLException
        {
            String req = " update reclamation set etat=? where id ='"+id_reclam+"'";
            PreparedStatement preparedStatement;
            preparedStatement = (PreparedStatement) con.prepareStatement(req);
            preparedStatement.setInt(1,1);
            //preparedStatement.setString(2, r.getTextereclamation());
            preparedStatement.executeUpdate();    
        }

}
			

    


    

