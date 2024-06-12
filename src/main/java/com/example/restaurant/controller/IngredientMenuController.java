package com.example.restaurant.controller;

import com.example.restaurant.model.IngredientMenu;
import com.example.restaurant.service.IngredientMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class IngredientMenuController {
    private final IngredientMenuService ingredientMenuService;
    public IngredientMenuController(IngredientMenuService ingredientMenuService) {
        this.ingredientMenuService = ingredientMenuService;
    }

    @GetMapping("/ingredientMenu")
    public List<IngredientMenu> getAllIngredientMenu() throws SQLException {
        return ingredientMenuService.getAllIngredientMenu();
    }

    @GetMapping("/ingredientMenu/{id}")
    public IngredientMenu getIngredientMenuById(int id) throws SQLException{
        return ingredientMenuService.getIngredientMenuById(id);
    }

    @PostMapping("/ingredientMenu")
    public IngredientMenu createIngredientMenu(IngredientMenu ingredientMenu) throws SQLException{
        return ingredientMenuService.createIngredientMenu(ingredientMenu);
    }

    @PutMapping("/ingredientMenu/{id}")
    public IngredientMenu updateIngredientMenu(int id, IngredientMenu ingredientMenu) throws SQLException{
        return ingredientMenuService.updateIngredientMenu(id, ingredientMenu);
    }
}
