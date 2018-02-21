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
public class Publication {
    private int id;
    private String contenu;
    private String photo;
    private int iduser;
    private Date datepublication;

    public Publication() {
    }

    public Publication(String contenu, Date datepublication) {
        this.contenu = contenu;
        this.datepublication = datepublication;
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

    public Date getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Date datepublication) {
        this.datepublication = datepublication;
    }

    public Publication(String contenu) {
        this.contenu = contenu;
    }

    public Publication(String contenu, String photo, int iduser, Date datepublication) {
        this.contenu = contenu;
        this.photo = photo;
        this.iduser = iduser;
        this.datepublication = datepublication;
    }

    public Publication(String contenu, String photo) {
        this.contenu = contenu;
        this.photo = photo;
    }

    public Publication(int id, String contenu) {
        this.id = id;
        this.contenu = contenu;
    }
    
    
}
