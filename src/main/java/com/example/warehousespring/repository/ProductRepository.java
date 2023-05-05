package com.example.warehousespring.repository;

import com.example.warehousespring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsById(int Id);

    boolean existsByProductName(String productName);

    @Override
    void deleteById(Integer integer);

}
