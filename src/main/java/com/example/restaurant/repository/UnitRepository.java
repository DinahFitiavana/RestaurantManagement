package com.example.restaurant.repository;

import com.example.restaurant.model.Unit;

import java.sql.SQLException;
import java.util.List;

public interface UnitRepository {
    List<Unit> getAllUnit() throws SQLException;
    Unit getUnitById(int id) throws SQLException;
    Unit createUnit(Unit unit) throws SQLException;
    Unit updateUnit(int id, Unit unit) throws SQLException;
}
