package com.example.warehousespring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestProduct {
    private int id;
    private String productName;
    private String productDetails;
    private float productPrice;
    private int stockAmount;
    private float productWeight;
}
