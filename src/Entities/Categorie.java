package Entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amine
 */
public class Categorie {
    public int id  ; 
    public String nom ;
    

    public String getNom() {
        return nom;
    }
    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = (id);
    }

    

    public Categorie(int id, String nom) {
        this.id = (id);
        this.nom =(nom);
    }

    public Categorie(String nom) {
        this.nom =nom;
    }
    

    public Categorie() {
    }
    
    
    
    
}
