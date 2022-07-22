package com.seed.techtrek.controller;


import com.seed.techtrek.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class APIController {


    @RequestMapping(value="/login", method=RequestMethod.POST)
    public User getCustomerIds(@RequestBody User user) {
        return user;
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
