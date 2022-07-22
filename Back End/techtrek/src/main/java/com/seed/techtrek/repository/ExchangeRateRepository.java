package com.seed.techtrek.repository;

import com.seed.techtrek.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {

    ExchangeRate findExchangeRateByCountry(String country);

    ArrayList<ExchangeRate> getAllExchangeRate();
}
