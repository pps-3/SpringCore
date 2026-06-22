package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}