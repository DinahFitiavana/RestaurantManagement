package com.example.restaurant.controller;

import com.example.restaurant.model.Price;
import com.example.restaurant.service.PriceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class PriceController {
    private final PriceService priceService;
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/price")
    public List<Price> getAllPrice() throws SQLException {
        return priceService.getAllPrice();
    }

    @GetMapping("/price/{id}")
    public Price getPriceById(int id) throws SQLException{
        return priceService.getPriceById(id);
    }

    @PostMapping("/price")
    public Price createPrice(Price price) throws SQLException{
        return priceService.createPrice(price);
    }

    @PutMapping("/price/{id}")
    public Price updatePrice(int id, Price price) throws SQLException{
        return priceService.updatePrice(id, price);
    }
}
