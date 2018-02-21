/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author samih
 */



/**
 *
 * @author samih
 */
public class user {
    private int id;


    

   
    private String nomuser;
    private String prenomuser ; 
    private String pseudouser ; 
    private String emailuser ; 
    private String password ; 
    private String numerouser;
    private String photo_profile;

   public user(int id, String nomuser, String prenomuser, String emailuser, String numerouser) {
        this.id = id;
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.emailuser = emailuser;
        this.numerouser = numerouser;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNumerouser() {
        return numerouser;
    }

    public void setNumerouser(String numerouser) {
        this.numerouser = numerouser;
    }
    private int role ;

    public String getNomuser() {
        return nomuser;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public String getPrenomuser() {
        return prenomuser;
    }

    public void setPrenomuser(String prenomuser) {
        this.prenomuser = prenomuser;
    }

    public String getPseudouser() {
        return pseudouser;
    }

    public void setPseudouser(String pseudouser) {
        this.pseudouser = pseudouser;
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    @Override
    public String toString() {
        return "user{" + "nomuser=" + nomuser + ", prenomuser=" + prenomuser + ", pseudouser=" + pseudouser + ", emailuser=" + emailuser + ", password=" + password + ", numerouser=" + numerouser + ", role=" + role + '}';
    }

  


    public user(String nomuser, String prenomuser, String pseudouser, String emailuser, String password, String numerouser, int role) {
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.pseudouser = pseudouser;
        this.emailuser = emailuser;
        this.password = password;
        this.numerouser = numerouser;
        this.role = role;
    }

//    public user(String nomuser, String prenomuser, String emailuser, String numerouser, String photo_profile, int role ) {
//        this.nomuser = nomuser;
//        this.prenomuser = prenomuser;
//        this.emailuser = emailuser;
//        this.numerouser = numerouser;
//        this.photo_profile = photo_profile;
//        this.role=role;
//    }

    public user(String nomuser, String prenomuser, String emailuser, String numerouser, String photo_profile, int role) {
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.emailuser = emailuser;
        this.numerouser = numerouser;
        this.photo_profile = photo_profile;
        this.role = role;
    }

    public String getPhoto_profile() {
        return photo_profile;
    }

    public void setPhoto_profile(String photo_profile) {
        this.photo_profile = photo_profile;
    }

    public user(String nomuser, String prenomuser, String emailuser, String numerouser) {
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.emailuser = emailuser;
        this.numerouser = numerouser;
    }

    public user(String nomuser, String prenomuser, String pseudouser, String emailuser, String numerouser, String photo_profile) {
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.pseudouser = pseudouser;
        this.emailuser = emailuser;
        this.numerouser = numerouser;
        this.photo_profile = photo_profile;
    }

    public user(String nomuser, String prenomuser, String pseudouser, String emailuser, String password, String numerouser, String photo_profile, int role) {
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.pseudouser = pseudouser;
        this.emailuser = emailuser;
        this.password = password;
        this.numerouser = numerouser;
        this.photo_profile = photo_profile;
        this.role = role;
    }

     

   
    
    
    
}


    

