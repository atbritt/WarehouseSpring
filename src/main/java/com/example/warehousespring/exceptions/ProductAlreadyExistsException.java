package com.example.warehousespring.exceptions;

public class ProductAlreadyExistsException extends RuntimeException{
    public ProductAlreadyExistsException() {
        super("Product already Exists by Name.");
    }
}
