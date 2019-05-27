package Controller;

import MainClass.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import static MainClass.Main.stage;

/**
 * Created by VIRUS on 1/15/2019.
 */
public class ImageViewController implements Initializable{
    @FXML
    private ComboBox<String> selectComboBox;

    @FXML
    private ImageView imageView;

    @FXML
    private Button backToProductButton;

    @FXML
    private Button exitButton;


    @FXML
    void OnSelectProduct(ActionEvent event) {
        //ObservableList<String>options=FXCollections.observableArrayList();
       // ComboBox comboBox = new ComboBox();
        Image apple = new Image("Images/apple.jpeg");
        Image avocado = new Image("Images/avocado.jpeg");
        Image mango = new Image("Images/mango.jpg");
        Image papaw = new Image("Images/pawpaw.jpeg");
        Image pineapple = new Image("Images/pineapple.jpeg");
        Image straberry = new Image("Images/strawberry.jpeg");
        Image tomato = new Image("Images/tomato.jpeg");
        Image banana = new Image("Images/banana.jpeg");
        Image watermelon = new Image("Images/watermelon.jpeg");
        if(selectComboBox.getValue()=="Banana"){
            imageView.setImage(banana);
        }else if(selectComboBox.getValue()=="Mango"){
            imageView.setImage(mango);
        }
        else if(selectComboBox.getValue()=="Avocado"){
            imageView.setImage(avocado);
        }else if(selectComboBox.getValue()=="Apple"){
            imageView.setImage(apple);
        }else if(selectComboBox.getValue()=="Pawpaw"){
            imageView.setImage(papaw);
        }else if(selectComboBox.getValue()=="Pineapple"){
            imageView.setImage(pineapple);
        }else if(selectComboBox.getValue()=="Strawberry"){
            imageView.setImage(straberry);
        }else if(selectComboBox.getValue()=="Tomato"){
            imageView.setImage(tomato);
        }else imageView.setImage(watermelon);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectComboBox.setPromptText("select");
        selectComboBox.getItems().addAll("Banana","Mango","Avocado",
                "Apple","Pawpaw","Strawberry","Watermelon","Tomato","Pineapple");
        //selectComboBox.getSelectionModel().select(0);


    }
    @FXML
    void onClickBackToProducts(ActionEvent event) {

        try{
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLDocuments/viewProducts.fxml"));
            Scene scene= new Scene(root,550,400);
            Main.stage.setTitle("OUR PRODUCTS");

            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    void OnClickExit(ActionEvent event) {
        System.exit(0);

    }
}
