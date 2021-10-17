package com.someday.somework.feign.fallbacks;

import com.someday.somework.utils.StatusInspector;
import com.someday.somework.feign.clients.ExchangeRatesClient;
import com.someday.somework.feign.model.ExcRates;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RateHystrixClientFallbackFactory extends StatusInspector implements FallbackFactory<ExchangeRatesClient> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ExchangeRatesClient create(Throwable cause) {

        Integer httpStatus = cause instanceof FeignException ? ((FeignException) cause).status() : null;

        return new ExchangeRatesClient() {
            @Override
            public Optional<ExcRates> getCurrentRates(String appid) {
                logger.error(httpStatus.toString());
                logger.error(cause.getMessage());

                return Optional.of(ExcRates.ErrorExcRateBuilder.createExcRates(checkStatus(httpStatus), httpStatus.toString()));
            }

            @Override
            public Optional<ExcRates> getYesterdaysRates(String appid, String date) {
                logger.error(httpStatus.toString());
                logger.error(cause.getMessage());

                return Optional.of(ExcRates.ErrorExcRateBuilder.createExcRates(checkStatus(httpStatus), httpStatus.toString()));
            }
        };
    }
}
