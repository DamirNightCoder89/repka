package com.someday.somework.feign.clients;

import com.someday.somework.feign.fallbacks.RateClientFallback;
import com.someday.somework.feign.fallbacks.RateHystrixClientFallbackFactory;
import com.someday.somework.feign.model.ExcRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@FeignClient(name="exchange-rates-client", url = "${repka.money.url}", fallbackFactory = RateHystrixClientFallbackFactory.class) //fallback = RateClientFallback.class
public interface ExchangeRatesClient {

    @GetMapping("/latest.json")
    Optional<ExcRates> getCurrentRates(@RequestParam("app_id") String appid);

    @GetMapping("/latest.json")
    String getString();

//    @GetMapping("/historical/{date}.json")
//    ExcRates getНesterdaysRate(@RequestParam("appid") String appid,
//                               @PathVariable String date);

//    @Component
//    public static class Crfall implements ExchangeRatesClient{
//
//        @Override
//        public Optional<ExcRates> getCurrentRates(String appid) {
//            System.out.println("dfsdfsdfsfs!!!!!!!!!!!!!!!!!!");
//            return Optional.empty();
//        }
//
//        @Override
//        public String getString() {
//            System.out.println("dfsdfsdfsfs!!!!!!!!!!!!!!!!!!");
//            return "her";
//        }
//    }

}

