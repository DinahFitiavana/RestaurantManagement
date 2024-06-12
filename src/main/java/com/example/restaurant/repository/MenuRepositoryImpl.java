package com.example.restaurant.repository;

import com.example.restaurant.config.ConnectToDatabase;
import com.example.restaurant.model.Menu;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository{
    private final ConnectToDatabase connectToDatabase = ConnectToDatabase.getInstance();
    private final Connection connection = connectToDatabase.getConnection();

    @Override
    public List<Menu> getAllMenu() throws SQLException {
        List<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM menu";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Menu menu = mapResultSetToMenu(resultSet);
                menus.add(menu);
            }
        }
        return menus;
    }

    @Override
    public Menu getMenuById(int id) throws SQLException {
        String query = "SELECT * FROM menu WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToMenu(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Menu createMenu(Menu menu) throws SQLException {
        String query = "INSERT INTO menu (id, name, idPrice, idRestaurant) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, menu.getId());
            preparedStatement.setString(2, menu.getName());
            preparedStatement.setInt(3, menu.getIdPrice());
            preparedStatement.setInt(4, menu.getIdRestaurant());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        menu.setId(generatedKeys.getInt(1));
                        return menu;
                    } else {
                        throw new SQLException("Failed to retrieve generated ID.");
                    }
                }
            } else {
                throw new SQLException("Failed to insert into database.");
            }
        }
    }

    @Override
    public Menu updateMenu(int id, Menu menu) throws SQLException {
        String query = "UPDATE menu SET id = ?, name = ?, id_price = ?, id_restaurant = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, menu.getId());
            preparedStatement.setString(2, menu.getName());
            preparedStatement.setInt(3, menu.getIdPrice());
            preparedStatement.setInt(4, menu.getIdRestaurant());
            preparedStatement.setInt(5, menu.getId());
            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return menu;
            }
        }
        return null;
    }

    private Menu mapResultSetToMenu(ResultSet resultSet) throws SQLException{
        Menu menu = new Menu();
        menu.setId(resultSet.getInt("id"));
        menu.setName(resultSet.getString("name"));
        menu.setIdPrice(resultSet.getInt("id_price"));
        menu.setIdRestaurant(resultSet.getInt("id_restaurant"));
        return menu;
    }
}
