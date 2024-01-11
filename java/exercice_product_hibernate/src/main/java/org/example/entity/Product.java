package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "T_Product")
@NoArgsConstructor
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


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> images;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;

    @ManyToMany(mappedBy = "products")
    private List<Command> commands;


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
