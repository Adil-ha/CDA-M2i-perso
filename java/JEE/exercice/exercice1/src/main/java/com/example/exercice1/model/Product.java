package com.example.exercice1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name= "T_Product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String brand;
    private  String reference;
    private LocalDate datePurchase;
    private Double price;
    private int stock;

    public Product(String brand, String reference, LocalDate datePurchase, Double price, int stock) {
        this.brand = brand;
        this.reference = reference;
        this.datePurchase = datePurchase;
        this.price = price;
        this.stock = stock;
    }

    public void decrementStock() {
        this.stock--;
    }
    @Override
    public String toString() {
        return String.format(
                "Product{idProduct=%d, brand='%s', reference='%s', datePurchase=%s, price=%.2f, stock=%d}",
                idProduct, brand, reference, datePurchase, price, stock
        );
    }
}
