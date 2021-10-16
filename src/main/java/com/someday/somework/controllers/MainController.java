package com.someday.somework.controllers;

import com.someday.somework.feign.clients.ExchangeRatesClient;
import com.someday.somework.feign.model.ExcRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MainController {

    String APPID = "fwffsdf";

    @Autowired
    private ExchangeRatesClient excClient;

    @GetMapping("/latest.json")
    Optional<ExcRates> getCurrentRates() {

        return excClient.getCurrentRates(APPID);
    }

    @GetMapping("/test")
    String test() {

        return excClient.getString();
    }

//    @GetMapping("/historical/{date}.json")
//    ExcRates getНesterdaysRate(@RequestParam("appid") String appid,
//                               @PathVariable String date) {
//
//    }


}
