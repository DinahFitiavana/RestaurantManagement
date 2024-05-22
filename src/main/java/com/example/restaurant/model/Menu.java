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
    private double unitPrice;
}
