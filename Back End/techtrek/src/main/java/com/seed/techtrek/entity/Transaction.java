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
    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debit_id", referencedColumnName = "id")
    private Currency currencyDebit;
    @JsonProperty("debit_currency")
    private String debitCurrency;
    @JsonProperty("debit_amount")
    private Float debitAmount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_id", referencedColumnName = "id")
    private Currency credit_id;
    @JsonProperty("credit_currency")
    private String creditCurrency;
    @JsonProperty("credit_amount")
    private Float creditAmount;
    private String description;
}
