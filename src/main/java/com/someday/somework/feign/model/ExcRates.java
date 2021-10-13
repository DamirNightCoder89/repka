package com.someday.somework.feign.model;

import lombok.Value;

import java.util.Map;

@Value
public class ExcRates {

    private Integer timestamp;
    private String base;
    private Map<String, Double> rates;

}
