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
    private int etat ;
    private String etatString ;

    public Reclamation(String sujet, String textereclamation) {
        this.sujet = sujet;
        this.textereclamation = textereclamation;
      
        
    }

    public Reclamation(int id, String sujet, String textereclamation) {
        this.id = id;
        this.sujet = sujet;
        this.textereclamation = textereclamation;
    }

    public Reclamation(int id, String sujet, String textereclamation, Date date, int etat, String etatString) {
        this.id = id;
        this.sujet = sujet;
        this.textereclamation = textereclamation;
        this.date = date;
        this.etat = etat;
        this.etatString = etatString;
    }

    public String getEtatString() {
        return etatString;
    }

    public void setEtatString(String etatString) {
        this.etatString = etatString;
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

    public int getEtat() {
        return etat;
    }
    
    public String getEtatString2() {
        String a = "Non traitée";
        String b = "Traitée";
        if(etat==0)
        return a;
        else return b;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Reclamation(int id, String sujet, String textereclamation, Date date, int etat) {
        this.id = id;
        this.sujet = sujet;
        this.textereclamation = textereclamation;
        this.date = date;
        this.etat = etat;
    }
    
    
    
    

    

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

    public void setTextereclamation(String textereclamation) {
        this.textereclamation = textereclamation;
    }

   

    
    
    
}
