package com.seed.techtrek.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue
    private Integer id;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("name")
    private String name;

    @OneToMany(mappedBy = "wallet")
    @JsonProperty("currencies")
    private List<Currency> currencies;
    @OneToMany(mappedBy = "wallet")
    @JsonProperty("transactions")
    private List<Transaction> transactions;
}
