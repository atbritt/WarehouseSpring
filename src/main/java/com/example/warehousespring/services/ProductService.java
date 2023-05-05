package com.example.warehousespring.services;

import com.example.warehousespring.dtos.RequestProduct;
import com.example.warehousespring.exceptions.ProductAlreadyExistsException;
import com.example.warehousespring.models.Product;
import com.example.warehousespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Product newProduct(RequestProduct requestProduct) {

        Product newProduct = new Product(requestProduct);

        if(!productRepository.existsByProductName(newProduct.getProductName())){
            return productRepository.save(newProduct);

        } throw new ProductAlreadyExistsException();

    }
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
    public Optional<Product> getProductById(int id) {
        return this.productRepository.findById(id);
    }
    public void deleteProductById(int id) {
        this.productRepository.deleteById(id);
    }
    public Product upsertProduct(RequestProduct requestProduct) {
        Product upsertProduct = new Product(requestProduct);
        return this.productRepository.save(upsertProduct);
    }
}
