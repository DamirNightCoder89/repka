package com.someday.somework.feign.fallbacks;

import com.someday.somework.feign.clients.ExchangeRatesClient;
import com.someday.somework.feign.model.ExcRates;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Fallback implements ExchangeRatesClient {
    @Override
    public Optional<ExcRates> getCurrentRates(String appid) {
        return Optional.empty();
    }
}
