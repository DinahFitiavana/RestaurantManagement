package com.example.restaurant.repository;

import com.example.restaurant.config.ConnectToDatabase;
import com.example.restaurant.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    private final ConnectToDatabase connectToDatabase = ConnectToDatabase.getInstance();
    private final Connection connection = connectToDatabase.getConnection();

    @Override
    public List<Ingredient> getAllIngredient() throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        String query = "SELECT * FROM ingredient";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Ingredient ingredient = mapResultSetToIngredient(resultSet);
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    @Override
    public Ingredient getIngredientById(int id) throws SQLException {
        String query = "SELECT * FROM ingredient WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToIngredient(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) throws SQLException {
        String query = "INSERT INTO ingredient (id, name, price, id_unit) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, ingredient.getId());
            preparedStatement.setString(2, ingredient.getName());
            preparedStatement.setFloat(3, (float) ingredient.getPrice());
            preparedStatement.setInt(4, ingredient.getIdUnit());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        ingredient.setId(generatedKeys.getInt(1));
                        return ingredient;
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
    public Ingredient updateIngredient(int id, Ingredient ingredient) throws SQLException {
        String query = "UPDATE ingredient SET id = ?, name = ?, price = ?, id_unit = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ingredient.getId());
            preparedStatement.setString(2, ingredient.getName());
            preparedStatement.setFloat(3, (float) ingredient.getPrice());
            preparedStatement.setInt(4, ingredient.getIdUnit());
            preparedStatement.setInt(5, ingredient.getId());
            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return ingredient;
            }
        }
        return null;
    }

    private Ingredient mapResultSetToIngredient(ResultSet resultSet) throws SQLException{
        Ingredient ingredient = new Ingredient();
        ingredient.setId(resultSet.getInt("id"));
        ingredient.setName(resultSet.getString("name"));
        ingredient.setPrice(resultSet.getFloat("price"));
        ingredient.setIdUnit(resultSet.getInt("id_unit"));
        return ingredient;
    }
}
