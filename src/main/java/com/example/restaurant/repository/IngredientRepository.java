package com.example.restaurant.repository;

import com.example.restaurant.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface IngredientRepository {
    List<Ingredient> getAllIngredient() throws SQLException;
    Ingredient getIngredientById(int id) throws SQLException;
    Ingredient createIngredient(Ingredient ingredient) throws SQLException;
    Ingredient updateIngredient(int id, Ingredient ingredient) throws SQLException;
}
