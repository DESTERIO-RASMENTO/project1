package Controller;

import Service.ProductServiceClass;
import Entities.Product;
import Entities.ProductsEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import MainClass.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static MainClass.Main.stage;

/**
 * Created by VIRUS on 1/9/2019.
 */
public class ViewProductsController implements Initializable {
    @FXML
    private TableView<Product> tableView;

    @FXML
    private TableColumn<Product,Integer> productNumber;

    @FXML
    private TableColumn<Product,String> productName;

    @FXML
    private TableColumn<Product,String> productQuantity;

    @FXML
    private TableColumn<Product,String> productPrice;

    @FXML
    private TableColumn<Product, String> productDescription;

    @FXML
    private Button GoToPictures;



    @FXML
    void OnClickGoToPictures(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../FXMLDocuments/pictures.fxml"));
            Scene scene= new Scene(root,700,700);
            Main.stage.setTitle("PICTURES");

            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setInitColumns();
        tableView.setItems(getProductsData());
    }

    public void setInitColumns(){
            productNumber.setCellValueFactory(new PropertyValueFactory<>("productNumber"));
            productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
            productQuantity.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
            productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
            productDescription.setCellValueFactory(new PropertyValueFactory<>("productDescription"));
        }
        private ObservableList<Product>data;
        private ProductServiceClass productServiceClass;
        public ObservableList<Product>getProductsData(){
            productServiceClass = new ProductServiceClass();
            List<Product>products=new ArrayList<>();

            List<ProductsEntity>productsEntityList= productServiceClass.getAllProducts();
            productsEntityList.forEach(p->{
                Product product=new Product(p);
                products.add(product);

            });

            data= FXCollections.observableArrayList(products);
            if(data==null){
                return  FXCollections.observableArrayList();
            }
            return data;

        }
}

