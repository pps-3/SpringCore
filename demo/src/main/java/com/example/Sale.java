package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private double pricePerUnit;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Sale() {}

    public Sale(int quantity, double pricePerUnit, Product product) {
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


   @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", productName='" + (product != null ? product.getName() : "null") + '\'' +
                '}';
}
}