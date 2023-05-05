package com.example.warehousespring.controllers;


import com.example.warehousespring.dtos.RequestProduct;
import com.example.warehousespring.models.Product;
import com.example.warehousespring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = {
        "http://localhost:8080"
}, allowedHeaders = "*", allowCredentials = "true", maxAge = 300000)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;}

    @PostMapping("/new-product")
    public ResponseEntity<Product> newProduct (@RequestBody RequestProduct requestProduct){
        Product product = this.productService.newProduct(requestProduct);

        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/all-products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable String id){
        return ResponseEntity.ok(this.productService.getProductById(Integer.parseInt(id)));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductById(@PathVariable int id){
        productService.deleteProductById(id);
        return "Product deleted";
    }

    @PostMapping("/upsert-product/{id}")
    public ResponseEntity<Product> upsertProduct(@PathVariable int id, @RequestBody RequestProduct requestProduct){
        deleteProductById(id);
        Product upsertProduct = this.productService.upsertProduct(requestProduct);

        return ResponseEntity.ok().body(upsertProduct);
    }


}
