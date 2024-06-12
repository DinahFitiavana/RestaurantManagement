package com.example.restaurant.controller;

import com.example.restaurant.model.Ingredient;
import com.example.restaurant.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class IngredientController {
    private final IngredientService ingredientService;
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredient")
    public List<Ingredient> getAllIngredient() throws SQLException {
        return ingredientService.getAllIngredient();
    }

    @GetMapping("/ingredient/{id}")
    public Ingredient getIngredientById(int id) throws SQLException{
        return ingredientService.getIngredientById(id);
    }

    @PostMapping("/ingredient")
    public Ingredient createIngredient(Ingredient ingredient) throws SQLException{
        return ingredientService.createIngredient(ingredient);
    }

    @PutMapping("/ingredient/{id}")
    public Ingredient updateIngredient(int id, Ingredient ingredient) throws SQLException{
        return ingredientService.updateIngredient(id, ingredient);
    }
}
