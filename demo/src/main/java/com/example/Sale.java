package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sale {

    @Id
    private int sid;

    private int qty;

    private double pricePerUnit;

    @ManyToOne
    @JoinColumn(name="pid")
    private Product product;

    public Sale() {
    }

    public Sale(int sid, int qty,
                double pricePerUnit,
                Product product) {
        this.sid = sid;
        this.qty = qty;
        this.pricePerUnit = pricePerUnit;
        this.product = product;
    }

    public int getSid() {
        return sid;
    }

    public int getQty() {
        return qty;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return sid + " " +
               qty + " " +
               pricePerUnit;
    }
}