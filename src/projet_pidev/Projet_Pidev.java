/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_pidev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author samih
 */
public class Projet_Pidev extends Application {
  public static void main(String[] args) {
    Application.launch(Projet_Pidev.class, args);
}
    static Stage stg;
    @Override
    public void start(Stage stage) throws Exception {
    this.stg = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Inscri.fxml"));
        stage.setScene(new Scene(root,1200, 800));
        stage.show();
    }
    
}
