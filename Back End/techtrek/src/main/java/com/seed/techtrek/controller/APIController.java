package com.seed.techtrek.controller;


import com.seed.techtrek.entity.ExchangeRate;
import com.seed.techtrek.entity.User;
import com.seed.techtrek.model.request.LoginRequest;
import com.seed.techtrek.model.response.AllExchangeRateResponse;
import com.seed.techtrek.model.response.LoginResponse;
import com.seed.techtrek.repository.ExchangeRateRepository;
import com.seed.techtrek.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class APIController {

    private final UserRepository userRepository;

    private final ExchangeRateRepository exchangeRateRepository;

    public APIController(UserRepository userRepository, ExchangeRateRepository exchangeRateRepository) {
        this.userRepository = userRepository;
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null){
            return LoginResponse.builder()
                    .status("SUCCESS")
                    .name(user.getName())
                    .build();
        }
        return LoginResponse.builder()
                .status("FAILED")
                .build();
    }

    @RequestMapping(value="/home", method=RequestMethod.POST)
    public User getWallet(@RequestBody User user) {
        return user;
    }

    @RequestMapping(value="/allExchangeRate", method=RequestMethod.GET)
    public AllExchangeRateResponse getAllExchangeRate() {
        ArrayList<ExchangeRate> allExchangeRate = exchangeRateRepository.getAllExchangeRate();
        return AllExchangeRateResponse.builder()
                .status("SUCCESS")
                .allExchangeRate(allExchangeRate)
                .build();
    }

    @RequestMapping(value="/countryExchangeRate", method=RequestMethod.POST)
    public ArrayList<Float> getCountryExchangeRate(@RequestBody String country) {
        return new ArrayList<>();
    }
}
