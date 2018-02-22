/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * 
 */
public class avis {
    

    public avis() {
        
    }
    private String id_produit;
    private int id;
    private int note;

    public String getId_produit() {
        return id_produit;
    }

    public void setId_produit(String id_produit) {
        this.id_produit = id_produit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getnote() {
        return note;
    }

    public void note(int note) {
        this.note = note;
    }

    public avis(String id_produit, int note) {
        this.id_produit = id_produit;
        this.note = note;
    }

    public avis(String id_produit) {
        this.id_produit = id_produit;
    }

    public avis(int id) {
        this.id = id;
    }

   
    
    
   
}
