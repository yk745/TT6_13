package com.seed.techtrek.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seed.techtrek.entity.audit.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction extends Auditable {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debit_id", referencedColumnName = "id")
    private Currency currencyDebit;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_id", referencedColumnName = "id")
    private Currency credit_id;
    @JsonProperty("debit_amount")
    private Float debitAmount;
    @JsonProperty("credit_currency")
    private String creditCurrency;
    @JsonProperty("credit_amount")
    private Float creditAmount;
    private String description;
}
