package com.example.restaurant.repository;

import com.example.restaurant.config.ConnectToDatabase;
import com.example.restaurant.model.Unit;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UnitRepositoryImpl implements UnitRepository{
    private final ConnectToDatabase connectToDatabase = ConnectToDatabase.getInstance();
    private final Connection connection = connectToDatabase.getConnection();

    @Override
    public List<Unit> getAllUnit() throws SQLException {
        List<Unit> units = new ArrayList<>();
        String query = "SELECT * FROM unit";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Unit unit = mapResultSetToUnit(resultSet);
                units.add(unit);
            }
        }
        return units;
    }

    @Override
    public Unit getUnitById(int id) throws SQLException {
        String query = "SELECT * FROM unit WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUnit(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Unit createUnit(Unit unit) throws SQLException {
        String query = "INSERT INTO unit (id, name) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, unit.getId());
            preparedStatement.setString(2, unit.getName());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        unit.setId(generatedKeys.getInt(1));
                        return unit;
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
    public Unit updateUnit(int id, Unit unit) throws SQLException {
        String query = "UPDATE unit SET id = ?, name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, unit.getId());
            preparedStatement.setString(2, unit.getName());
            preparedStatement.setInt(3, unit.getId());
            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return unit;
            }
        }
        return null;
    }

    private Unit mapResultSetToUnit(ResultSet resultSet) throws SQLException{
        Unit unit = new Unit();
        unit.setId(resultSet.getInt("id"));
        unit.setName(resultSet.getString("name"));
        return unit;
    }
}
