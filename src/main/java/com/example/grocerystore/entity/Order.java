package com.example.grocerystore.entity;
import com.example.grocerystore.dto.FruitItemDto;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Orders")

public class Order {
    @Id
    @SequenceGenerator(name="order_item_seq_gen",sequenceName = "order_item_orderItemId_seq",allocationSize = 1)
    @GeneratedValue(generator="order_item_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer OrderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id" ,
            foreignKey = @ForeignKey(name = "FK_userId"))
    private User userID;

    @Column(name = "fruit_name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}


