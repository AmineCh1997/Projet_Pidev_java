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
public class commentaire {
   
   
    private int id_commentaire;
    private String cin_personne;
    private String id_produit;
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

    public String getCin_personne() {
        return cin_personne;
    }

    public void setCin_personne(String cin_personne) {
        
        this.cin_personne = cin_personne;
    }

    public String getId_produit() {
        return id_produit;
    }

    public void setId_produit(String id_produit) {
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
     

    public commentaire( String cin_personne, String id_produit, String texte) {
       
        this.cin_personne = cin_personne;
        this.id_produit = id_produit;
        this.texte = texte;
        
         
    }

    public commentaire(int id_commentaire, String cin_personne, String id_produit, String texte) {
        this.id_commentaire = id_commentaire;
        this.cin_personne = cin_personne;
        this.id_produit = id_produit;
        this.texte = texte;
    }
    

}

