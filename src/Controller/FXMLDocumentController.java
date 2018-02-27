/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Entities.Mail;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Entities.user;
import Services.CRUD_USER;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;


/**
 *
 * @author samih
 */
public class FXMLDocumentController implements Initializable {
    
   @FXML  Pane child_pane;
    @FXML JFXTextField TextFname;
    @FXML JFXTextField TextLname;
    @FXML JFXTextField TextPseudo;
    @FXML JFXTextField TextEmail;
    @FXML JFXTextField TextPhone;
    @FXML JFXPasswordField TextPassword;
    @FXML JFXPasswordField TextPasswordConf;
    JFXButton BtnContinue;
    @FXML AnchorPane AnchorErrorN1;
    @FXML AnchorPane AnchorErrorN2;
    @FXML AnchorPane AnchorErrorN3;
    @FXML AnchorPane AnchorErrorN4;
    @FXML AnchorPane AnchorErrorN5;
    @FXML AnchorPane AnchorErrorN6;
    @FXML AnchorPane AnchorErrorN7;  
    @FXML AnchorPane MainAnchor;
    @FXML ImageView ImageError1;
    @FXML ImageView ImageError2;
    @FXML ImageView ImageError3;
    @FXML ImageView ImageError4;
    @FXML ImageView ImageError5;
    @FXML ImageView ImageError6;
    @FXML ImageView ImageError7;
    @FXML
    private JFXButton btnResetAll;
    @FXML
    private JFXButton btnContinue;
    @FXML
    private JFXButton btnTest;
    @FXML
    private JFXRadioButton user_box;
    @FXML
    private JFXRadioButton planneur_box;
   public static String message ; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TextFname.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(TextFname.getText().equals("")||TextFname.getLength()<4||TextFname.getLength()>15)
                    ImageError1.setVisible(true);
                else
{
            ImageError1.setVisible(false);}
            }
        });
        TextLname.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(TextLname.getText().equals("")||TextLname.getLength()<4||TextLname.getLength()>15)

                    ImageError2.setVisible(true);
                else
{
            ImageError2.setVisible(false);}
            }
        });
          TextPseudo.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(TextPseudo.getText().equals("")||TextPseudo.getLength()<4||TextPseudo.getLength()>15||rechercher_pseudo(TextPseudo.getText()))

                    ImageError3.setVisible(true);
                else
{
            ImageError3.setVisible(false);}
            }
        });
           TextEmail.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(TextEmail.getText().equals("")||!validate(TextEmail.getText()))

                    ImageError4.setVisible(true);
                else
{
            ImageError4.setVisible(false);}
            }
        });    
           TextPhone.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(TextPhone.getText().equals("")||TextPhone.getLength()!=8||!isANumber(TextPhone.getText()))

                    ImageError5.setVisible(true);
                else
{
            ImageError5.setVisible(false);}
            }
        });
            TextPassword.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(TextPassword.getText().equals("")||TextPassword.getLength()<4||TextPassword.getLength()>15||!PasswordStrong(TextPassword.getText()))

                    ImageError6.setVisible(true);
                else
{
            ImageError6.setVisible(false);}
            }
        });
             TextPasswordConf.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!TextPasswordConf.getText().equals(TextPassword.getText()))

                    ImageError7.setVisible(true);
                else
{
            ImageError7.setVisible(false);}
            }
        });
           
          
