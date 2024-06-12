package com.example.restaurant.controller;

import com.example.restaurant.model.Unit;
import com.example.restaurant.service.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class UnitController {
    private final UnitService unitService;
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/unit")
    public List<Unit> getAllUnit() throws SQLException {
        return unitService.getAllUnit();
    }

    @GetMapping("/unit/{id}")
    public Unit getUnitById(int id) throws SQLException{
        return unitService.getUnitById(id);
    }

    @PostMapping("/unit")
    public Unit createUnit(Unit unit) throws SQLException{
        return unitService.createUnit(unit);
    }

    @PutMapping("/unit/{id}")
    public Unit updateUnit(int id, Unit unit) throws SQLException{
        return unitService.updateUnit(id, unit);
    }
}
