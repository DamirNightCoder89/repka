package com.someday.somework.feign.model;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@Data
public class ExcRates {

    private Long timestamp;
    private String data;
    private String base;
    private Map<String, Double> rates;
    private String error;
    private String status;

    public boolean isEmpty() {
        return rates == null ? true : false;
    }

    public static class ErrorExcRateBuilder {

        public static ExcRates createExcRates(String error, String status) {
            return new ExcRates(null,null, null, null, error, status);
        }

    }
}
