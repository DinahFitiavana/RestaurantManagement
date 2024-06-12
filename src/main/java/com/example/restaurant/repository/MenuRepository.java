package com.example.restaurant.repository;

import com.example.restaurant.model.Menu;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface MenuRepository {
    List<Menu> getAllMenu() throws SQLException;
    Menu getMenuById(int id) throws SQLException;
    Menu createMenu(Menu menu) throws SQLException;
    Menu updateMenu(int id, Menu menu) throws SQLException;
}
