package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private int pid;

    private String pname;

    private double price;

    public Product() {
    }

    public Product(int pid,
                   String pname,
                   double price) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public double getPrice() {
        return price;
    }
}