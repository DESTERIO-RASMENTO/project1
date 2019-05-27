package Controller;

import Entities.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import MainClass.Main;
//import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

import static MainClass.Main.stage;

public class LoginController {
    @FXML
    private TextField firsname;

    @FXML
    private PasswordField password;

    @FXML
    private Button logginButton;

    @FXML
    private Button RegisterButton;


    public void onClickRegister(ActionEvent actionEvent) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../FXMLDocuments/Registration.fxml"));
            Scene scene= new Scene(root,500,400);
            Main.stage.setTitle("REGISTRATION");

             stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OnClickLogin(ActionEvent actionEvent) {

           String firstnameText = firsname.getText();
           String passwordText = password.getText();
           if(firstnameText.isEmpty() && passwordText.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("WARNING DIALOG");
               alert.setContentText("PLEASE PROVIDE YOUR CREDENTIALS");
               alert.showAndWait();
           }
           else if (firstnameText.isEmpty()||passwordText.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("WARNING DIALOG");
               alert.setContentText("USERNAME OR PASSWORD FIELD CANNOT BE EMPTY");
               alert.showAndWait();

           }
           else{
               EntityManagerFactory factory = Persistence.createEntityManagerFactory("PROJECT");
               EntityManager em = factory.createEntityManager();
               em.getTransaction().begin();
               List<Customer>customerList=em.createQuery("select s from Customer s where s.firstname=:firstname",Customer.class)
                       .setParameter("firstname",firstnameText).getResultList();


               if(!customerList.isEmpty()){
                   if(passwordText.equals(customerList.get(0).getPassword())){
                       try{
                           Parent root = FXMLLoader.load(getClass().getResource("../FXMLDocuments/viewProducts.fxml"));
                           Scene scene= new Scene(root,500,400);
                           Main.stage.setTitle("OUR PRODUCTS");

                           stage.setScene(scene);
                       }catch (Exception e){
                           e.printStackTrace();
                       }
                   }
                   else{
                       //wrong password
                       Alert alert = new Alert(Alert.AlertType.WARNING);
                       alert.setTitle("WARNING DIALOG");
                       alert.setContentText("WRONG PASSWORD");
                       alert.showAndWait();
                   }

               }
               else {
                   //no user with the username
                   Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("WARNING DIALOG");
                   alert.setContentText("NO USER WITH THE ABOVE NAME");
                   alert.showAndWait();
               }

           }

    }


}
