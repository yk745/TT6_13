package com.seed.techtrek.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seed.techtrek.entity.ExchangeRate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllExchangeRateResponse {

    private String status;
    private ArrayList<ExchangeRate> allExchangeRate;

}
