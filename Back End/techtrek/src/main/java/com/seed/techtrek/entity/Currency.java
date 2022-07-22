package com.seed.techtrek.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private Float amount;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;
}
