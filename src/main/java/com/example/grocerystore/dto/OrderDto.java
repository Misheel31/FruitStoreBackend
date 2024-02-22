package com.example.grocerystore.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    @NotNull
    private String name;

    @NotNull
    private Integer userID;

    @NotNull
    private String price;

    @NotNull
    private int quantity;
}
