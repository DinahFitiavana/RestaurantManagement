package com.example.restaurant.repository;

import com.example.restaurant.config.ConnectToDatabase;
import com.example.restaurant.model.Price;
import com.example.restaurant.model.Unit;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceRepositoryImpl implements PriceRepository{
    private final ConnectToDatabase connectToDatabase = ConnectToDatabase.getInstance();
    private final Connection connection = connectToDatabase.getConnection();

    @Override
    public List<Price> getAllPrice() throws SQLException {
        List<Price> prices = new ArrayList<>();
        String query = "SELECT * FROM price";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Price price = mapResultSetToPrice(resultSet);
                prices.add(price);
            }
        }
        return prices;
    }

    @Override
    public Price getPriceById(int id) throws SQLException {
        String query = "SELECT * FROM price WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToPrice(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Price createPrice(Price price) throws SQLException {
        String query = "INSERT INTO price (id, date, total_price, selling_price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, price.getId());
            preparedStatement.setDate(2, Date.valueOf(price.getDate()));
            preparedStatement.setDouble(3, price.getTotalPrice());
            preparedStatement.setDouble(4, price.getSellingPrice());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        price.setId(generatedKeys.getInt(1));
                        return price;
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
    public Price updatePrice(int id, Price price) throws SQLException {
        String query = "UPDATE price SET id = ?, date = ?, total_price = ?, selling_price = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, price.getId());
            preparedStatement.setDate(2, Date.valueOf(price.getDate()));
            preparedStatement.setDouble(3, price.getTotalPrice());
            preparedStatement.setDouble(4, price.getSellingPrice());
            preparedStatement.setInt(5, price.getId());
            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return price;
            }
        }
        return null;
    }

    private Price mapResultSetToPrice(ResultSet resultSet) throws SQLException{
        Price price = new Price();
        price.setId(resultSet.getInt("id"));
        price.setDate(resultSet.getDate("date").toLocalDate());
        price.setTotalPrice(resultSet.getDouble("total_price"));
        price.setSellingPrice(resultSet.getDouble("selling_price"));
        return price;
    }
}
