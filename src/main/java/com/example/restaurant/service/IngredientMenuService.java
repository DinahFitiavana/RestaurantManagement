package com.example.restaurant.service;

import com.example.restaurant.model.IngredientMenu;
import com.example.restaurant.repository.IngredientMenuRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class IngredientMenuService {
    private final IngredientMenuRepository ingredientMenuRepository;
    public IngredientMenuService(IngredientMenuRepository ingredientMenuRepository) {
        this.ingredientMenuRepository = ingredientMenuRepository;
    }

    public List<IngredientMenu> getAllIngredientMenu() throws SQLException{
        return ingredientMenuRepository.getAllIngredientMenu();
    }

    public IngredientMenu getIngredientMenuById(int id) throws SQLException{
        return ingredientMenuRepository.getIngredientMenuById(id);
    }

    public IngredientMenu createIngredientMenu(IngredientMenu ingredientMenu) throws SQLException{
        return ingredientMenuRepository.createIngredientMenu(ingredientMenu);
    }

    public IngredientMenu updateIngredientMenu(int id, IngredientMenu ingredientMenu) throws SQLException{
        return ingredientMenuRepository.updateIngredientMenu(id, ingredientMenu);
    }
}
