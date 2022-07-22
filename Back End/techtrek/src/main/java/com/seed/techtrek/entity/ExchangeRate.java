package com.seed.techtrek.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {

    @Id
    @GeneratedValue
    private Integer id;
    @JsonProperty("base_currency")
    private String baseCurrency;
    @JsonProperty("exchange_currency")
    private String exchangeCurrency;
    @JsonProperty("rate")
    private Float rate;
}
