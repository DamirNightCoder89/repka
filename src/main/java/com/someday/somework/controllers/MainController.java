package com.someday.somework.controllers;

import com.someday.somework.exeptions.RateNotFoundException;
import com.someday.somework.feign.clients.ExchangeRatesClient;
import com.someday.somework.feign.model.ExcRates;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MainController {

    String APPID = "fwffsdf";

    private final ExchangeRatesClient excClient;

    @GetMapping("/latest.json")
    Optional<ExcRates> getCurrentRates() {

        return excClient.getCurrentRates(APPID);
    }

//    @GetMapping("/historical/{date}.json")
//    ExcRates getНesterdaysRate(@RequestParam("appid") String appid,
//                               @PathVariable String date) {
//
//    }


}
