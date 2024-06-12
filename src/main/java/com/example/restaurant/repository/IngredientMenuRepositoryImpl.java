package com.example.restaurant.repository;

import com.example.restaurant.config.ConnectToDatabase;
import com.example.restaurant.model.IngredientMenu;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientMenuRepositoryImpl implements IngredientMenuRepository{
    private final ConnectToDatabase connectToDatabase = ConnectToDatabase.getInstance();
    private final Connection connection = connectToDatabase.getConnection();

    @Override
    public List<IngredientMenu> getAllIngredientMenu() throws SQLException {
        List<IngredientMenu> ingredientMenus = new ArrayList<>();
        String query = "SELECT * FROM ingredient_menu";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                IngredientMenu ingredientMenu = mapResultSetToIngredientMenu(resultSet);
                ingredientMenus.add(ingredientMenu);
            }
        }
        return ingredientMenus;
    }

    @Override
    public IngredientMenu getIngredientMenuById(int id) throws SQLException {
        String query = "SELECT * FROM ingredient_menu WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToIngredientMenu(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public IngredientMenu createIngredientMenu(IngredientMenu ingredientMenu) throws SQLException {
        String query = "INSERT INTO ingredient_menu (id, quantity, id_menu, id_ingredient) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, ingredientMenu.getId());
            preparedStatement.setFloat(2, (float) ingredientMenu.getQuantity());
            preparedStatement.setInt(3, ingredientMenu.getIdMEnu());
            preparedStatement.setInt(4, ingredientMenu.getIdIngredient());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        ingredientMenu.setId(generatedKeys.getInt(1));
                        return ingredientMenu;
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
    public IngredientMenu updateIngredientMenu(int id, IngredientMenu ingredientMenu) throws SQLException {
        String query = "UPDATE ingredient_menu SET id = ?, quantity = ?, id_menu = ?, id_ingredient = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ingredientMenu.getId());
            preparedStatement.setFloat(2, (float) ingredientMenu.getQuantity());
            preparedStatement.setInt(3, ingredientMenu.getIdMEnu());
            preparedStatement.setInt(4, ingredientMenu.getIdIngredient());
            preparedStatement.setInt(5, ingredientMenu.getId());
            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return ingredientMenu;
            }
        }
        return null;
    }

    private IngredientMenu mapResultSetToIngredientMenu(ResultSet resultSet) throws SQLException{
        IngredientMenu ingredientMenu = new IngredientMenu();
        ingredientMenu.setId(resultSet.getInt("id"));
        ingredientMenu.setQuantity(resultSet.getFloat("quantity"));
        ingredientMenu.setIdMEnu(resultSet.getInt("id_menu"));
        ingredientMenu.setIdIngredient(resultSet.getInt("id_ingredient"));
        return ingredientMenu;
    }

}
