package com.someday.somework.feign.clients;

import com.someday.somework.feign.fallbacks.Fallback;
import com.someday.somework.feign.model.ExcRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name="exchange-rates-client", url = "${repka.money.url}", fallback = Fallback.class)
public interface ExchangeRatesClient {

    @GetMapping("/latest.json")
    Optional<ExcRates> getCurrentRates(@RequestParam("app_id") String appid);

//    @GetMapping("/historical/{date}.json")
//    ExcRates getНesterdaysRate(@RequestParam("appid") String appid,
//                               @PathVariable String date);

}
