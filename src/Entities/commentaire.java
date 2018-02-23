/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * 
 */
public class commentaire {


   
    private int id_commentaire;
    private int iduser;
    private int id_produit;
    private String texte;




    public int getId_commentaire() {
        return id_commentaire;
    }
     public String getId_commentaire1() {
         String a=""+id_commentaire;
        return a;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public int getCin_personne() {
        return iduser;
    }

    public void setCin_personne(int iduser) {
        
        this.iduser = iduser;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
     public commentaire() {
       
    }

    public commentaire(int id_commentaire, String texte) {
        this.id_commentaire = id_commentaire;
        this.texte = texte;
    }
     

    public commentaire( int iduser, int id_produit, String texte) {
       
        this.iduser = iduser;
        this.id_produit = id_produit;
        this.texte = texte;
         
    }

    public commentaire(int id_commentaire, int iduser, int id_produit, String texte) {
        this.id_commentaire = id_commentaire;
        this.iduser = iduser;
        this.id_produit = id_produit;
        this.texte = texte;
    }

    public commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }
    
    
   
    
       
 
  
}

