package MainClass;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public  static   Stage stage=null;



    @Override
    public void start(Stage primaryStage) throws Exception {


        try {
            stage = primaryStage;
          Parent  root = FXMLLoader.load(getClass().getResource("../FXMLDocuments/Login.fxml"));
            primaryStage.setTitle("LOGIN PAGE");
            primaryStage.setScene(new Scene(root, 500, 350));
            primaryStage.show();
        }
        catch (IOException e) {
        e.printStackTrace();
    }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
