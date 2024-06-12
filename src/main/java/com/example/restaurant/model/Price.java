package com.example.restaurant.model;

import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Price {
    private int id;
    private LocalDate date;
    private double totalPrice;
    private double sellingPrice;
}
