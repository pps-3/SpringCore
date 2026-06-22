package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(DemoApplication.class, args);

        ProductRepository productRepo =
                context.getBean(ProductRepository.class);

        SaleRepository saleRepo =
                context.getBean(SaleRepository.class);

        // Create Product
        Product p = new Product("Laptop", 60000);
        productRepo.save(p);

        // Create Sales
        saleRepo.save(new Sale(5, 55000, p));
        saleRepo.save(new Sale(10, 58000, p));
        saleRepo.save(new Sale(15, 61000, p));
        saleRepo.save(new Sale(20, 50000, p));
        saleRepo.save(new Sale(25, 52000, p));
        saleRepo.save(new Sale(30, 59000, p));

        // a) All sales for given product
        System.out.println("---- Sales for Laptop ----");
        List<Sale> list1 = saleRepo.findByProductName("Laptop");
        list1.forEach(System.out::println);

        // b) Quantity between range
        System.out.println("---- Quantity between 10 and 25 ----");
        List<Sale> list2 = saleRepo.findByQuantityBetween(10, 25);
        list2.forEach(System.out::println);

        // c) Price per unit sold < current product price
        System.out.println("---- Price less than Product Price ----");
        List<Sale> list3 = saleRepo.findSalesWithLowerPrice();
        list3.forEach(System.out::println);

        // d) Ascending order of quantity
        System.out.println("---- Sorted by Quantity ----");
        List<Sale> list4 = saleRepo.findAllByOrderByQuantityAsc();
        list4.forEach(System.out::println);

        // e) 2nd page with size 4
        System.out.println("---- Second Page (size = 4) ----");
        Page<Sale> page = saleRepo.findAll(PageRequest.of(1, 4));
        page.getContent().forEach(System.out::println);
    }
}