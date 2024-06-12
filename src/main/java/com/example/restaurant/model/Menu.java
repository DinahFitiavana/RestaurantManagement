package com.example.restaurant.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Menu {
    private int id;
    private String name;
    private int idPrice;
    private int idRestaurant;
}
