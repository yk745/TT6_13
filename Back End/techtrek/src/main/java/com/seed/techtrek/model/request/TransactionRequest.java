package com.seed.techtrek.model.request;

import lombok.Data;

@Data
public class TransactionRequest {

    private String createdAt;
    private Float creditAmount;
    private String creditCurrency;
    private String debitCurrency;
    private String description;
    private String walletName;
}
