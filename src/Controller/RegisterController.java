package Controller;

import Service.CustomerServiceClass;
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

import java.io.IOException;

import static MainClass.Main.stage;

/**
 * Created by VIRUS on 1/7/2019.
 */
public class RegisterController {
    @FXML
    private TextField firstname;

    @FXML
    private TextField surname;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmpassword;

    @FXML
    private Button submitButton;

    @FXML
    private Button nextButton;


    public void OnClickSubmit(ActionEvent actionEvent) {
        CustomerServiceClass customerServiceClass = new CustomerServiceClass();
        try{
            if(firstname.textProperty().getValue().isEmpty() || surname.textProperty().getValue().isEmpty()
                     || email.textProperty().getValue().isEmpty() || password.textProperty().getValue().isEmpty()
                    || confirmpassword.textProperty().getValue().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setContentText("ALL FIELDS MUST BE FILLED");
                alert.showAndWait();
            }
             /*if(pwd1.getText()!=pwd2.getText()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("CONFIRMATION DIALOG");
                alert.setContentText("PASSWORD DOES NOT MATCH");
                alert.showAndWait();
            }*/
            else{

                customerServiceClass.CreateCustomer(firstname.textProperty().getValue(),surname.textProperty().getValue(),
                        email.textProperty().getValue(),password.textProperty().getValue(),confirmpassword.textProperty().getValue());
                firstname.setText(null);
                surname.setText(null);
                email.setText(null);
                password.setText(null);
                confirmpassword.setText(null);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONFIRMATION DIALOG");
                alert.setContentText("YOU SUCCESSFULLY REGISTERED\n. CLICK NEXT TO LOGIN");
                alert.showAndWait();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

    public void OnClickNext(ActionEvent actionEvent) {
        try {

                Parent root = FXMLLoader.load(getClass().getResource("../FXMLDocuments/Login.fxml"));
                Scene scene= new Scene(root,500,350);
                Main.stage.setTitle("LOGIN PAGE");

                stage.setScene(scene);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
