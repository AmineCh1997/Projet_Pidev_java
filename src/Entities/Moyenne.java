/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ESPRIT
 */
public class Moyenne {
    private float moyenne_produit;

    public float getMoyenne_produit() {
        return moyenne_produit;
    }

    public void setMoyenne_produit(float moyenne_produit) {
        this.moyenne_produit = moyenne_produit;
    }

    public Moyenne(int moyenne_produit) {
        this.moyenne_produit = moyenne_produit;
    }
    
}
