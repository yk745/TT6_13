package com.seed.techtrek.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue
    private Integer id;
    @JsonProperty("user_id")
    private Integer userId;
    private String name;

    @OneToOne(mappedBy = "wallet")
    private Currency currency;
    @OneToOne(mappedBy = "wallet")
    private Transaction transaction;
}
