package com.example.restaurant.controller;

import com.example.restaurant.model.StockMovement;
import com.example.restaurant.service.StockMovementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class StockMovementController {
    private final StockMovementService stockMovementService;
    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @GetMapping("/stockMovement")
    public List<StockMovement> getAllStockMovement() throws SQLException {
        return stockMovementService.getAllStockMovement();
    }

    @GetMapping("/stockMovement/{id}")
    public StockMovement getStockMovementById(int id) throws SQLException{
        return stockMovementService.getStockMovementById(id);
    }

    @PostMapping("/stockMovement")
    public StockMovement createStockMovement(StockMovement stockMovement) throws SQLException{
        return stockMovementService.createStockMovement(stockMovement);
    }

    @PutMapping("/stockMovement/{id}")
    public StockMovement updateStockMovement(int id, StockMovement stockMovement) throws SQLException{
        return stockMovementService.updateStockMovement(id, stockMovement);
    }
}
