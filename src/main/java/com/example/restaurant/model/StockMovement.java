package com.example.restaurant.model;

import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockMovement {
    private int id;
    private String type;
    private double quantity;
    private Timestamp date;
    private int idIngredient;
}
