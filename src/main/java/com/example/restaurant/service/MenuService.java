package com.example.restaurant.service;

import com.example.restaurant.model.Menu;
import com.example.restaurant.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenu() throws SQLException{
        return menuRepository.getAllMenu();
    }

    public Menu getMenuById(int id) throws SQLException{
        return menuRepository.getMenuById(id);
    }

    public Menu createMenu(Menu menu) throws SQLException{
        return menuRepository.createMenu(menu);
    }

    public Menu updateMenu(int id, Menu menu) throws SQLException{
        return menuRepository.updateMenu(id, menu);
    }
}
