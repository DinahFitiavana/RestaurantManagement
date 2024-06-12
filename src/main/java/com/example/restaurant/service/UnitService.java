package com.example.restaurant.service;

import com.example.restaurant.model.Unit;
import com.example.restaurant.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UnitService {
    private final UnitRepository unitRepository;
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Unit> getAllUnit() throws SQLException{
        return unitRepository.getAllUnit();
    }

    public Unit getUnitById(int id) throws SQLException{
        return unitRepository.getUnitById(id);
    }

    public Unit createUnit(Unit unit) throws SQLException{
        return unitRepository.createUnit(unit);
    }

    public Unit updateUnit(int id, Unit unit) throws SQLException{
        return unitRepository.updateUnit(id, unit);
    }
}

