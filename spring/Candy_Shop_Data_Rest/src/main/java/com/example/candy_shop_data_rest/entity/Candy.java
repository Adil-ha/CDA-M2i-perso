package com.example.candy_shop_data_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Candy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String magicalEffect;
    private int quantity;
    private double price;

    @ManyToMany(mappedBy = "candies", fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "candy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;


}
