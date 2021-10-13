package com.someday.somework.controllers;

import com.someday.somework.feign.clients.ExchangeRatesClient;
import com.someday.somework.feign.model.ExcRates;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    String APPID = "b65376061a4b4d7e99351fa193b3e6fd";

    private final ExchangeRatesClient excClient;

    @GetMapping("/latest.json")
    ExcRates getCurrentRates() {
        return excClient.getCurrentRates(APPID);
    }

//    @GetMapping("/historical/{date}.json")
//    ExcRates getНesterdaysRate(@RequestParam("appid") String appid,
//                               @PathVariable String date) {
//
//    }


}
