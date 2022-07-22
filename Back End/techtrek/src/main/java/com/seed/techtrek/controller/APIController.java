package com.seed.techtrek.controller;


import com.seed.techtrek.entity.User;
import com.seed.techtrek.model.request.LoginRequest;
import com.seed.techtrek.model.response.LoginResponse;
import com.seed.techtrek.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class APIController {

    private final UserRepository userRepository;

    public APIController(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    @RequestMapping(value="/exchangeRate", method=RequestMethod.GET)
    public ArrayList<Float> getExchangeRate() {
        return new ArrayList<>();
    }
}
