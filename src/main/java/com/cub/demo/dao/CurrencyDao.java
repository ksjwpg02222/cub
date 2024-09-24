package com.cub.demo.dao;

import java.util.Optional;

import com.cub.demo.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public class CurrencyDao {
    public interface Jpa extends JpaRepository<Currency, Long> {
        Optional<Currency> findByCode(String code);
    }
}
