package com.example.restaurant.controller;

import com.example.restaurant.model.Menu;
import com.example.restaurant.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class MenuController {
    private final MenuService menuService;
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public List<Menu> getAllMenu() throws SQLException {
        return menuService.getAllMenu();
    }

    @GetMapping("/menu/{id}")
    public Menu getMenuById(int id) throws SQLException{
        return menuService.getMenuById(id);
    }

    @PostMapping("/menu")
    public Menu createMenu(Menu menu) throws SQLException{
        return menuService.createMenu(menu);
    }

    @PutMapping("/menu/{id}")
    public Menu updateMenu(int id, Menu menu) throws SQLException{
        return menuService.updateMenu(id, menu);
    }
}
