/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
//import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Yacine
 */
public class Reclamation {
    private int id;
    public String sujet ;
    private String textereclamation ;
    private Date date ;
    //private int etat ;
    //public ObservableList<Reclamation> afficherReclamation;

    public Reclamation(String sujet, String textereclamation) {
        this.sujet = sujet;
        this.textereclamation = textereclamation;
        //this.id_reclamation=id_reclamation;
    }

    
    

    public Reclamation(int id) {
        this.id = id;
    }

    public Reclamation(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    

//    public Reclamation(int id_reclamation, String sujet, String texte_reclamation, int etat) {
//        this.id_reclamation = id_reclamation;
//        this.sujet = sujet;
//        this.texte_reclamation = texte_reclamation;
//        //this.date = date;
//        this.etat = etat;
//    }

    public Reclamation() {
    }
    

    public int getId() {
        return id;
    }

    public String getSujet() {
        return sujet;
    }

    public String getTextereclamation() {
        return textereclamation;
    }

//    public Date getDate() {
//        return date;
//    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setTexte_reclamation(String textereclamation) {
        this.textereclamation = textereclamation;
    }

//    public void setDate(Date date) {
//        this.date = date;
//    }
    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", sujet=" + sujet + ", textereclamation=" + textereclamation + '}';
    }

    

   

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        return Objects.equals(this.sujet, other.sujet);
    }

    
    
    
}
