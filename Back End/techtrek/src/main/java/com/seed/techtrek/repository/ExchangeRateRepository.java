package com.seed.techtrek.repository;

import com.seed.techtrek.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {

    ExchangeRate findByExchangeCurrency(String country);
}
