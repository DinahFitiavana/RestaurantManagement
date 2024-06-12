package com.example.restaurant.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    private int id;
    private String name;
    private double price;
    private int idUnit;
}
