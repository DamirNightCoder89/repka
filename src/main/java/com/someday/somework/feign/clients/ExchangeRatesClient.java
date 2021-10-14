package com.someday.somework.feign.clients;

import com.someday.somework.feign.model.ExcRates;
import feign.FeignException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name="exchange-rates-client", url = "${repka.money.url}", fallback = ExchangeRatesClient.RateClientFallbackFactory.class)
public interface ExchangeRatesClient {

    @GetMapping("/latest.json")
    Optional<ExcRates> getCurrentRates(@RequestParam("app_id") String appid);

//    @GetMapping("/historical/{date}.json")
//    ExcRates getНesterdaysRate(@RequestParam("appid") String appid,
//                               @PathVariable String date);

    @Component
    static class RateClientFallbackFactory implements FallbackFactory<ExchangeRatesClient> {


        @Override
        public ExchangeRatesClient create(Throwable cause) {
            String httpStatus = cause instanceof FeignException ? Integer.toString(((FeignException) cause).status()) : "";

            return new ExchangeRatesClient() {
                @Override
                public Optional<ExcRates> getCurrentRates(String appid) {
                    System.out.println(httpStatus);
                    return Optional.empty();
                }
            };
        }
    }

}

