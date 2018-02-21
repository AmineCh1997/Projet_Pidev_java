/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Amine
 */
public class Produit {
    
    private String img ;
    private int id  ; 
    private String nom ; 
    private String description ;
    private int id_cat ; 
    private String ville ;
    private String adresse  ;
    private int id_user ;

    public Produit(String img, String nom, String description, int id_cat, String ville, String adresse, int id_user) {
        this.img = img;
        this.nom = nom;
        this.description = description;
        this.id_cat = id_cat;
        this.ville = ville;
        this.adresse = adresse;
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getVille() {
        return ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public int getId_cat() {
        return id_cat;
    }

    public String getDescription() {
        return description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Produit( int id_cat,String nom ,String description) {
        this.nom = nom;
        this.id_cat = id_cat;
        this.description = description;
    }

    public Produit(String nom) {
        this.nom = nom;
    }
    

    public Produit() {
    }

    public Produit(int id) {
        this.id=id ; 
    }

    public Produit(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Produit(String nom, String description, int id_cat, String ville, String adresse) {
        this.nom = nom;
        this.description = description;
        this.id_cat = id_cat;
        this.ville = ville;
        this.adresse = adresse;
    }

    public Produit(String img, String nom, String description, int id_cat, String ville, String adresse) {
        this.img = img;
        this.nom = nom;
        this.description = description;
        this.id_cat = id_cat;
        this.ville = ville;
        this.adresse = adresse;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
