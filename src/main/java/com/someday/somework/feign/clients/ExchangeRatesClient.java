package com.someday.somework.feign.clients;

import com.someday.somework.feign.fallbacks.RateHystrixClientFallbackFactory;
import com.someday.somework.feign.model.ExcRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name="exchange-rates-client", url = "${repka.money.url}", fallbackFactory = RateHystrixClientFallbackFactory.class) //fallback = RateClientFallback.class
public interface ExchangeRatesClient {

    @GetMapping("/latest.json")
    Optional<ExcRates> getCurrentRates(@RequestParam("app_id") String appid);

    @GetMapping("/historical/{date}.json")
    Optional<ExcRates> getYesterdaysRates(@RequestParam("app_id") String appid,
                               @PathVariable String date);

//    @Component
//    public static class Crfall implements ExchangeRatesClient{
//
//        @Override
//        public Optional<ExcRates> getCurrentRates(String appid) {
//            return Optional.empty();
//        }
//
//        @Override
//        public String getString() {
//            return "result";
//        }
//    }

}

