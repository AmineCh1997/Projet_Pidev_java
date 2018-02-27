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
public class Menu {
    private int id ; 
    private String plat ; 
    private Float  prix ;  
    private int id_produit ; 

    public Menu(int id, String plat, Float prix, int id_produit) {
        this.id = id;
        this.plat = plat;
        this.prix = prix;
        this.id_produit = id_produit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", plat=" + plat + ", prix=" + prix + ", id_produit=" + id_produit + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Menu other = (Menu) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_produit != other.id_produit) {
            return false;
        }
        if (!Objects.equals(this.plat, other.plat)) {
            return false;
        }
        if (!Objects.equals(this.prix, other.prix)) {
            return false;
        }
        return true;
    }

    public Menu() {
    }

    public Menu(String plat, Float prix, int id_produit) {
        this.plat = plat;
        this.prix = prix;
        this.id_produit = id_produit;
    }

    
}
