package com.example.warehousespring.models;


import com.example.warehousespring.dtos.RequestProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String productDetails;
    private float productPrice;
    private int stockAmount;
    private float productWeight;


    public Product (RequestProduct requestProduct){
        this.id = requestProduct.getId();
        this.productName = requestProduct.getProductName();
        this.productDetails = requestProduct.getProductDetails();
        this.productPrice = requestProduct.getProductPrice();
        this.stockAmount = requestProduct.getStockAmount();
        this.productWeight = requestProduct.getProductWeight();
    }

}
