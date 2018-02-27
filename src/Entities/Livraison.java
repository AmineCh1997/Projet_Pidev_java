/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author samih
 */
public class Livraison {
    public int id ; 
    public int id_user ;
    public int id_produit;
    public String adresse;
     public int nbr_produit;
    public int etat ;
    public String nom_produit;

    public Livraison(int id_user, int id_produit, String adresse, int nbr_produit, int etat, String nom_produit) {
        this.id_user = id_user;
        this.id_produit = id_produit;
        this.adresse = adresse;
        this.nbr_produit = nbr_produit;
        this.etat = etat;
        this.nom_produit = nom_produit;
    }

    public Livraison() {
    }

    public Livraison(int id_user, int id_produit, int nbr_produit, int etat, String nom_produit) {
        this.id_user = id_user;
        this.id_produit = id_produit;
        this.nbr_produit = nbr_produit;
        this.etat = etat;
        this.nom_produit = nom_produit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbr_produit() {
        return nbr_produit;
    }

    public void setNbr_produit(int nbr_produit) {
        this.nbr_produit = nbr_produit;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", id_user=" + id_user + ", id_produit=" + id_produit + ", adresse=" + adresse + ", nbr_produit=" + nbr_produit + ", etat=" + etat + ", nom_produit=" + nom_produit + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + this.id_user;
        hash = 79 * hash + this.id_produit;
        hash = 79 * hash + Objects.hashCode(this.adresse);
        hash = 79 * hash + this.nbr_produit;
        hash = 79 * hash + Objects.hashCode(this.etat);
        hash = 79 * hash + Objects.hashCode(this.nom_produit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livraison other = (Livraison) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_produit != other.id_produit) {
            return false;
        }
        if (this.nbr_produit != other.nbr_produit) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (!Objects.equals(this.nom_produit, other.nom_produit)) {
            return false;
        }
        return true;
    }

    public Livraison(String adresse, int nbr_produit, int etat, String nom_produit) {
        this.adresse = adresse;
        this.nbr_produit = nbr_produit;
        this.etat = etat;
        this.nom_produit = nom_produit;
    }

   
    
    
}
