/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author Yacine
 */
public class Abonnement {
    private int id_user;
    private int id_produit;

    public Abonnement(int id_user, int id_produit) {
        this.id_user = id_user;
        this.id_produit = id_produit;
    }

    public Abonnement() {
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

    
}
