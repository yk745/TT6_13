package com.seed.techtrek.entity;

import javax.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;
    private String currency;
    private Float amount;
}
