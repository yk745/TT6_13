package com.seed.techtrek.controller;


import com.seed.techtrek.entity.*;
import com.seed.techtrek.model.request.ExchangeRateRequest;
import com.seed.techtrek.model.request.LoginRequest;
import com.seed.techtrek.model.request.TransactionRequest;
import com.seed.techtrek.model.request.WalletRequest;
import com.seed.techtrek.model.response.LoginResponse;
import com.seed.techtrek.repository.*;
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
    private final TransactionRepository transactionRepo;
    private final CurrencyRepository currencyRepository;

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

    @PostMapping(value = "/create/transaction")
    public void createTransaction(@RequestBody TransactionRequest request) {
        String user = request.getCreatedAt();
        // Find existing Wallet
        Integer userId = userRepository.findByName(user).getId();
        Wallet wallet = walletRepository.findByUserIdAndName(userId, request.getWalletName());
        // create Currency Credit
        Currency credit = new Currency(request.getCreditCurrency(), wallet);
        // create Currency Debit
        Currency debit = new Currency(request.getDebitCurrency(), wallet);

        Float creditRate = exchangeRateRepository.findByExchangeCurrency(request.getCreditCurrency()).getRate();
        Float debitRate = exchangeRateRepository.findByExchangeCurrency(request.getDebitCurrency()).getRate();

        Float debitAmt = request.getCreditAmount() / debitRate * creditRate;

        Transaction transaction = new Transaction(wallet, debit, request.getDebitCurrency(), debitAmt,
                credit, request.getCreditCurrency(), request.getCreditAmount(), request.getDescription(), user);

        currencyRepository.save(debit);
        currencyRepository.save(credit);
        transactionRepo.save(transaction);
    }
}
