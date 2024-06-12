package com.example.restaurant.repository;

import com.example.restaurant.model.IngredientMenu;
import com.example.restaurant.model.StockMovement;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface StockMovementRepository {
    List<StockMovement> getAllStockMovement() throws SQLException;
    StockMovement getStockMovementById(int id) throws SQLException;
    StockMovement createStockMovement(StockMovement stockMovement) throws SQLException;
    StockMovement updateStockMovement(int id, StockMovement stockMovement) throws SQLException;
}
