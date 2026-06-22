package com.example;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    // a) All sales for given product
    List<Sale> findByProductName(String name);

    // b) Quantity between range
    List<Sale> findByQuantityBetween(int min, int max);

    // c) Price per unit sold < current product price
    @Query("select s from Sale s where s.pricePerUnit < s.product.price")
    List<Sale> findSalesWithLowerPrice();

    // d) Ascending order of quantity
    List<Sale> findAllByOrderByQuantityAsc();

    // e) Pagination
    Page<Sale> findAll(Pageable pageable);
}