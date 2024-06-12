package com.example.restaurant.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IngredientMenu {
    private int id;
    private double quantity;
    private int idMEnu;
    private int idIngredient;
}
