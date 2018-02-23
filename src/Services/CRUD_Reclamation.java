/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;


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
      
       PreparedStatement st=(PreparedStatement) con.prepareStatement("INSERT INTO reclamation (sujet,textereclamation,date) VALUES(?,?,NOW())");
       st.setString(1   ,r.getSujet());
       st.setString(2, r.getTextereclamation());
       //st.setDate(3, r.getDate());
       st.execute();
           
               
     
                }
        
        
        
        public void modifierReclamation(Reclamation rec){
        
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
             String req = "update reclamation set sujet=?,textereclamation=? where id ='"+rec.getId()+"' ?";
        PreparedStatement preparedStatement;
            preparedStatement = (PreparedStatement) con.prepareStatement(req);
            preparedStatement.setString(1, rec.getSujet());
            preparedStatement.setString(2, rec.getTextereclamation());
            //preparedStatement.setInt(3, i);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            
        }
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


}
			

    


    

