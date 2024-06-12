package com.example.restaurant.repository;

import com.example.restaurant.model.IngredientMenu;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface IngredientMenuRepository{
    List<IngredientMenu> getAllIngredientMenu() throws SQLException;
    IngredientMenu getIngredientMenuById(int id) throws SQLException;
    IngredientMenu createIngredientMenu(IngredientMenu ingredientMenu) throws SQLException;
    IngredientMenu updateIngredientMenu(int id, IngredientMenu ingredientMenu) throws SQLException;
}
