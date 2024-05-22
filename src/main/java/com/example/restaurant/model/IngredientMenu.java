package com.example.restaurant.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ingredient {
    private int id;
    private String name;
    private double unitPrice;
}
