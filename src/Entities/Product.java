package Entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by VIRUS on 1/14/2019.
 */
public class Product {
    private SimpleStringProperty productName;
    private SimpleStringProperty productQuantity;
    private SimpleStringProperty productPrice;
    private SimpleStringProperty productDescription;
    private SimpleIntegerProperty productNumber;

    public Product(ProductsEntity entity) {
        this.productName=new SimpleStringProperty(entity.getProductName());
        this.productPrice= new SimpleStringProperty(entity.getProductPrice());
        this.productQuantity= new SimpleStringProperty(entity.getProductQuantity());
        this.productNumber= new SimpleIntegerProperty(entity.getProductNumber());
        this.productDescription= new SimpleStringProperty(entity.getProductDescription());
    }

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public String getProductQuantity() {
        return productQuantity.get();
    }

    public SimpleStringProperty productQuantityProperty() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity.set(productQuantity);
    }

    public String getProductPrice() {
        return productPrice.get();
    }

    public SimpleStringProperty productPriceProperty() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice.set(productPrice);
    }

    public String getProductDescription() {
        return productDescription.get();
    }

    public SimpleStringProperty productDescriptionProperty() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription.set(productDescription);
    }

    public int getProductNumber() {
        return productNumber.get();
    }

    public SimpleIntegerProperty productNumberProperty() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber.set(productNumber);
    }
}
