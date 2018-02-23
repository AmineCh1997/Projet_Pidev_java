/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samih
 */
public class Basededonne {
    private static Basededonne instance;
    private Connection connection;
    private String url = "jdbc:mysql://127.0.0.1/bon_plan";
    private String username = "root";
    private String password = "";

    Basededonne() {
        try {
         connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Basededonne getInstance()  {
        if (instance == null) {
            instance = new Basededonne();
        } else try {
            if (instance.getConnection().isClosed()) {
                instance = new Basededonne();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Basededonne.class.getName()).log(Level.SEVERE, null, ex);
        }

        return instance;
    }
    
}
