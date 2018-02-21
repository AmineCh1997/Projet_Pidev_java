/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.sql.Date;

/**
 *
 * @author emirc
 */
public class Promotion {
    private int id;
    private String contenu;
    private String photo;
    private int id_user;
    private Date datepromotion;

    public Promotion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDatepromotion() {
        return datepromotion;
    }

    public void setDatepromotion(Date datepromotion) {
        this.datepromotion = datepromotion;
    }

    public Promotion(String contenu) {
        this.contenu = contenu;
    }

    public Promotion(String contenu, String photo, int id_user, Date datepromotion) {
        this.contenu = contenu;
        this.photo = photo;
        this.id_user = id_user;
        this.datepromotion = datepromotion;
    }

    public Promotion(String contenu, String photo) {
        this.contenu = contenu;
        this.photo = photo;
    }

    
    
}
