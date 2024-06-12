package com.example.restaurant.service;

import com.example.restaurant.model.StockMovement;
import com.example.restaurant.repository.StockMovementRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StockMovementService {
    private final StockMovementRepository stockMovementRepository;
    public StockMovementService(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    public List<StockMovement> getAllStockMovement() throws SQLException{
        return stockMovementRepository.getAllStockMovement();
    }

    public StockMovement getStockMovementById(int id) throws SQLException{
        return stockMovementRepository.getStockMovementById(id);
    }

    public StockMovement createStockMovement(StockMovement stockMovement) throws SQLException{
        return stockMovementRepository.createStockMovement(stockMovement);
    }

    public StockMovement updateStockMovement(int id, StockMovement stockMovement) throws SQLException{
        return stockMovementRepository.updateStockMovement(id, stockMovement);
    }
}
