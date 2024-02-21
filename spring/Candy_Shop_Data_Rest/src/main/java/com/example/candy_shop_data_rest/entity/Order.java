package com.example.candy_shop_data_rest.entity;

import com.example.candy_shop_data_rest.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToMany
    private List<Candy> candies;

}
