package com.example.restaurant.service;

import com.example.restaurant.model.Price;
import com.example.restaurant.repository.PriceRepository;
import com.example.restaurant.repository.PriceRepositoryImpl;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PriceService {
    private final PriceRepository priceRepository;
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAllPrice() throws SQLException{
        return priceRepository.getAllPrice();
    }

    public Price getPriceById(int id) throws SQLException{
        return priceRepository.getPriceById(id);
    }

    public Price createPrice(Price price) throws SQLException{
        return priceRepository.createPrice(price);
    }

    public Price updatePrice(int id, Price price) throws SQLException{
        return priceRepository.updatePrice(id, price);
    }
}
