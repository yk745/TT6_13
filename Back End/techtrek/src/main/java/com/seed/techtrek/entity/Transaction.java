package com.seed.techtrek.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seed.techtrek.entity.audit.Auditable;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
public class Transaction extends Auditable {

    public Transaction(Wallet wallet, Currency currencyDebit, String debitCurrency, Float debitAmount, Currency currencyCredit, String creditCurrency, Float creditAmount, String description, String createdAt) {
        this.wallet = wallet;
        this.currencyDebit = currencyDebit;
        this.debitCurrency = debitCurrency;
        this.debitAmount = debitAmount;
        this.currencyCredit = currencyCredit;
        this.creditCurrency = creditCurrency;
        this.creditAmount = creditAmount;
        this.description = description;
        this.createdAt = createdAt;
    }

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
    private Currency currencyCredit;
    @JsonProperty("credit_currency")
    private String creditCurrency;
    @JsonProperty("credit_amount")
    private Float creditAmount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

}
