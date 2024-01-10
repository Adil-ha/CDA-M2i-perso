package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "T_Command")
@NoArgsConstructor
@Getter
@Setter
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommand;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "T_Command_Product_Association",
            joinColumns = { @JoinColumn(name = "command_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private List<Product> products;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private LocalDate orderDate;

    @Override
    public String toString() {
        StringBuilder productsNames = new StringBuilder();
        for (Product product : products) {
            productsNames.append(product.getBrand()).append(" ").append(product.getReference()).append(", ");
        }

        return "Command{" +
                "idCommand=" + idCommand +
                ", products=" + productsNames.toString() +
                ", total=" + total +
                ", orderDate=" + orderDate +
                '}';
    }
}