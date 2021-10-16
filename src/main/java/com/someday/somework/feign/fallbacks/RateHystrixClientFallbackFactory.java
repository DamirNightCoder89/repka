package com.someday.somework.feign.fallbacks;

import com.someday.somework.feign.clients.ExchangeRatesClient;
import com.someday.somework.feign.model.ExcRates;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RateHystrixClientFallbackFactory implements FallbackFactory<ExchangeRatesClient> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ExchangeRatesClient create(Throwable cause) {

        String httpStatus = cause instanceof FeignException ? Integer.toString(((FeignException) cause).status()) : "";

        return new ExchangeRatesClient() {
            @Override
            public Optional<ExcRates> getCurrentRates(String appid) {

                return Optional.empty();
            }

            @Override
            public String getString() {
                logger.error(httpStatus);
                return cause.getMessage();
            }
        };
    }
}
