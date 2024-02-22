package com.example.grocerystore.dto;

import lombok.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FruitItemDto {
    private Integer itemId;
    @NotNull
    private String itemName;
    @NotNull
    private String image;
    @NotNull
    private String price;
    @NotNull
    private int quantity;
    @NotNull
    private String description;

}
