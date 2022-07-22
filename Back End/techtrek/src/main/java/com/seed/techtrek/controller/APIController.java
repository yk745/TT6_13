package com.seed.techtrek.controller;


import com.seed.techtrek.entity.ExchangeRate;
import com.seed.techtrek.entity.User;
import com.seed.techtrek.entity.Wallet;
import com.seed.techtrek.model.request.ExchangeRateRequest;
import com.seed.techtrek.model.request.LoginRequest;
import com.seed.techtrek.model.request.WalletRequest;
import com.seed.techtrek.model.response.LoginResponse;
import com.seed.techtrek.repository.ExchangeRateRepository;
import com.seed.techtrek.repository.UserRepository;
import com.seed.techtrek.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class APIController {

    private final UserRepository userRepository;
    private final ExchangeRateRepository exchangeRateRepository;
    private final WalletRepository walletRepository;

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return LoginResponse.builder()
                    .status("SUCCESS")
                    .name(user.getName())
                    .build();
        }
        return LoginResponse.builder()
                .status("FAILED")
                .build();
    }

    @PostMapping(value = "/home")
    public List<Wallet> getWallet(@RequestBody WalletRequest walletRequest) {
        User user = userRepository.findByName(walletRequest.getName());
        return walletRepository.findByUserId(user.getId());
    }

    @GetMapping(value = "/exchangeRate")
    public List<ExchangeRate> getExchangeRate() {
        return exchangeRateRepository.findAll();
    }

    @PostMapping(value = "/countryExchangeRate")
    public ExchangeRate getCountryExchangeRate(@RequestBody ExchangeRateRequest request) {
        return exchangeRateRepository.findByExchangeCurrency(request.getCountry());
    }
}