// TODO
    }

   @FXML private void ajout_user(ActionEvent event)throws SQLException, IOException
    {
        List<Integer> list = verif_Form();      
        for(int i=0;i<list.size();i++){
            
            if (list.get(i)==1) {
                
               ((ImageView) MainAnchor.lookup("#ImageError"+(i+1))).setVisible(true);
             
            }
            else {
                ((ImageView) MainAnchor.lookup("#ImageError"+(i+1))).setVisible(false);
            }
            
        }
        if (!list.stream().anyMatch(e->e==1))
        {
            if(planneur_box.isSelected()){
           user U=new user(TextFname.getText(),TextLname.getText(),TextPseudo.getText(),TextEmail.getText(),TextPassword.getText(),TextPhone.getText(),3);  
//             CRUD_USER crud=new CRUD_USER();
//             crud.insertST(U);
                 user_box.setSelected(false);
             InscriController.current_user= U ;
            }
            else if (user_box.isSelected()){
                user U=new user(TextFname.getText(),TextLname.getText(),TextPseudo.getText(),TextEmail.getText(),TextPassword.getText(),TextPhone.getText(),0);  
//             CRUD_USER crud=new CRUD_USER();
//             crud.insertST(U);
             planneur_box.setSelected(false);
             InscriController.current_user= U ;
            }
              Mail email = new Mail();
                String s = Long.toHexString(Double.doubleToLongBits(Math.random()));
       s=s.substring(10);
       s=s.toString().toUpperCase();
       message=s ;
      email.Send(message,TextEmail.getText());
               Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/Views/Confirmation.fxml"));
      child_pane.getChildren().add(newLoadedPane);
      MainAnchor.setDisable(true);
   
     
        }    
        
        
    }
   @FXML private void reset_All ( ActionEvent event )
   {
     TextFname.clear();
     TextLname.clear();
     TextPseudo.clear();
     TextPhone.clear();
     TextEmail.clear();
     TextPassword.clear();
     TextPasswordConf.clear();
     for ( int i = 0;i<7;i++)
     {
          ((ImageView) MainAnchor.lookup("#ImageError"+(i+1))).setVisible(false);
     }
     
   }
  
    private List<Integer> verif_Form(){
 
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<7;i++) list.add(0);
        if(TextFname.getText().equals("")||TextFname.getLength()<4||TextFname.getLength()>15)
            list.set(0,1);
        if(TextLname.getText().equals("")||TextLname.getLength()<4||TextLname.getLength()>15)
            list.set(1, 1);
        if(TextPseudo.getText().equals("")||TextPseudo.getLength()<4||TextPseudo.getLength()>15||rechercher_pseudo(TextPseudo.getText()))
            list.set(2, 1);
        if(TextEmail.getText().equals("")||!validate(TextEmail.getText()))
            list.set(3, 1);
        if(TextPhone.getText().equals("")||TextPhone.getLength()!=8||!isANumber(TextPhone.getText()))
            list.set(4, 1);
        if(TextPassword.getText().equals("")||TextPassword.getLength()<4||TextPassword.getLength()>15||!PasswordStrong(TextPassword.getText()))
            list.set(5, 1);
        if(!TextPasswordConf.getText().equals(TextPassword.getText()))
            list.set(6, 1); 
         return list;
    }
    @FXML private void AffichageError1 ()
   {
      AnchorErrorN1.setVisible(true);
   }
    @FXML private void HideError1 ()
   {
      AnchorErrorN1.setVisible(false);
   }
     @FXML private void AffichageError2 ()
   {
      AnchorErrorN2.setVisible(true);
   }
    @FXML private void HideError2 ()
   {
      AnchorErrorN2.setVisible(false);
   }
     @FXML private void AffichageError3()
   {
      AnchorErrorN3.setVisible(true);
   }
    @FXML private void HideError3()
   {
      AnchorErrorN3.setVisible(false);
   }
     @FXML private void AffichageError4 ()
   {
      AnchorErrorN4.setVisible(true);
   }
    @FXML private void HideError4 ()
   {
      AnchorErrorN4.setVisible(false);
   }
     @FXML private void AffichageError5 ()
   {
      AnchorErrorN5.setVisible(true);
   }
    @FXML private void HideError5 ()
   {
      AnchorErrorN5.setVisible(false);
   }
     @FXML private void AffichageError6()
   {
      AnchorErrorN6.setVisible(true);
   }
    @FXML private void HideError6()
   {
      AnchorErrorN6.setVisible(false);
   }
     @FXML private void AffichageError7 ()
   {
      AnchorErrorN7.setVisible(true);
   }
    @FXML private void HideError7 ()
   {
      AnchorErrorN7.setVisible(false);
   }
    public static boolean PasswordStrong(String pass) {
    String expresion = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    Pattern patron = Pattern.compile(expresion);
    Matcher m = patron.matcher(pass);
    if (m.find())
        return true;
    return false;
}  
 public static  boolean validate( String email){
 final String EMAIL_VERIFICATION = "^([\\w-\\.]+)@([\\w\\.]+)\\.([a-z]){2,}$";
Pattern pattern = Pattern.compile(EMAIL_VERIFICATION);
        Matcher matcher = pattern.matcher(email);
		return matcher.matches();

	  }
 public boolean isANumber(String s)
{
     for(int i=0;i<s.length();i++){
          if(!Character.isDigit(s.charAt(i))) 
               return false;
     }
     return true;
}
 public boolean rechercher_pseudo (String s)
 {
    CRUD_USER cr = new CRUD_USER();
    return cr.get_Pseudo().contains(s); 
 }

  @FXML
    private void go_Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/Inscri.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
    InscriController ncont = fxmlLoader.<InscriController>getController();
        Scene scene = new Scene(root,1200,800);
        Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
        
        stage.setScene(scene);
        stage.show();
        
    }
   
 
  
} 
