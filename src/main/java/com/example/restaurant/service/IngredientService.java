package com.example.restaurant.service;

import com.example.restaurant.model.Ingredient;
import com.example.restaurant.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredient() throws SQLException{
        return ingredientRepository.getAllIngredient();
    }

    public Ingredient getIngredientById(int id) throws SQLException{
        return ingredientRepository.getIngredientById(id);
    }

    public Ingredient createIngredient(Ingredient ingredient) throws SQLException{
        return ingredientRepository.createIngredient(ingredient);
    }

    public Ingredient updateIngredient(int id, Ingredient ingredient) throws SQLException{
        return ingredientRepository.updateIngredient(id, ingredient);
    }
}
