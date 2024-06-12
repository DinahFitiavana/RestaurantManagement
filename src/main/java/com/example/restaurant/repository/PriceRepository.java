package com.example.restaurant.repository;

import com.example.restaurant.model.IngredientMenu;
import com.example.restaurant.model.Price;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface PriceRepository {
    List<Price> getAllPrice() throws SQLException;
    Price getPriceById(int id) throws SQLException;
    Price createPrice(Price price) throws SQLException;
    Price updatePrice(int id, Price price) throws SQLException;
}
