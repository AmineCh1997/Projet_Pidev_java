/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author samih
 */
public class Mail {
      Properties props;
      Session session ;
      public Mail(){
          props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
       


        //get Session   
        session= Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mohamedsamih.layeb@esprit.tn", "b982d5176f");
            }
        });
      }
      
         public void Send (String s ,String email){
             
         
                 
        //compose message    
        try {
            
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Confirmation du compte AyaWin");
            message.setText("Code de Confirmation : "+s );
            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
         }
          public void Send_validiation (String pseudo , String mp , String email){
             
         
                 
        //compose message    
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Validation du compte AyaWin reussite, Bienvenue entre nous :D ");
            message.setText("Votre Pseudo : "+pseudo+" Votre mot de passe : "+ mp);
            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
         }
            public void Send_Mot_passe (String mp , String email) throws AddressException, MessagingException{
             
         
                 
        //compose message    
  
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Compte AyaWin ");
            message.setText("Votre mot de passe : "+ mp);
            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        
         }
}
