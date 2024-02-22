package com.example.grocerystore.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Fruit")

public class FruitItem {
    @Id
    @SequenceGenerator(name="fruit_item_seq_gen",sequenceName = "fruit_item_fruitItemId_seq",allocationSize = 1)
    @GeneratedValue(generator="fruit_item_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;
    @Column(name = "FruitName", nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;
}
